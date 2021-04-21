/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.objetos;

/**
 *
 * @author jose_
 */
public class FechaRuedaCalendarica {
    
    private int id;
    private FechaHaab fechaHaab;
    private FechaCholqij fechaCholqij;
    private String descripcion;

    public FechaRuedaCalendarica() {
    }

    public FechaRuedaCalendarica(int id, FechaHaab fechaHaab, FechaCholqij fechaCholqij, String descripcion) {
        this.id = id;
        this.fechaHaab = fechaHaab;
        this.fechaCholqij = fechaCholqij;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public FechaHaab getFechaHaab() {
        return fechaHaab;
    }

    public void setFechaHaab(FechaHaab fechaHaab) {
        this.fechaHaab = fechaHaab;
    }

    public FechaCholqij getFechaCholqij() {
        return fechaCholqij;
    }

    public void setFechaCholqij(FechaCholqij fechaCholqij) {
        this.fechaCholqij = fechaCholqij;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
