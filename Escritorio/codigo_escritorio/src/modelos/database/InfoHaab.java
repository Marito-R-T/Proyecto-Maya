/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.objetos.Informacion2;

/**
 *
 * @author luisGonzalez
 */
public class InfoHaab {
 
    private Mensaje mensajes = new Mensaje();
    
    public ArrayList<Informacion2> leerHechosHistoricos(){
        ArrayList<Informacion2> datos = new ArrayList<>();
        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("SELECT * FROM informacion WHERE id_cat_calendario = 2;");
            ResultSet result = statement.executeQuery();
            while(result.next()){
                Informacion2 info = new Informacion2(result.getInt(1), result.getString(2), result.getInt(3), result.getString(4), result.getString(5));
                datos.add(info);
            }
        } catch (SQLException ex) {
            mensajes.error("No se leyo ninguna informacion dentro del calendario haab.");
        }
        return datos;        
    }
    
}
