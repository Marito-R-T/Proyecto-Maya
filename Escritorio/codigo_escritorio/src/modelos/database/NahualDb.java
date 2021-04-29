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
import modelos.objetos.Nahual;

/**
 *
 * @author jose_
 */
public class NahualDb {
        private final Mensaje mensajes = new Mensaje();


    public void crear(Nahual nahual) {
        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("INSERT INTO nahual "
                    + "(nombre,idImagen,signficado,descripcion,fechaInicio,fechaFinalizacion,nombreYucateco,nombreSp) VALUES (?,?,?,?,?,?,?,?)");
            statement.setString(1, nahual.getNombre());
            statement.setInt(2, nahual.getImagen().getId());
            statement.setString(3, nahual.getSignificado());
            statement.setString(4, nahual.getDescripcion());
            statement.setDate(5, nahual.getFechaInicio());
            statement.setDate(6, nahual.getFechaFinalizacion());
            statement.setString(7, nahual.getNombreYucateco());
            statement.setString(8, nahual.getNombreEsp());
            statement.executeUpdate();
        } catch (SQLException ex) {
            mensajes.error("Asegurese que el nahual no se repita");
        }
    }

    public void modificar(Nahual nahual) {
        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("UPDATE nahual SET "
                    + "significado=?, descripcion=? WHERE iddesk=?;");
            statement.setString(1, nahual.getSignificado());
            statement.setString(2, nahual.getDescripcion());
            statement.setInt(3, nahual.getId());

            statement.execute();
        } catch (SQLException ex) {
            mensajes.error("EL nahual no se actualizo");
        }
    }

    public void eliminar(Nahual nahual) {
        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("DELETE FROM nahual WHERE id=?;");
            statement.setInt(1, nahual.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            mensajes.error("EL nahual no se elimino");
        }
    }

    public List<Nahual> getNahuales() {
        List<Nahual> nahuales = new ArrayList();
        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("SELECT * FROM nahual;");
            ResultSet resultado = statement.executeQuery();
            while (resultado.next()) {
                nahuales.add(instanciarDeResultSet(resultado));
            }
        } catch (SQLException ex) {
            System.out.println("No se procesaron los nahuales");
        }
        return nahuales;
    }

    public Nahual getNahual(int id) {
        Nahual n = null;
        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("SELECT * FROM nahual WHERE id=?;");
            statement.setInt(1, id);
            ResultSet resultado = statement.executeQuery();
            if (resultado.next()) {
                n = instanciarDeResultSet(resultado);
            }
        } catch (SQLException ex) {
            System.out.println("no se obtuvo el nahual"); 
        }
        return n;
    }

    private Nahual instanciarDeResultSet(ResultSet resultado) throws SQLException {
        ImagenDb accesoImagen = new ImagenDb();
        return new Nahual(
                resultado.getInt("iddesk"),
                resultado.getString("nombre"),
                accesoImagen.getImagen(resultado.getInt("iddesk"),resultado.getString("rutaEscritorio"),resultado.getString("categoria")),
                resultado.getString("significado"),
                resultado.getString("descripcion"),
                null,
                null,
                resultado.getString("nombreYucateco"),
                null
        );
    }
}
