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
import javax.swing.JOptionPane;
import modelos.objetos.Edicion;

/**
 *
 * @author jose_
 */
public class EdicionDb {
    
    public void crearEdicion(Edicion edicionCrear) {//agregamos edicion
        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("INSERT INTO edicion "
                    + "(id, username,idHechoHistorico, fecha, creacion) "
                    + "VALUES (?,?,?,?,?);");
            statement.setInt(1, edicionCrear.getId());
            statement.setString(2, edicionCrear.getUsuario());
            statement.setInt(3, edicionCrear.getIdHechoHIstorico());
            statement.setDate(4, edicionCrear.getFecha());
            statement.setBoolean(5, edicionCrear.isCreacion());
            statement.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR: \n No se ingreso la edicion , asegurese que el hechoHistorico|usuario exista ");
        }
    }

    public void actualizarEdicion(Edicion edicionActualizar) {//actualizamos edicion
        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("UPDATE edicion SET "
                    + "  username=?, idHechoHistorico=?, "
                    + "fecha=?, creacion=?  "
                    + "WHERE id=?;");
            statement.setString(1, edicionActualizar.getUsuario());
            statement.setInt(2, edicionActualizar.getIdHechoHIstorico());
            statement.setDate(3, edicionActualizar.getFecha());
            statement.setBoolean(4, edicionActualizar.isCreacion());
            statement.setInt(5, edicionActualizar.getId());

            statement.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR: \n NO se actualizo la edicion asegurese  que  exista");
        }

    }

    public void eliminarEdicion(Edicion edicionEliminar) {//eliminamos edicion
        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("DELETE FROM edicion WHERE id=?;");
            statement.setInt(1, edicionEliminar.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR: \n No se elimino el hechoHistorico .. Asegurese que el hechoHistorico exista");
        }
    }

    public LinkedList<Edicion> leerEdiciones() { //mostramos todas las edicciones  y devolvemos en una lista
        LinkedList<Edicion> listaEdiciones = new LinkedList<>();
        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("SELECT * FROM edicion;");
            ResultSet resultado = statement.executeQuery();
            while (resultado.next()) {
                Edicion e = convertirEdicion(resultado);
                listaEdiciones.add(e);
            }
        } catch (SQLException ex) {
            System.out.println("No se leyeron las ediciones de la DB");
        }
        return listaEdiciones;
    }

    public Edicion leerEdicion(Edicion edicionBuscar) {//leemos una edicion en especifico y lo devolvemos
        Edicion e = null;

        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("SELECT * FROM edicion WHERE id= ? ;");
            statement.setInt(1, edicionBuscar.getId());
            ResultSet resultado = statement.executeQuery();

            while (resultado.next()) {
                e = convertirEdicion(resultado);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR: \n no se encontro la edicion");
        }
        return e;
    }

    public Edicion convertirEdicion(ResultSet resultado) {//del resultado de la busqueda obtener edicion
        Edicion edicionDevolver = null;
        try {
            edicionDevolver = new Edicion(resultado.getInt(1), resultado.getString(2), resultado.getInt(3), resultado.getDate(4),
                    resultado.getBoolean(5));
        } catch (SQLException ex) {
            System.out.println("error en conversion de edicion");
        }
        return edicionDevolver;
    }

}
