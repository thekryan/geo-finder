package org.gkrajewski.geofinder.dao;

import java.util.List;

import org.gkrajewski.geofinder.exceptions.DAOException;
import org.gkrajewski.geofinder.model.GeoObject;
import org.gkrajewski.geofinder.model.GeoObjectWithDistance;


public interface IGeoObjectDAO {

    /**
     * Pobiera wszystkie lokalizacje geograficzne z bazu danych
     * 
     * @return Lista obiektów lokalizacji geograficznych
     * @throws DAOException
     */
    List<GeoObject> getAllGeoObjects() throws DAOException;

    /**
     * Wyszukuje obiekty lokalizacji geograficznych z bazy danych dla podanych parametrów.
     * 
     * @param longitude
     * @param latitude
     * @param distance
     * @param objectTypeId
     * @return Lista obiektów lokalizacji geograficznych
     * @throws DAOException
     */
    List<GeoObjectWithDistance> getAllInDistance(double longitude, double latitude, double distance, int objectTypeId)
            throws DAOException;

}
