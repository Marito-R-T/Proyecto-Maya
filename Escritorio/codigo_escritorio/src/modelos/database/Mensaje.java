/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.database;

import javax.swing.JOptionPane;

/**
 *
 * @author jose_
 */
public class Mensaje {
 
    public void advertencia(String mensaje){
        JOptionPane.showMessageDialog(null, mensaje, "Advertencia", JOptionPane.WARNING_MESSAGE);
    }
    
    public void informacion(String mensaje){
        JOptionPane.showMessageDialog(null, mensaje, "Informacion", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void error(String mensaje){
        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
