package org.gkrajewski.geofinder.model;

/**
 * Klasa modelowa reprezentuj¹ca obiekt lokalizacji geograficznej
 */
public class GeoObject {

    private Integer id;

    private String name;

    private String address;

    private Coordinates coords = new Coordinates();

    private String objectType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String placeName) {
        this.name = placeName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setCoords(Coordinates coords) {
        this.coords = coords;
    }

    public Coordinates getCoords() {
        return coords;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public String getObjectType() {
        return objectType;
    }

    public String toString() {

        StringBuilder str = new StringBuilder();
        str.append(getName()).append(" ");
        str.append(getAddress()).append(" ");
        str.append(getObjectType()).append(" ");
        str.append("longitude: " + getCoords().getLongitude()).append(" ");
        str.append("latitude: " + getCoords().getLatitude()).append(" ");
        str.append("\n");

        return address;
    }

}
