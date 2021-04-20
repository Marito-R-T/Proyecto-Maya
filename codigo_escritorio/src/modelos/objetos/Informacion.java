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
public class Informacion {
    
    private int id;
    private String titulo, descripcionEscritorio, descripcionWeb;

    public Informacion() {
    }

    public Informacion(int id, String titulo, String descripcionEs, String descripcionWeb) {
        this.id = id;
        this.titulo = titulo;
        this.descripcionEscritorio = descripcionEs;
        this.descripcionWeb = descripcionWeb;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcionEscritorio() {
        return descripcionEscritorio;
    }

    public void setDescripcion(String descripcionEscritorio) {
        this.descripcionEscritorio = descripcionEscritorio;
    }

    public String getDescripcionWeb() {
        return descripcionWeb;
    }

    public void setDescripcionWeb(String descripcionWeb) {
        this.descripcionWeb = descripcionWeb;
    }
    
}
