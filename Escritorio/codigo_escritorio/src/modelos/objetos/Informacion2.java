/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.objetos;

/**
 *
 * @author luisGonzalez
 */
public class Informacion2 {
    
    private int id;
    private String nombre;
    private int idCatCalendario;
    private String descWeb;
    private String descEscritorio;

    public Informacion2(int id, String nombre, int idCatCalendario, String descWeb, String descEscritorio) {
        this.id = id;
        this.nombre = nombre;
        this.idCatCalendario = idCatCalendario;
        this.descWeb = descWeb;
        this.descEscritorio = descEscritorio;
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

    public int getIdCatCalendario() {
        return idCatCalendario;
    }

    public void setIdCatCalendario(int idCatCalendario) {
        this.idCatCalendario = idCatCalendario;
    }

    public String getDescWeb() {
        return descWeb;
    }

    public void setDescWeb(String descWeb) {
        this.descWeb = descWeb;
    }

    public String getDescEscritorio() {
        return descEscritorio;
    }

    public void setDescEscritorio(String descEscritorio) {
        this.descEscritorio = descEscritorio;
    }
    
    
    
}
