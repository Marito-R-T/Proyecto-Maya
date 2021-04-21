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
public class Edicion {
    
    private int id;
    private String usuario;
    private int idHechoHIstorico;
    private Date fecha;
    private boolean creacion;

    public Edicion() {
    }

    public Edicion(int id, String usuario, int idHechoHistorico, Date fecha, boolean creacion) {
        this.id = id;
        this.usuario = usuario;
        this.idHechoHIstorico = idHechoHistorico;
        this.fecha = fecha;
        this.creacion = creacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getIdHechoHIstorico() {
        return idHechoHIstorico;
    }

    public void setIdHechoHIstorico(int idHechoHIstorico) {
        this.idHechoHIstorico = idHechoHIstorico;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public boolean isCreacion() {
        return creacion;
    }

    public void setCreacion(boolean creacion) {
        this.creacion = creacion;
    }

    @Override
    public String toString() {
        return "\n Edicion{" + "id=" + id + ", usuario=" + usuario + ", idHechoHIstorico=" + idHechoHIstorico + ", fecha=" + fecha + ", creacion=" + creacion + '}';
    }

}
