/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.objetos;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author jose_
 */

public class Cargador {
 
    private String nombre, descripcion, imagen;

    public Cargador() {
    }

    public Cargador(String nombre, String descripcion, String imagen) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
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

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
    public void colocarImagen(JLabel label){
        ImageIcon imIcon = new ImageIcon(this.imagen);
        Icon icono = new ImageIcon(imIcon.getImage().getScaledInstance(135, 135, Image.SCALE_DEFAULT));
        label.setIcon(icono);
    }
}
