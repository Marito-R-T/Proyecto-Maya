/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import modelos.objetos.HechoHistorico;

/**
 *
 * @author jose_
 */
public class HechoHistoricoDb {
    
    private Mensaje mensajes = new Mensaje();
    
     public void crearHH(HechoHistorico hhACrear) {//creamos un nuevo hecho historico
        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("INSERT INTO hechohistorico "
                    + "(id, fechaInicio,fechaFinalizacion, titulo, descripcion) "
                    + "VALUES (?,?,?,?,?);");
            statement.setInt(1, hhACrear.getId());
            statement.setDate(2, hhACrear.getFechaInicio());
            statement.setDate(3, hhACrear.getFechaFinalizacion());
            statement.setString(4, hhACrear.getTitulo());
            statement.setString(5, hhACrear.getDescripcion());
            statement.executeUpdate();
            mensajes.informacion("Se ha creado el hecho historico con éxito.");
        } catch (SQLException ex) {
            mensajes.error("No se pudo guardar el hecho historico. Ingrese otro hecho historico. ");
        }
    }

    public void actualizarHechoHistorico(HechoHistorico hhActualizar) {//actualizamos hecho historico
        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("UPDATE hechohistorico SET "
                    + " fechaInicio =? , fechaFinalizacion=?,  "
                    + "titulo=? ,  descripcion=? "
                    + "WHERE id=?;");
            statement.setDate(1, hhActualizar.getFechaInicio());
            statement.setDate(2, hhActualizar.getFechaFinalizacion());
            statement.setString(3, hhActualizar.getTitulo());
            statement.setString(4, hhActualizar.getDescripcion());
             statement.setInt(5, hhActualizar.getId());
            statement.executeUpdate();
            mensajes.informacion("Se ha actualizado el hecho historico con exito.");
        } catch (SQLException ex) {
            mensajes.error("NO se actualizo el hechoHistorico. Asegurese que  exista");
        }

    }

    public void eliminarHechoHistorico(HechoHistorico hhAEliminar) {//eliminamos hecho historico
        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("DELETE FROM hechohistorico WHERE id=?;");
            statement.setInt(1, hhAEliminar.getId());
            statement.executeUpdate();
            mensajes.informacion("Se eliminó el hecho historico con exito.");
        } catch (SQLException ex) {
            mensajes.error("No se elimino el hechoHistorico .. Asegurese que el hechoHistorico exista");
        }
    }

    public LinkedList<HechoHistorico> leerHechosHistoricos() { //mostramos todos los hechos historicos y devolvemos en una lista
        LinkedList<HechoHistorico> listaHechosHistoricos = new LinkedList<>();
        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("SELECT * FROM hechohistorico;");
            ResultSet resultado = statement.executeQuery();
            while (resultado.next()) {
                HechoHistorico usuario = convertirAHH(resultado);
                listaHechosHistoricos.add(usuario);
            }
        } catch (SQLException ex) {
            mensajes.error("No se leyeron los hechosHistoricos de la DB");
        }
        return listaHechosHistoricos;
    }

    public HechoHistorico leerHechoHistorico(HechoHistorico hhBuscar) {//leemos un hechoHistorico en especifico y lo devolvemos
        HechoHistorico hh = null;

        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("SELECT * FROM hechohistorico WHERE id= ? ;");
            statement.setInt(1, hhBuscar.getId());
            ResultSet resultado = statement.executeQuery();

            while (resultado.next()) {
                hh = convertirAHH(resultado);
            }
        } catch (SQLException ex) {
            mensajes.error("No se encontro el hechoHistorico");
        }
        return hh;
    }

    public HechoHistorico convertirAHH(ResultSet resultado) {//del resultado de la busqueda obtener el hechohistorico
        HechoHistorico hhDevolver = null;
        try {
            hhDevolver = new  HechoHistorico(resultado.getInt(1), resultado.getDate(2),resultado.getDate(3),
                    resultado.getString(4), resultado.getString(5));
        } catch (SQLException ex) {
            mensajes.error("error en conversion de hechoHistorico");
        }
        return hhDevolver;
    }
   
}
