package org.gkrajewski.geofinder.service;

import java.util.List;

import org.gkrajewski.geofinder.dao.IGeoObjectDAO;
import org.gkrajewski.geofinder.exceptions.DAOException;
import org.gkrajewski.geofinder.exceptions.ServiceException;
import org.gkrajewski.geofinder.model.GeoObject;
import org.gkrajewski.geofinder.model.GeoObjectWithDistance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeoObjectService implements IGeoObjectService {

    @Autowired
    IGeoObjectDAO dao;

    @Override
    public List<GeoObject> getAll() throws ServiceException {
        try {
            return dao.getAllGeoObjects();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<GeoObjectWithDistance> getAllInDistance(double longitude, double latitude, double distance,
            int objectTypeId) throws ServiceException {

        try {
            return dao.getAllInDistance(longitude, latitude, distance, objectTypeId);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

}
