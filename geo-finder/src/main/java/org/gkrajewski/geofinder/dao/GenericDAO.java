package org.gkrajewski.geofinder.dao;

import javax.sql.DataSource;


/**
 * Klasa generyczna dla wszystkich klas wartwy DAO
 * 
 * @author kryan
 */
public abstract class GenericDAO {

    /**
     * Obiekt wykorzystywany do tworzenia po��czenia z baz� danych
     */
    DataSource dataSource;

    public GenericDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

}
