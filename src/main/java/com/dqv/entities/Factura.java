package com.dqv.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Time;

/**
 * Created by ezequ on 10/19/2016.
 */
@Entity
public class Factura {
    private long id;
    private long numeroFactura;
    private Time fechaFactura;
    private Long itbis;
    private long montoParcial;
    private long montoTotal;

    @Id
    @Column(name = "ID", nullable = false, precision = 0)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NUMERO_FACTURA", nullable = false, precision = 0)
    public long getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(long numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    @Basic
    @Column(name = "FECHA_FACTURA", nullable = false)
    public Time getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(Time fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    @Basic
    @Column(name = "ITBIS", nullable = true, precision = 2)
    public Long getItbis() {
        return itbis;
    }

    public void setItbis(Long itbis) {
        this.itbis = itbis;
    }

    @Basic
    @Column(name = "MONTO_PARCIAL", nullable = false, precision = 2)
    public long getMontoParcial() {
        return montoParcial;
    }

    public void setMontoParcial(long montoParcial) {
        this.montoParcial = montoParcial;
    }

    @Basic
    @Column(name = "MONTO_TOTAL", nullable = false, precision = 2)
    public long getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(long montoTotal) {
        this.montoTotal = montoTotal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Factura factura = (Factura) o;

        if (id != factura.id) return false;
        if (numeroFactura != factura.numeroFactura) return false;
        if (montoParcial != factura.montoParcial) return false;
        if (montoTotal != factura.montoTotal) return false;
        if (fechaFactura != null ? !fechaFactura.equals(factura.fechaFactura) : factura.fechaFactura != null)
            return false;
        if (itbis != null ? !itbis.equals(factura.itbis) : factura.itbis != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (numeroFactura ^ (numeroFactura >>> 32));
        result = 31 * result + (fechaFactura != null ? fechaFactura.hashCode() : 0);
        result = 31 * result + (itbis != null ? itbis.hashCode() : 0);
        result = 31 * result + (int) (montoParcial ^ (montoParcial >>> 32));
        result = 31 * result + (int) (montoTotal ^ (montoTotal >>> 32));
        return result;
    }
}
