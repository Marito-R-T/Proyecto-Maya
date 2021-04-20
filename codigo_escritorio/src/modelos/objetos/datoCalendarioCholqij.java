/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelos.objetos;

/**
 * 
 * @author Esmeralda
 */
public class datoCalendarioCholqij {
    int id;
    String titulo;
    String contenido;
    String urlImagen;

    public datoCalendarioCholqij(int id, String titulo, String contenido, String urlImagen) {
        this.id = id;
        this.titulo = titulo;
        this.contenido = contenido;
        this.urlImagen = urlImagen;
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

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }
    
    
    

}
