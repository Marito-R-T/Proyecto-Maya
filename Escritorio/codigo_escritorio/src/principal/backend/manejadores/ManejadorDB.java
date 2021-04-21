/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal.backend.manejadores;

/**
 *
 * @author bryangmz
 */
public class ManejadorDB {
    
    private static ManejadorDB manejadorDB;
    
    private ManejadorDB() {}
    
    public static ManejadorDB getInstancia(){
        if (manejadorDB == null) {
            manejadorDB = new ManejadorDB();
        } return manejadorDB;
    }
}
