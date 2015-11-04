package org.gkrajewski.geofinder.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Klasa modelowa reprezentuj¹ca liste obiektów lokalizacji geograficznych
 */
@XmlType(name = "GeoObjectList")
@XmlRootElement(name = "GeoObjects")
public class GeoObjectList {

    private List<GeoObjectWithDistance> geoObjects = new ArrayList<GeoObjectWithDistance>();

    public void setGeoObjects(List<GeoObjectWithDistance> geoObjects) {
        this.geoObjects = geoObjects;
    }

    @XmlElement(name = "GeoObject")
    public List<GeoObjectWithDistance> getGeoObjects() {
        return geoObjects;
    }
}
