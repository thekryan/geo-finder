package org.gkrajewski.geofinder.exceptions;

/**
 * Klasa wyj¹tku warstwy serwisu
 */
public class ServiceException extends Exception {

    private static final long serialVersionUID = 1L;

    /**
     * Konstruktor.
     */
    public ServiceException() {
        super();
    }

    /**
     * Konstruktor.
     * 
     * @param e wyj¹tek opakowywany.
     */
    public ServiceException(Exception e) {
        super(e);
    }

    /**
     * Konstruktor.
     * 
     * @param message treœæ komunikatu wyj¹tku.
     */
    public ServiceException(String message) {
        super(message);
    }

    /**
     * Konstruktor.
     * 
     * @param message treœæ komunikatu wyj¹tku.
     * @param cause wyj¹tek opakowywany.
     */
    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

}
