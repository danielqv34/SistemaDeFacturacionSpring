package com.dqv.entities;

import javax.persistence.*;

/**
 * Created by ezequ on 10/19/2016.
 */
@Entity
@Table(name = "DETALLE_FACTURA")
@IdClass(DetalleFacturaPK.class)
public class DetalleFactura {
    private long id;
    private long idLineaFactura;
    private String descripcion;
    private long cantidad;
    private long precioUnitario;
    private long precioTotal;

    @Id
    @Column(name = "ID", nullable = false, precision = 0)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Id
    @Column(name = "ID_LINEA_FACTURA", nullable = false, precision = 0)
    public long getIdLineaFactura() {
        return idLineaFactura;
    }

    public void setIdLineaFactura(long idLineaFactura) {
        this.idLineaFactura = idLineaFactura;
    }

    @Basic
    @Column(name = "DESCRIPCION", nullable = true, length = 150)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Basic
    @Column(name = "CANTIDAD", nullable = false, precision = 0)
    public long getCantidad() {
        return cantidad;
    }

    public void setCantidad(long cantidad) {
        this.cantidad = cantidad;
    }

    @Basic
    @Column(name = "PRECIO_UNITARIO", nullable = false, precision = 2)
    public long getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(long precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    @Basic
    @Column(name = "PRECIO_TOTAL", nullable = false, precision = 2)
    public long getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(long precioTotal) {
        this.precioTotal = precioTotal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DetalleFactura that = (DetalleFactura) o;

        if (id != that.id) return false;
        if (idLineaFactura != that.idLineaFactura) return false;
        if (cantidad != that.cantidad) return false;
        if (precioUnitario != that.precioUnitario) return false;
        if (precioTotal != that.precioTotal) return false;
        if (descripcion != null ? !descripcion.equals(that.descripcion) : that.descripcion != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (idLineaFactura ^ (idLineaFactura >>> 32));
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        result = 31 * result + (int) (cantidad ^ (cantidad >>> 32));
        result = 31 * result + (int) (precioUnitario ^ (precioUnitario >>> 32));
        result = 31 * result + (int) (precioTotal ^ (precioTotal >>> 32));
        return result;
    }
}
