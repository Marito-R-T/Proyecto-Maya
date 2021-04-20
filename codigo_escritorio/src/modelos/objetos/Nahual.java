/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.objetos;

import java.sql.Date;

/**
 *
 * @author jose_
 */
public class Nahual {
    
    private int id;
    private String nombre,nombreYucateco,nombreEsp, significado, descripcion;
    private Date fechaInicio, fechaFinalizacion;
    private Imagen imagen;

    public Nahual() {
    }

    public Nahual(int id, String nombre, Imagen imagen, String significado, String descripcion, Date fechaInicio, Date fechaFinalizacion, String nombreEsp, String nombreYucateco) {
        this.id = id;
        this.nombre = nombre;
        this.imagen = imagen;
        this.significado = significado;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFinalizacion = fechaFinalizacion;
        this.nombreYucateco = nombreYucateco;
        this.nombreEsp = nombreEsp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Imagen getImagen() {
        return imagen;
    }

    public void setImagen(Imagen imagen) {
        this.imagen = imagen;
    }

    public String getSignificado() {
        return significado;
    }

    public void setSignificado(String significado) {
        this.significado = significado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(Date fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public String getNombreYucateco() {
        return nombreYucateco;
    }

    public void setNombreYucateco(String nombreYucateco) {
        this.nombreYucateco = nombreYucateco;
    }

    public String getNombreEsp() {
        return nombreEsp;
    }

    public void setNombreEsp(String nombreEsp) {
        this.nombreEsp = nombreEsp;
    }
}
