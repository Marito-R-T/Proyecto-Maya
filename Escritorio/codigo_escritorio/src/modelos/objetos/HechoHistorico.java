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
public class HechoHistorico {
    
    private int id;
    private String titulo, autor, periodo, htmlCode, fechaInicio, fechaFin, AcI, AcF,categoria, descripcion;

    public HechoHistorico() {
    }

    public HechoHistorico(int id, String titulo, String autor, String periodo, String htmlCode, String fechaInicio, String fechaFin, String AcI, String AcF, String categoria, String descripcion) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.periodo = periodo;
        this.htmlCode = htmlCode;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.AcI = AcI;
        this.AcF = AcF;
        this.categoria = categoria;
        this.descripcion = descripcion;
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

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getHtmlCode() {
        return htmlCode;
    }

    public void setHtmlCode(String htmlCode) {
        this.htmlCode = htmlCode;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getAcI() {
        return AcI;
    }

    public void setAcI(String AcI) {
        this.AcI = AcI;
    }

    public String getAcF() {
        return AcF;
    }

    public void setAcF(String AcF) {
        this.AcF = AcF;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
    

    
}
