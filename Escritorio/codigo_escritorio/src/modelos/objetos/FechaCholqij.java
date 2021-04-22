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
public class FechaCholqij {
    
    private int id;
    private Nahual nahual;
    private Energia energia;
    private Date fecha;
    private String descripcion;

    public FechaCholqij() {
    }

    public FechaCholqij(int id, Nahual nahual, Energia energia, Date fecha, String descripcion) {
        this.id = id;
        this.nahual = nahual;
        this.energia = energia;
        this.fecha = fecha;
        this.descripcion = descripcion;
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

    public Energia getEnergia() {
        return energia;
    }

    public void setEnergia(Energia energia) {
        this.energia = energia;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
