package org.gkrajewski.geofinder.service;

import java.util.List;

import org.gkrajewski.geofinder.exceptions.ServiceException;
import org.gkrajewski.geofinder.model.GeoObject;
import org.gkrajewski.geofinder.model.GeoObjectWithDistance;


public interface IGeoObjectService {

    /**
     * Pobiera wszystkie lokalizacje geograficzne z bazu danych
     * 
     * @return Lista obiektów lokalizacji geograficznych
     * @throws ServiceException
     */
    List<GeoObject> getAll() throws ServiceException;

    /**
     * Wyszukuje obiekty lokalizacji geograficznych z bazy danych dla podanych parametrów.
     * 
     * @param longitude D³ugoœæ geograficzna
     * @param latitude Szerokoœæ geograficzna
     * @param distance Odleg³oœæ w kilometrach
     * @param objectTypeId Id rodzaju lokalizacji
     * @return Lista obiektów lokalizacji geograficznych
     * @throws ServiceException
     */
    List<GeoObjectWithDistance> getAllInDistance(double longitude, double latitude, double distance, int objectTypeId)
            throws ServiceException;

}
