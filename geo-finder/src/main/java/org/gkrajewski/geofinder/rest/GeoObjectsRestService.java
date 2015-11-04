package org.gkrajewski.geofinder.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import org.apache.log4j.Logger;
import org.gkrajewski.geofinder.exceptions.ServiceException;
import org.gkrajewski.geofinder.model.GeoObjectList;
import org.gkrajewski.geofinder.service.GeoObjectService;
import org.gkrajewski.geofinder.service.IGeoObjectService;
import org.gkrajewski.geofinder.service.SpringApplicationContext;


@Path("/geoobjects")
public class GeoObjectsRestService {

    IGeoObjectService geoService;
    private Logger logger = Logger.getLogger(GeoObjectsRestService.class);

    /**
     * Metoda webserwisowa dla wyszkiwania lokalizacji geograficznych
     * 
     * @param info Obiekt z parametrami zapytania
     * @return
     */
    @GET
    @Path("/query")
    @Produces(MediaType.APPLICATION_JSON)
    public GeoObjectList getGeoObjectsInDistance(@Context UriInfo info) {

        Double longitude = null;
        Double latitude = null;
        Double distance = null;
        Integer geoTypeId = null;

        longitude = new Double(info.getQueryParameters().getFirst("longitude"));
        latitude = new Double(info.getQueryParameters().getFirst("latitude"));
        distance = new Double(info.getQueryParameters().getFirst("distance"));
        String geoTypeIdStr = info.getQueryParameters().getFirst("type");

        if (geoTypeIdStr != null)
            geoTypeId = new Integer(geoTypeIdStr);
        else
            geoTypeId = 1;

        GeoObjectList geoObjects = new GeoObjectList();
        if (geoService == null)
            geoService = SpringApplicationContext.getApplicationContext().getBean(GeoObjectService.class);

        try {
            geoObjects.setGeoObjects(geoService.getAllInDistance(longitude, latitude, distance, geoTypeId));

        } catch (ServiceException e) {
            logger.error("Blad w metodzie web serwisowej: getGeoObjectsInDistance.", e);
            throw new RuntimeException(e.getMessage());
        }

        return geoObjects;

    }

}
