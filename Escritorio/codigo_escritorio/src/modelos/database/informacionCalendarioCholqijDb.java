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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static modelos.database.UsuarioDb.VALIDACION_LOGEO;
import modelos.objetos.Informacion2;
import modelos.objetos.Usuario;
import modelos.objetos.datoCalendarioCholqij;

/**
 *
 * @author Esmeralda
 */
public class informacionCalendarioCholqijDb {

    private Mensaje mensajes = new Mensaje();

    public void crearDatoCalendarioCholqij(datoCalendarioCholqij datoCC) {//creamos dato del calendario cholqij
        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("INSERT INTO datosCalendarioCholqij "
                    + "(idDato, titulo, concepto, urlImagen) "
                    + "VALUES (?,?,?,?);");
            statement.setInt(1, datoCC.getId());
            statement.setString(2, datoCC.getTitulo());
            statement.setString(3, datoCC.getContenido());
            statement.setString(4, datoCC.getUrlImagen());
            statement.executeUpdate();
            mensajes.informacion("Se ha informacion del Calendario Cholqij.");
        } catch (SQLException ex) {
            mensajes.error("Ingrese otro contenido por favor, este ya existe ");
        }
    }

    public boolean actualizarDatoCalendarioCholqij(datoCalendarioCholqij datoCC) {//actualizamos datoCC
        boolean actualizado = false;
        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("UPDATE datosCalendarioCholqij SET "
                    + "idDato=? , titulo =? , concepto=?,  "
                    + "urlImagen=? "
                    + "WHERE idDato=?;");
            statement.setInt(1, datoCC.getId());
            statement.setString(2, datoCC.getTitulo());
            statement.setString(3, datoCC.getContenido());
            statement.setString(4, datoCC.getUrlImagen());

            statement.executeUpdate();
            mensajes.informacion("Se ha modificado el dato con exito.");
            actualizado = true;
        } catch (SQLException ex) {
            mensajes.error("No se actualizo el dato. Asegurese que el dato exista");
            actualizado = false;
        }
        return actualizado;
    }

    public void eliminarDatoCalendarioCholqij(datoCalendarioCholqij datoCC) {//eliminamos datoCC
        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("DELETE FROM datosCalendarioCholqij WHERE idDato=?;");
            statement.setInt(1, datoCC.getId());
            statement.executeUpdate();
            mensajes.informacion("Se ha eliminado el dato con exito.");
        } catch (SQLException ex) {
            mensajes.error("No se elimino el dato . Asegurese que el dato exista");
        }
    }

    public LinkedList<datoCalendarioCholqij> leerDatosCalendarioCholqij() { //mostramos todos los datosCC y devolvemos en una lista
        LinkedList<datoCalendarioCholqij> listaDatosCC = new LinkedList<>();
        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("SELECT * FROM datosCalendarioCholqij;");
            ResultSet resultado = statement.executeQuery();
            while (resultado.next()) {
                datoCalendarioCholqij usuario = convertirDato(resultado);
                listaDatosCC.add(usuario);
            }
        } catch (SQLException ex) {
            System.out.println("No se leyeron los datos del calendario Cholqij de la DB");
        }
        return listaDatosCC;
    }

    public Informacion2 leerDatoCalendarioCholqij(int idDatoCC) {//leemos un datoCC en especifico y lo devolvemos
        Informacion2 datoCholqij = null;
        switch(idDatoCC){
            case 1:
            {
                try {
                    PreparedStatement statement = ConexionDb.conexion.prepareStatement("SELECT * FROM informacion WHERE id_cat_calendario = 1 AND nombre_informacion = 'El Calendario Tzolk’in';");
                    ResultSet result = statement.executeQuery();
                    while(result.next()){
                        datoCholqij = new Informacion2(result.getInt(1), result.getString(2), result.getInt(3), result.getString(4), result.getString(5));
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(informacionCalendarioCholqijDb.class.getName()).log(Level.SEVERE, null, ex);
                }
            }    
                
                break;
            case 2:
            {
                try {
                    PreparedStatement statement = ConexionDb.conexion.prepareStatement("SELECT * FROM informacion WHERE id_cat_calendario = 1 AND nombre_informacion = 'Dias del Cholq’ij';");
                    ResultSet result = statement.executeQuery();
                    while(result.next()){
                        datoCholqij = new Informacion2(result.getInt(1), result.getString(2), result.getInt(3), result.getString(4), result.getString(5));
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(informacionCalendarioCholqijDb.class.getName()).log(Level.SEVERE, null, ex);
                }
            }    
                break;
            case 3:
            {
                try {
                    PreparedStatement statement = ConexionDb.conexion.prepareStatement("SELECT * FROM informacion WHERE id_cat_calendario = 1 AND nombre_informacion = 'Forma de contar el Cholq’ij';");
                    ResultSet result = statement.executeQuery();
                    while(result.next()){
                        datoCholqij = new Informacion2(result.getInt(1), result.getString(2), result.getInt(3), result.getString(4), result.getString(5));
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(informacionCalendarioCholqijDb.class.getName()).log(Level.SEVERE, null, ex);
                }
            }                
                break;
            case 4:
            {
                try {
                    PreparedStatement statement = ConexionDb.conexion.prepareStatement("SELECT * FROM informacion WHERE id_cat_calendario = 1 AND nombre_informacion = 'Calendario Lunar';");
                    ResultSet result = statement.executeQuery();
                    while(result.next()){
                        datoCholqij = new Informacion2(result.getInt(1), result.getString(2), result.getInt(3), result.getString(4), result.getString(5));
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(informacionCalendarioCholqijDb.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                break;

            default:
                
                break;
        }
        return datoCholqij;
    }

    public datoCalendarioCholqij convertirDato(ResultSet resultado) {//del resultado de la busqueda obtener el datoCC
        datoCalendarioCholqij datoCC = null;
        try {
            datoCC = new datoCalendarioCholqij(resultado.getInt(1), resultado.getString(2), resultado.getString(3),
                    resultado.getString(4));
        } catch (SQLException ex) {
            System.out.println("error en conversion de dato del calendario Cholqij");
        }
        return datoCC;
    }


}
