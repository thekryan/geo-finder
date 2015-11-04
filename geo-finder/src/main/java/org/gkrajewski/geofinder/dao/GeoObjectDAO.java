package org.gkrajewski.geofinder.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.gkrajewski.geofinder.exceptions.DAOException;
import org.gkrajewski.geofinder.model.GeoObject;
import org.gkrajewski.geofinder.model.GeoObjectWithDistance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;


@Repository
public class GeoObjectDAO extends GenericDAO implements IGeoObjectDAO {

    private final static double LON_D = 111.321;
    private final static double LAT_D = 110.7835;

    String GET_ALL =
            "select g.id as id, g.name as name , g.address as address, X(g.coords) as longitude, Y(g.coords) as latitude, o.type_name as type_name from geo_objects g join object_types o on o.id = g.object_types_id;";

    @Autowired
    public GeoObjectDAO(@Qualifier("dataSource") DataSource dataSource) {
        super(dataSource);
    }

    /**
     * Tworzy zapytanie do wyszukiwania lokalizacji geograficznych
     * 
     * @param longitude d³ugoœæ geograficzna
     * @param latitude szerokoœæ geograficzna
     * @param distance odleg³oœæ
     * @return
     */
    private String getAllDistanceQuery(double longitude, double latitude, double distance) {
        StringBuilder query = new StringBuilder();
        query.append("select g.id as id, g.name as name , g.address as address, X(g.coords) as longitude, Y(g.coords) as latitude, o.type_name as type_name, great_circle_distance(?, ?, Y(g.coords), X(g.coords)) as distance ");
        query.append(" from geo_objects g join object_types o on o.id = g.object_types_id where g.object_types_id = ? ");
        query.append(" and  Intersects(g.coords, GeomFromText('");
        query.append(getPolygonString(longitude, latitude, distance));
        query.append("')) ");
        query.append("and great_circle_distance(?, ?, Y(g.coords), X(g.coords)) < ?;");
        return query.toString();
    }

    /**
     * Zwraca tekst WKT dla prostok¹ta ograniczaj¹cego, u¿ywanego przez indeks przestrzenny bazy danych
     * 
     * @param longitude d³ugoœæ geograficzna
     * @param latitude szerokoœæ geograficzna
     * @param dist odleg³oœæ
     * @return
     */
    private String getPolygonString(double longitude, double latitude, double dist) {

        double latitudeRad = Math.toRadians(latitude);

        double p1X = longitude - dist / (LON_D * Math.cos(latitudeRad + Math.toRadians(dist / LAT_D)));
        double p1Y = latitude + dist / LAT_D;

        double p2X = longitude + dist / (LON_D * Math.cos(latitudeRad + Math.toRadians(dist / LAT_D)));
        double p2Y = latitude + dist / LAT_D;

        double p3X = longitude + dist / (LON_D * Math.cos(latitudeRad - Math.toRadians(dist / LAT_D)));
        double p3Y = latitude - dist / LAT_D;

        double p4X = longitude - dist / (LON_D * Math.cos(latitudeRad - Math.toRadians(dist / LAT_D)));
        double p4Y = latitude - dist / LAT_D;

        StringBuilder str = new StringBuilder("Polygon((");
        str.append(p1X + " " + p1Y + ",");
        str.append(p2X + " " + p2Y + ",");
        str.append(p3X + " " + p3Y + ",");
        str.append(p4X + " " + p4Y + ",");
        str.append(p1X + " " + p1Y);
        str.append("))");

        return str.toString();
    }

    @Override
    public List<GeoObject> getAllGeoObjects() throws DAOException {

        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            Statement s = conn.createStatement();
            List<GeoObject> geoObjects = new ArrayList<GeoObject>();
            ResultSet rs = s.executeQuery(GET_ALL);
            while (rs.next()) {
                GeoObject geoObject = new GeoObject();
                geoObject.setId(rs.getInt("id"));
                geoObject.setName(rs.getString("name"));
                geoObject.setAddress(rs.getString("address"));
                geoObject.getCoords().setLongitude(rs.getDouble("longitude"));
                geoObject.getCoords().setLatitude(rs.getDouble("latitude"));
                geoObject.setObjectType(rs.getString("type_name"));
                geoObjects.add(geoObject);
            }
            rs.close();
            s.close();
            return geoObjects;
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {}
            }
        }
    }

    public List<GeoObjectWithDistance> getAllInDistance(double longitude, double latitude, double distance,
            int objectTypeId) throws DAOException {
        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement statement = conn.prepareStatement(getAllDistanceQuery(longitude, latitude, distance));
            int i = 0;
            statement.setDouble(++i, latitude);
            statement.setDouble(++i, longitude);
            statement.setInt(++i, objectTypeId);
            statement.setDouble(++i, latitude);
            statement.setDouble(++i, longitude);
            statement.setDouble(++i, distance);

            List<GeoObjectWithDistance> geoObjects = new ArrayList<GeoObjectWithDistance>();
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                GeoObjectWithDistance geoObject = new GeoObjectWithDistance();
                geoObject.setId(rs.getInt("id"));
                geoObject.setName(rs.getString("name"));
                geoObject.setAddress(rs.getString("address"));
                geoObject.getCoords().setLongitude(rs.getDouble("longitude"));
                geoObject.getCoords().setLatitude(rs.getDouble("latitude"));
                geoObject.setObjectType(rs.getString("type_name"));
                geoObject.setDistance(rs.getDouble("distance"));
                geoObjects.add(geoObject);
            }
            rs.close();
            statement.close();
            return geoObjects;
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {}
            }
        }
    }
}
