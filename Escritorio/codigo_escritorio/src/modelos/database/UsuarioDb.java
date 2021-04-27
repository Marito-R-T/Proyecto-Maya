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
import modelos.objetos.Usuario;

/**
 *
 * @author jose_
 */
public class UsuarioDb {

    public static String VALIDACION_LOGEO = "SELECT * FROM usuario WHERE correo = ?";
    private Mensaje mensajes = new Mensaje();

    public void crearUsuario(Usuario usuarioACrear) {//creamos un nuevo usuario
        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("INSERT INTO usuario "
                    + "(usuario,password,nombre,apellido,correo,fechaNacimiento,telefono,imagen,id_rol) "
                    + "VALUES (?,?,?,?,?,?,?,?,?);");
            statement.setString(1, usuarioACrear.getUsername());
            statement.setString(2, usuarioACrear.getPassword());
            statement.setString(3, usuarioACrear.getNombre());
            statement.setString(4, usuarioACrear.getApellido());
            statement.setString(5, usuarioACrear.getEmail());
            
            
            statement.setDate(6, usuarioACrear.getNacimiento());
            statement.setString(7, usuarioACrear.getNumeroTel());
            statement.setString(8, null);
            statement.setInt(9, usuarioACrear.getRol());
            System.out.println(statement);
            statement.executeUpdate();
            mensajes.informacion("Se ha creado el usuario con exito.");
        } catch (SQLException ex) {
            mensajes.error("Ingrese otro usuario, asegurese que el nombre de usuario '" + usuarioACrear.getUsername() + "' no se repita");
        }
    }

    public boolean actualizarUsuario(Usuario usuarioActualizar, String userNameAntiguo) {//actualizamos usuario
        boolean actualizado = false;
        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("UPDATE usuario SET "
                    + "usuario=? , password =? , correo=?,  "
                    + "nombre=? ,  apellido=? , fechaNacimiento= ? , "
                    + "telefono = ? , id_rol=?  "
                    + "WHERE usuario=?;");
            statement.setString(1, usuarioActualizar.getUsername());
            statement.setString(2, usuarioActualizar.getPassword());
            statement.setString(3, usuarioActualizar.getEmail());
            statement.setString(4, usuarioActualizar.getNombre());
            statement.setString(5, usuarioActualizar.getApellido());
            statement.setDate(6, usuarioActualizar.getNacimiento());
            statement.setString(7, usuarioActualizar.getNumeroTel());
            statement.setInt(8, usuarioActualizar.getRol());

            statement.setString(9, userNameAntiguo);
            statement.executeUpdate();
            mensajes.informacion("Se ha modificado el usuario con exito.");
            actualizado = true;
        } catch (SQLException ex) {
            mensajes.error("No se actualizo el usuario. Asegurese que el usuario '" + userNameAntiguo + "' exista");
            actualizado = false;
        }
        return actualizado;
    }

    public void eliminarUsuario(Usuario usuarioAEliminar) {//eliminamos usuario
        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("DELETE FROM usuario WHERE usuario=?;");
            statement.setString(1, usuarioAEliminar.getUsername());
            statement.executeUpdate();
            mensajes.informacion("Se ha eliminado el usuario con exito.");
        } catch (SQLException ex) {
            mensajes.error("No se elimino el usuario " + usuarioAEliminar.getUsername() + " . Asegurese que el usuario exista");
        }
    }

    public LinkedList<Usuario> leerUsuarios() { //mostramos todos los usuarios y devolvemos en una lista
        LinkedList<Usuario> listaUsuarios = new LinkedList<>();
        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("SELECT * FROM usuario;");
            ResultSet resultado = statement.executeQuery();
            while (resultado.next()) {
                Usuario usuario = convertirAUsuario(resultado);
                listaUsuarios.add(usuario);
            }
        } catch (SQLException ex) {
            System.out.println("No se leyeron los usuarios de la DB");
        }
        return listaUsuarios;
    }

    public Usuario leerUsuario(Usuario usuarioABuscar) {//leemos un usuario en especifico y lo devolvemos
        Usuario usuario = null;

        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("SELECT * FROM usuario WHERE username= ? ;");
            statement.setString(1, usuarioABuscar.getUsername());
            ResultSet resultado = statement.executeQuery();

            while (resultado.next()) {
                usuario = convertirAUsuario(resultado);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR: \n no se encontro el usuario");
        }
        return usuario;
    }

    public Usuario convertirAUsuario(ResultSet resultado) {//del resultado de la busqueda obtener el usuario
        Usuario usuarioDevolver = null;
        try {
            usuarioDevolver = new Usuario(resultado.getString(1), resultado.getString(2), resultado.getString(3),
                    resultado.getString(4), resultado.getString(5), resultado.getDate(6),
                    resultado.getString(7), resultado.getInt(9));
        } catch (SQLException ex) {
            System.out.println("error en conversion de usuario");
        }
        return usuarioDevolver;
    }

    //Verificacion durante logeo de un usuario
    public Usuario validacionUsuario(String correo, String password) {
        Usuario aDevolver = null;
        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement(VALIDACION_LOGEO);
            statement.setString(1, correo);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                aDevolver = convertirAUsuario(result);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aDevolver;
    }
}
