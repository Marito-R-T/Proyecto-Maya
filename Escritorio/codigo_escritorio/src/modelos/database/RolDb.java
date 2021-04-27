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
import modelos.objetos.Rol;


/**
 *
 * @author jose_
 */
public class RolDb {
    
    public void crearRol(Rol rolACrear) {//creamos un nuevo rol
        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("INSERT INTO rol "
                    + "(id, tipo) VALUES (?,?);");
            statement.setInt(1, rolACrear.getId());
            statement.setString(2, rolACrear.getTipo());
            statement.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR: \n Ingrese otro rol, asegurese que el identificador '" + rolACrear.getId() + "' no se repita");
        }
    }

    public void actualizarRol(Rol rolActualizar) {//actualizamos rol
        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("UPDATE rol SET "
                    + "tipo=? WHERE id=?;");
            statement.setString(1, rolActualizar.getTipo());
            statement.setInt(2, rolActualizar.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR: \n NO se actualizo el rol. Asegurese que el rol exista");
        }

    }

    public void eliminarRol(Rol rolAEliminar) {//eliminamos rol
        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("DELETE FROM rol WHERE id=?;");
            statement.setInt(1, rolAEliminar.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR: \n No se elimino el rol. Asegurese que el rol exista");
        }
    }

    public LinkedList<Rol> leerRoles() { //mostramos todos los roles y devolvemos en una lista
        LinkedList<Rol> listaRoles = new LinkedList<>();
        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("SELECT * FROM rol;");
            ResultSet resultado = statement.executeQuery();
            while (resultado.next()) {
                Rol rolUsuario = convertirARol(resultado);
                listaRoles.add(rolUsuario);
            }
        } catch (SQLException ex) {
            System.out.println("No se leyeron los roles de la DB");
        }
        return listaRoles;
    }

    public Rol leerRol(Rol rolABuscar) {//leemos un rol en especifico y lo devolvemos
        Rol rolUsuario = null;

        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("SELECT * FROM rol WHERE id= ? ;");
            statement.setInt(1, rolABuscar.getId());
            ResultSet resultado = statement.executeQuery();

            while (resultado.next()) {
                rolUsuario = convertirARol(resultado);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR: \n no se encontro el rol ");
        }
        return rolUsuario;
    }

    public Rol convertirARol(ResultSet resultado) {
        Rol rolDevolver = null;
        try {
            rolDevolver = new Rol(resultado.getInt(1), resultado.getString("nombre"));
        } catch (SQLException ex) {
            System.out.println("error en conversion de rol");
        }
        return rolDevolver;
    }
    
}
