package org.gkrajewski.geofinder.exceptions;

/**
 * Klasa wyj¹tku wartwy DAO
 */
public class DAOException extends Exception {

    /**
     * Konstruktor.
     * 
     * @param e wyj¹tek opakowywany.
     */
    public DAOException(Exception cause) {
        super(cause);
    }

    /**
     * Konstruktor.
     * 
     * @param message wiadomoœæ opisuj¹ca wyj¹tek.
     */
    public DAOException(String message) {
        super(message);
    }

    /**
     * Konstruktor.
     * 
     * @param message wiadomoœæ opisuj¹ca wyj¹tek.
     * @param cause wyj¹tek Ÿród³owy.
     */
    public DAOException(String message, Throwable cause) {
        super(message, cause);
    }

    private static final long serialVersionUID = 1L;

}
