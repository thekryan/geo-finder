package org.gkrajewski.geofinder;

import java.util.Date;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;
import org.gkrajewski.geofinder.exceptions.ServiceException;
import org.gkrajewski.geofinder.model.GeoObjectWithDistance;
import org.gkrajewski.geofinder.service.GeoObjectService;
import org.gkrajewski.geofinder.service.SpringApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;


/**
 * Klasa testuj¹ca wydajnoœc czasow¹.
 */
public class TestStartupListener implements ServletContextListener {

    private Logger logger = Logger.getLogger(TestStartupListener.class);

    @Autowired
    private ApplicationContext appContext;

    @Override
    public void contextDestroyed(ServletContextEvent servletContext) {
    }

    @Override
    public void contextInitialized(ServletContextEvent servletContext) {

        logger.info("Testy");
        GeoObjectService geoService = SpringApplicationContext.getApplicationContext().getBean(GeoObjectService.class);

        try {
            // List<GeoObject> geoObjects = geoService.getAll();
            StringBuilder sb = new StringBuilder();
            double longitude = 20;
            double latitude = 50;
            double distance = 100;
            int objectTypeId = 1;
            for (double i = distance; i <= 2000; i += 100) {
                Long start = new Date().getTime();
                List<GeoObjectWithDistance> geoObjects =
                        geoService.getAllInDistance(longitude, latitude, distance, objectTypeId);
                Long end = new Date().getTime();
                long time = end - start;
                sb.append(String.format("Distance = %s\n Liczba obiektow: %d\n Czas: %d: \n\n", i, geoObjects.size(),
                        time));
            }

            logger.info(sb.toString());

        } catch (ServiceException e) {
            logger.error(e.getMessage(), e);
        }

    }

}
