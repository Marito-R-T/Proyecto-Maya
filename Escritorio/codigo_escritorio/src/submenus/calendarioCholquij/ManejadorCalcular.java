/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package submenus.calendarioCholquij;
import javax.swing.Icon;

/**
 *
 * @author bryangmz
 */
public class ManejadorCalcular {
    
    private static ManejadorCalcular manejadorCalcular;
    
    private ManejadorCalcular(){}
    
    public static ManejadorCalcular getInstancia(){
        if (manejadorCalcular == null) {
            manejadorCalcular = new ManejadorCalcular();
        } return manejadorCalcular;
    }
    
    public Icon getIcon(int caso){
        System.out.println("CASO " + caso);
        return (new javax.swing.ImageIcon(getClass().getResource("/com/imagenesNahualesMayas/Nahual" + caso + ".jpg"))); // NOI18N
    }
    
    public Icon getIconLvl(int caso){
        System.out.println("CASO " + caso);
        return (new javax.swing.ImageIcon(getClass().getResource("/com/imagenesNumerosMayas/numero" + caso + ".jpg"))); // NOI18N
    }
    
}
