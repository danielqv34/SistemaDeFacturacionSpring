package com.dqv.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by ezequ on 10/19/2016.
 */
@Entity
public class Ciudad {
    private long id;
    private String nombreCiudad;

    @Basic
    @Column(name = "ID", nullable = false, precision = 0)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NOMBRE_CIUDAD", nullable = false, length = 50)
    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ciudad ciudad = (Ciudad) o;

        if (id != ciudad.id) return false;
        if (nombreCiudad != null ? !nombreCiudad.equals(ciudad.nombreCiudad) : ciudad.nombreCiudad != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (nombreCiudad != null ? nombreCiudad.hashCode() : 0);
        return result;
    }
}
