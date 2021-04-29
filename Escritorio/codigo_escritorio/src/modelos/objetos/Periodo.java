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
public class Periodo {

    int orden;
    String nombre,  ACInicio, ACFin;

    public Periodo(int orden, String nombre, String ACInicio, String ACFin) {
        this.orden = orden;
        this.nombre = nombre;
        this.ACInicio = ACInicio;
        this.ACFin = ACFin;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getACInicio() {
        return ACInicio;
    }

    public void setACInicio(String ACInicio) {
        this.ACInicio = ACInicio;
    }

    public String getACFin() {
        return ACFin;
    }

    public void setACFin(String ACFin) {
        this.ACFin = ACFin;
    }


}
