package org.gkrajewski.geofinder.service;

import java.util.List;

import org.gkrajewski.geofinder.exceptions.ServiceException;
import org.gkrajewski.geofinder.model.GeoObject;
import org.gkrajewski.geofinder.model.GeoObjectWithDistance;


public interface IGeoObjectService {

    /**
     * Pobiera wszystkie lokalizacje geograficzne z bazu danych
     * 
     * @return Lista obiekt�w lokalizacji geograficznych
     * @throws ServiceException
     */
    List<GeoObject> getAll() throws ServiceException;

    /**
     * Wyszukuje obiekty lokalizacji geograficznych z bazy danych dla podanych parametr�w.
     * 
     * @param longitude D�ugo�� geograficzna
     * @param latitude Szeroko�� geograficzna
     * @param distance Odleg�o�� w kilometrach
     * @param objectTypeId Id rodzaju lokalizacji
     * @return Lista obiekt�w lokalizacji geograficznych
     * @throws ServiceException
     */
    List<GeoObjectWithDistance> getAllInDistance(double longitude, double latitude, double distance, int objectTypeId)
            throws ServiceException;

}
