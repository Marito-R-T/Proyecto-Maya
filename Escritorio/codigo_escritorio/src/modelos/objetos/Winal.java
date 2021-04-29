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
public class Winal {

    private int id;
    private String nombre, descripcion;
    private Imagen imagen;

    
    private int idWeb, dias, idDesk;
    private String significado, htmlCodigo, categoria, ruta;
    
    public Winal() {
    }

    public Winal(int id, String nombre, String descripcion, Imagen imagen) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }
    
    
    public Winal(int idWeb, String nombre, String significado, int dias, String htmlCodigo, String categoria, int idDesk, Imagen imagen){
        this.idWeb = idWeb;
        this.nombre = nombre;
        this.significado = significado;
        this.dias = dias;
        this.htmlCodigo = htmlCodigo;
        this.categoria = categoria;
        this.idDesk = idDesk;
        this.imagen = imagen;
    }

    public int getIdWeb() {
        return idWeb;
    }

    public void setIdWeb(int idWeb) {
        this.idWeb = idWeb;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public int getIdDesk() {
        return idDesk;
    }

    public void setIdDesk(int idDesk) {
        this.idDesk = idDesk;
    }

    public String getSignificado() {
        return significado;
    }

    public void setSignificado(String significado) {
        this.significado = significado;
    }

    public String getHtmlCodigo() {
        return htmlCodigo;
    }

    public void setHtmlCodigo(String htmlCodigo) {
        this.htmlCodigo = htmlCodigo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Imagen getImagen() {
        return imagen;
    }

    public void setImagen(Imagen imagen) {
        this.imagen = imagen;
    }
    
}
