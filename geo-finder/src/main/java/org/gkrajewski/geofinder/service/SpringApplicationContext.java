package org.gkrajewski.geofinder.service;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;


/**
 * Klasa udost�pniaj�ca obiekt ApplicationContext Springa, u�ywany do pobierania bean�w.
 */
public class SpringApplicationContext implements ApplicationContextAware {

    private static ApplicationContext CONTEXT;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("Setting application context");
        CONTEXT = applicationContext;

    }

    public static ApplicationContext getApplicationContext() {

        return CONTEXT;
    }

}
