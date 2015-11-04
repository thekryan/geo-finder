package org.gkrajewski.geofinder.exceptions;

/**
 * Klasa wyj�tku wartwy DAO
 */
public class DAOException extends Exception {

    /**
     * Konstruktor.
     * 
     * @param e wyj�tek opakowywany.
     */
    public DAOException(Exception cause) {
        super(cause);
    }

    /**
     * Konstruktor.
     * 
     * @param message wiadomo�� opisuj�ca wyj�tek.
     */
    public DAOException(String message) {
        super(message);
    }

    /**
     * Konstruktor.
     * 
     * @param message wiadomo�� opisuj�ca wyj�tek.
     * @param cause wyj�tek �r�d�owy.
     */
    public DAOException(String message, Throwable cause) {
        super(message, cause);
    }

    private static final long serialVersionUID = 1L;

}
