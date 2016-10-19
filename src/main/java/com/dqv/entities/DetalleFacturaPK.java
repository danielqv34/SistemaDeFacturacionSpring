package com.dqv.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by ezequ on 10/19/2016.
 */
public class DetalleFacturaPK implements Serializable {
    private long id;
    private long idLineaFactura;

    @Column(name = "ID", nullable = false, precision = 0)
    @Id
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "ID_LINEA_FACTURA", nullable = false, precision = 0)
    @Id
    public long getIdLineaFactura() {
        return idLineaFactura;
    }

    public void setIdLineaFactura(long idLineaFactura) {
        this.idLineaFactura = idLineaFactura;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DetalleFacturaPK that = (DetalleFacturaPK) o;

        if (id != that.id) return false;
        if (idLineaFactura != that.idLineaFactura) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (idLineaFactura ^ (idLineaFactura >>> 32));
        return result;
    }
}
