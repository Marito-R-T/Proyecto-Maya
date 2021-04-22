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
public class Imagen {

    private int id;
    private String dirWeb, dirEscritorio, categoria;

    public Imagen(int id, String dirWeb, String dirEscritorio, String categoria) {
        this.id = id;
        this.dirWeb = dirWeb;
        this.dirEscritorio = dirEscritorio;
        this.categoria = categoria;
    }

    public Imagen() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDirWeb() {
        return dirWeb;
    }

    public void setDirWeb(String dirWeb) {
        this.dirWeb = dirWeb;
    }

    public String getDirEscritorio() {
        return dirEscritorio;
    }

    public void setDirEscritorio(String dirEscritorio) {
        this.dirEscritorio = dirEscritorio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void colocarImagen(JLabel label , int a, int b) {
        ImageIcon imIcon = new ImageIcon(this.dirEscritorio);
        Icon icono = new ImageIcon(imIcon.getImage().getScaledInstance(a, b, Image.SCALE_DEFAULT));
        label.setIcon(icono);
    }
}
