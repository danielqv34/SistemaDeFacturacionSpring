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
public class Productos {
    private long id;
    private String nombre;
    private String descripcion;
    private String codigo;
    private long precioCompra;
    private long precioVenta;
    private String nota;
    private Time fechaInicioVenta;
    private Time fechaFinVenta;
    private boolean disponibleVenta;
    private Time fechaDiscontinuidad;
    private Time fechaModificacion;
    private boolean estado;

    @Id
    @Column(name = "ID", nullable = false, precision = 0)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NOMBRE", nullable = false, length = 100)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
    @Column(name = "CODIGO", nullable = false, length = 13)
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Basic
    @Column(name = "PRECIO_COMPRA", nullable = false, precision = 2)
    public long getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(long precioCompra) {
        this.precioCompra = precioCompra;
    }

    @Basic
    @Column(name = "PRECIO_VENTA", nullable = false, precision = 2)
    public long getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(long precioVenta) {
        this.precioVenta = precioVenta;
    }

    @Basic
    @Column(name = "NOTA", nullable = true, length = 1000)
    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    @Basic
    @Column(name = "FECHA_INICIO_VENTA", nullable = false)
    public Time getFechaInicioVenta() {
        return fechaInicioVenta;
    }

    public void setFechaInicioVenta(Time fechaInicioVenta) {
        this.fechaInicioVenta = fechaInicioVenta;
    }

    @Basic
    @Column(name = "FECHA_FIN_VENTA", nullable = true)
    public Time getFechaFinVenta() {
        return fechaFinVenta;
    }

    public void setFechaFinVenta(Time fechaFinVenta) {
        this.fechaFinVenta = fechaFinVenta;
    }

    @Basic
    @Column(name = "DISPONIBLE_VENTA", nullable = false, precision = 0)
    public boolean isDisponibleVenta() {
        return disponibleVenta;
    }

    public void setDisponibleVenta(boolean disponibleVenta) {
        this.disponibleVenta = disponibleVenta;
    }

    @Basic
    @Column(name = "FECHA_DISCONTINUIDAD", nullable = true)
    public Time getFechaDiscontinuidad() {
        return fechaDiscontinuidad;
    }

    public void setFechaDiscontinuidad(Time fechaDiscontinuidad) {
        this.fechaDiscontinuidad = fechaDiscontinuidad;
    }

    @Basic
    @Column(name = "FECHA_MODIFICACION", nullable = false)
    public Time getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Time fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    @Basic
    @Column(name = "ESTADO", nullable = false, precision = 0)
    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Productos productos = (Productos) o;

        if (id != productos.id) return false;
        if (precioCompra != productos.precioCompra) return false;
        if (precioVenta != productos.precioVenta) return false;
        if (disponibleVenta != productos.disponibleVenta) return false;
        if (estado != productos.estado) return false;
        if (nombre != null ? !nombre.equals(productos.nombre) : productos.nombre != null) return false;
        if (descripcion != null ? !descripcion.equals(productos.descripcion) : productos.descripcion != null)
            return false;
        if (codigo != null ? !codigo.equals(productos.codigo) : productos.codigo != null) return false;
        if (nota != null ? !nota.equals(productos.nota) : productos.nota != null) return false;
        if (fechaInicioVenta != null ? !fechaInicioVenta.equals(productos.fechaInicioVenta) : productos.fechaInicioVenta != null)
            return false;
        if (fechaFinVenta != null ? !fechaFinVenta.equals(productos.fechaFinVenta) : productos.fechaFinVenta != null)
            return false;
        if (fechaDiscontinuidad != null ? !fechaDiscontinuidad.equals(productos.fechaDiscontinuidad) : productos.fechaDiscontinuidad != null)
            return false;
        if (fechaModificacion != null ? !fechaModificacion.equals(productos.fechaModificacion) : productos.fechaModificacion != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        result = 31 * result + (codigo != null ? codigo.hashCode() : 0);
        result = 31 * result + (int) (precioCompra ^ (precioCompra >>> 32));
        result = 31 * result + (int) (precioVenta ^ (precioVenta >>> 32));
        result = 31 * result + (nota != null ? nota.hashCode() : 0);
        result = 31 * result + (fechaInicioVenta != null ? fechaInicioVenta.hashCode() : 0);
        result = 31 * result + (fechaFinVenta != null ? fechaFinVenta.hashCode() : 0);
        result = 31 * result + (disponibleVenta ? 1 : 0);
        result = 31 * result + (fechaDiscontinuidad != null ? fechaDiscontinuidad.hashCode() : 0);
        result = 31 * result + (fechaModificacion != null ? fechaModificacion.hashCode() : 0);
        result = 31 * result + (estado ? 1 : 0);
        return result;
    }
}
