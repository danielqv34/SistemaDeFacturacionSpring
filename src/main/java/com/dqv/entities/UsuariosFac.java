package com.dqv.entities;

import javax.persistence.*;

/**
 * Created by ezequ on 10/19/2016.
 */
@Entity
@Table(name = "USUARIOS_FAC", schema = "C##DQUIROZ", catalog = "")
public class UsuariosFac {
    private long id;
    private String nombres;
    private String apellidos;
    private String cedula;
    private String telefono;
    private String celular;
    private String correo;
    private String nombreUsuario;
    private String clave;
    private boolean rol;
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
    @Column(name = "NOMBRES", nullable = false, length = 50)
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    @Basic
    @Column(name = "APELLIDOS", nullable = false, length = 50)
    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @Basic
    @Column(name = "CEDULA", nullable = false, length = 11)
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    @Basic
    @Column(name = "TELEFONO", nullable = false, length = 10)
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Basic
    @Column(name = "CELULAR", nullable = false, length = 10)
    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    @Basic
    @Column(name = "CORREO", nullable = false, length = 50)
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Basic
    @Column(name = "NOMBRE_USUARIO", nullable = false, length = 25)
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    @Basic
    @Column(name = "CLAVE", nullable = false, length = 100)
    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Basic
    @Column(name = "ROL", nullable = false, precision = 0)
    public boolean isRol() {
        return rol;
    }

    public void setRol(boolean rol) {
        this.rol = rol;
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

        UsuariosFac that = (UsuariosFac) o;

        if (id != that.id) return false;
        if (rol != that.rol) return false;
        if (estado != that.estado) return false;
        if (nombres != null ? !nombres.equals(that.nombres) : that.nombres != null) return false;
        if (apellidos != null ? !apellidos.equals(that.apellidos) : that.apellidos != null) return false;
        if (cedula != null ? !cedula.equals(that.cedula) : that.cedula != null) return false;
        if (telefono != null ? !telefono.equals(that.telefono) : that.telefono != null) return false;
        if (celular != null ? !celular.equals(that.celular) : that.celular != null) return false;
        if (correo != null ? !correo.equals(that.correo) : that.correo != null) return false;
        if (nombreUsuario != null ? !nombreUsuario.equals(that.nombreUsuario) : that.nombreUsuario != null)
            return false;
        if (clave != null ? !clave.equals(that.clave) : that.clave != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (nombres != null ? nombres.hashCode() : 0);
        result = 31 * result + (apellidos != null ? apellidos.hashCode() : 0);
        result = 31 * result + (cedula != null ? cedula.hashCode() : 0);
        result = 31 * result + (telefono != null ? telefono.hashCode() : 0);
        result = 31 * result + (celular != null ? celular.hashCode() : 0);
        result = 31 * result + (correo != null ? correo.hashCode() : 0);
        result = 31 * result + (nombreUsuario != null ? nombreUsuario.hashCode() : 0);
        result = 31 * result + (clave != null ? clave.hashCode() : 0);
        result = 31 * result + (rol ? 1 : 0);
        result = 31 * result + (estado ? 1 : 0);
        return result;
    }
}
