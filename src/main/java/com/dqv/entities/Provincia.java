package com.dqv.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by ezequ on 10/19/2016.
 */
@Entity
public class Provincia {
    private long id;
    private String nombreProvincia;
    private String capital;
    private String codigoProvincia;

    @Basic
    @Column(name = "ID", nullable = false, precision = 0)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NOMBRE_PROVINCIA", nullable = false, length = 20)
    public String getNombreProvincia() {
        return nombreProvincia;
    }

    public void setNombreProvincia(String nombreProvincia) {
        this.nombreProvincia = nombreProvincia;
    }

    @Basic
    @Column(name = "CAPITAL", nullable = false, length = 30)
    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    @Id
    @Column(name = "CODIGO_PROVINCIA", nullable = false, length = 2)
    public String getCodigoProvincia() {
        return codigoProvincia;
    }

    public void setCodigoProvincia(String codigoProvincia) {
        this.codigoProvincia = codigoProvincia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Provincia provincia = (Provincia) o;

        if (id != provincia.id) return false;
        if (nombreProvincia != null ? !nombreProvincia.equals(provincia.nombreProvincia) : provincia.nombreProvincia != null)
            return false;
        if (capital != null ? !capital.equals(provincia.capital) : provincia.capital != null) return false;
        if (codigoProvincia != null ? !codigoProvincia.equals(provincia.codigoProvincia) : provincia.codigoProvincia != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (nombreProvincia != null ? nombreProvincia.hashCode() : 0);
        result = 31 * result + (capital != null ? capital.hashCode() : 0);
        result = 31 * result + (codigoProvincia != null ? codigoProvincia.hashCode() : 0);
        return result;
    }
}
