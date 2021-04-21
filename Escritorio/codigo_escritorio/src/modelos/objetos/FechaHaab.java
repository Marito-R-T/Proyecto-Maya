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
public class FechaHaab {
    
    private int id;
    private Nahual nahual;
    private Winal winal;
    private String nombre, descripcion;
    private Date fecha;
    private Cargador cargador;

    public FechaHaab() {
    }

    public FechaHaab(int id, Nahual nahual, Winal winal, String nombre, String descripcion, Date fecha, Cargador cargador) {
        this.id = id;
        this.nahual = nahual;
        this.winal = winal;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.cargador = cargador;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Nahual getNahual() {
        return nahual;
    }

    public void setNahual(Nahual nahual) {
        this.nahual = nahual;
    }

    public Winal getWinal() {
        return winal;
    }

    public void setWinal(Winal winal) {
        this.winal = winal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cargador getCargador() {
        return cargador;
    }

    public void setCargador(Cargador cargador) {
        this.cargador = cargador;
    }
    
}
