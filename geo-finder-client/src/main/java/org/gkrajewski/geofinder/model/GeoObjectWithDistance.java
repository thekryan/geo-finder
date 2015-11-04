package org.gkrajewski.geofinder.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;


@XmlType(name = "GeoObjectWithDistance", propOrder = { "name", "address", "coords", "objectType", "distance" })
@XmlRootElement(name = "GeoObject")
public class GeoObjectWithDistance {

    private Integer id;

    private String name;

    private String address;

    private Coordinates coords = new Coordinates();

    private String objectType;

    private Double distance;

    @XmlTransient
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @XmlElement(name = "Name", required = true)
    public String getName() {
        return name;
    }

    public void setName(String placeName) {
        this.name = placeName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @XmlElement(name = "Address", required = true)
    public String getAddress() {
        return address;
    }

    public void setCoords(Coordinates coords) {
        this.coords = coords;
    }

    @XmlElement(name = "Coords", required = true)
    public Coordinates getCoords() {
        return coords;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    @XmlElement(name = "Type", required = true)
    public String getObjectType() {
        return objectType;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    @XmlElement(name = "Distance", required = true)
    public Double getDistance() {
        return distance;
    }

    public String toString() {

        StringBuilder str = new StringBuilder();
        str.append(getName()).append(" ");
        str.append(getAddress()).append(" ");
        str.append(getObjectType()).append(" ");
        str.append("longitude: " + getCoords().getLongitude()).append(" ");
        str.append("latitude: " + getCoords().getLatitude()).append(" ");
        str.append("distance: " + getDistance() + "\n");
        str.append("\n");

        return str.toString();
    }

}
