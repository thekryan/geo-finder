package org.gkrajewski.geofinder.exceptions;

/**
 * Klasa wyj�tku warstwy serwisu
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
     * @param e wyj�tek opakowywany.
     */
    public ServiceException(Exception e) {
        super(e);
    }

    /**
     * Konstruktor.
     * 
     * @param message tre�� komunikatu wyj�tku.
     */
    public ServiceException(String message) {
        super(message);
    }

    /**
     * Konstruktor.
     * 
     * @param message tre�� komunikatu wyj�tku.
     * @param cause wyj�tek opakowywany.
     */
    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

}
