package com.dqv.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ezequ on 10/19/2016.
 */
@Entity
public class Provincia implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreProvincia;
    private String capital;
    private String codigoProvincia;

    @Id
    @Column(name = "ID", nullable = false, precision = 0)
    public int getId() {
        return id;
    }

    public void setId(int id) {
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


}
