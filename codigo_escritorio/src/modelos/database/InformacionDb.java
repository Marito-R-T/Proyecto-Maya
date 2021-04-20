/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelos.objetos.Informacion;

/**
 *
 * @author jose_
 */
public class InformacionDb {
    
    private final Mensaje mensajes = new Mensaje();
    
    public void crear(Informacion informacion){
        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("INSERT INTO informacion "
                    + "(titulo,descripcionEscritorio,descripcionWeb) VALUES (?,?,?);");
            statement.setString(1, informacion.getTitulo());
            statement.setString(2, informacion.getDescripcionEscritorio());
            statement.setString(3, informacion.getDescripcionWeb());
            statement.executeUpdate();
            mensajes.informacion("Se ha creado la informacion con exito.");
        } catch (SQLException ex) {
            mensajes.error("No se ha creado la informacion con exito, intentelo de nuevo.");
        }
    }
    
    public void modificar(Informacion informacion){
        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("UPDATE informacion SET "
                    + "titulo=?, descripcionEscritorio=?, descripcionWeb=? WHERE id=?;");
            statement.setString(1, informacion.getTitulo());
            statement.setString(2, informacion.getDescripcionEscritorio());
            statement.setString(3, informacion.getDescripcionWeb());
            statement.setInt(4, informacion.getId());
            statement.executeUpdate();
            mensajes.informacion("Se ha modificado la informacion con exito.");
        } catch (SQLException ex) {
            mensajes.error("No se ha modificado la informacion con exito, intentelo de nuevo.");
        }
    }
    
    public void eliminar(Informacion informacion){
        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("DELTE FROM informacion WHERE id=?;");
            statement.setInt(1, informacion.getId());
            statement.executeUpdate();
            mensajes.informacion("Se ha eliminado la informacion con exito.");
        } catch (SQLException ex) {
            mensajes.error("No se ha eliminado la informacion con exito, intentelo de nuevo");
        }
    }
    
    public List<Informacion> getInformaciones(){
        List<Informacion> informaciones = new ArrayList();
        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("SELECT * FROM informacion;");
            ResultSet resultado = statement.executeQuery();
            while(resultado.next()) informaciones.add(convertirInformacion(resultado));
        } catch (SQLException ex) {
            System.out.println("Toda la info no se proceso");
        }
        return informaciones;
    }
    
    public Informacion getInformacion(String titulo){
      Informacion i = null;
        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("SELECT * FROM informacion WHERE titulo=?;");
            statement.setString(1, titulo);
            ResultSet resultado = statement.executeQuery();
            if(resultado.next()) i= convertirInformacion(resultado);
        } catch (SQLException ex) {
            System.out.println("La info no se obtuvo");
        }
        return i;
    }
    
    public Informacion getInformacion(int id){
        Informacion i = null;
        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("SELECT * FROM informacion WHERE id=?;");
            statement.setInt(1, id);
            ResultSet resultado = statement.executeQuery();
            if(resultado.next()) i= convertirInformacion(resultado);
        } catch (SQLException ex) {
            System.out.println("la info no se proceso");
        }
        return i;
    }
    
    private Informacion convertirInformacion(ResultSet resultado) throws SQLException{
        return new Informacion(
                resultado.getInt("id"),
                resultado.getString("titulo"),
                resultado.getString("descripcionEscritorio"),
                resultado.getString("descripcionWeb")
        );
    }
}
