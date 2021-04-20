/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal.backend.perfil_usuario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.database.ConexionDb;
import modelos.objetos.Usuario;

/**
 *
 * @author luisGonzalez
 */
public class Informacion {
    
    private static String CONSULTA_PERFIL = "SELECT * FROM usuario WHERE username = ?";
    
    public Usuario buscarDatos(String nombre){
        Usuario user = new Usuario();
        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement(CONSULTA_PERFIL);
            statement.setString(1, nombre);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                user.setUsername(result.getString("username"));
                user.setPassword(result.getString("password"));
                user.setEmail(result.getString("email"));
                user.setNombre(result.getString("nombre"));
                user.setApellido(result.getString("apellido"));
                user.setNacimiento(result.getDate("nacimiento"));
                user.setNumeroTel(result.getInt("telefono"));
                user.setRol(result.getInt("rol"));
            }
        } catch (SQLException ex) {
            System.out.println("no se encontro nada");
            Logger.getLogger(Informacion.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return user;
    }
    
}
