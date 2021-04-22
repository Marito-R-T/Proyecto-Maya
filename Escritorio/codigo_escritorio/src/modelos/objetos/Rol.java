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
public class Rol {
    
    private int id;
    private String tipo;

    public Rol(int id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public Rol() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
        @Override
    public String toString() {
        return "\nRol{" + "id=" + id + ", tipo=" + tipo + '}';
    }

    
}
