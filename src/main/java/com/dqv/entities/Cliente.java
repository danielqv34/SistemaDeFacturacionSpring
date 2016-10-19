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
public class Cliente {
    private long id;
    private String nombres;
    private String apellidos;
    private String direccion;
    private Time fechaNacimiento;
    private long telefono;
    private String mail;
    private String categoria;
    private boolean estado;
    private Time fechaModificacion;

    @Id
    @Column(name = "ID", nullable = false, precision = 0)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NOMBRES", nullable = false, length = 40)
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    @Basic
    @Column(name = "APELLIDOS", nullable = false, length = 40)
    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @Basic
    @Column(name = "DIRECCION", nullable = false, length = 150)
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Basic
    @Column(name = "FECHA_NACIMIENTO", nullable = true)
    public Time getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Time fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Basic
    @Column(name = "TELEFONO", nullable = false, precision = 0)
    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    @Basic
    @Column(name = "MAIL", nullable = false, length = 50)
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Basic
    @Column(name = "CATEGORIA", nullable = false, length = 15)
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Basic
    @Column(name = "ESTADO", nullable = false, precision = 0)
    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Basic
    @Column(name = "FECHA_MODIFICACION", nullable = false)
    public Time getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Time fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cliente cliente = (Cliente) o;

        if (id != cliente.id) return false;
        if (telefono != cliente.telefono) return false;
        if (estado != cliente.estado) return false;
        if (nombres != null ? !nombres.equals(cliente.nombres) : cliente.nombres != null) return false;
        if (apellidos != null ? !apellidos.equals(cliente.apellidos) : cliente.apellidos != null) return false;
        if (direccion != null ? !direccion.equals(cliente.direccion) : cliente.direccion != null) return false;
        if (fechaNacimiento != null ? !fechaNacimiento.equals(cliente.fechaNacimiento) : cliente.fechaNacimiento != null)
            return false;
        if (mail != null ? !mail.equals(cliente.mail) : cliente.mail != null) return false;
        if (categoria != null ? !categoria.equals(cliente.categoria) : cliente.categoria != null) return false;
        if (fechaModificacion != null ? !fechaModificacion.equals(cliente.fechaModificacion) : cliente.fechaModificacion != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (nombres != null ? nombres.hashCode() : 0);
        result = 31 * result + (apellidos != null ? apellidos.hashCode() : 0);
        result = 31 * result + (direccion != null ? direccion.hashCode() : 0);
        result = 31 * result + (fechaNacimiento != null ? fechaNacimiento.hashCode() : 0);
        result = 31 * result + (int) (telefono ^ (telefono >>> 32));
        result = 31 * result + (mail != null ? mail.hashCode() : 0);
        result = 31 * result + (categoria != null ? categoria.hashCode() : 0);
        result = 31 * result + (estado ? 1 : 0);
        result = 31 * result + (fechaModificacion != null ? fechaModificacion.hashCode() : 0);
        return result;
    }
}
