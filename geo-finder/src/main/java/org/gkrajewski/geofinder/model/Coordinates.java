package org.gkrajewski.geofinder.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * Klasa modelowa reprezentuj¹ca wspó³rzêdne geograficzne
 */
@XmlRootElement(name = "Coordinates")
public class Coordinates {

    private Double longitude;
    private Double latitude;

    @XmlElement(name = "Longitude", required = true)
    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    @XmlElement(name = "Latitude", required = true)
    public Double getLatitude() {
        return latitude;
    }

}
