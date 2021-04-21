/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal.backend.manejadores;

import javax.swing.JOptionPane;

/**
 *
 * @author bryangmz
 */
public class ManejadorInformacion {
    
    private static ManejadorInformacion manejadorInformacion;
    
    private ManejadorInformacion(){}
    
    public static ManejadorInformacion getInstancia(){
        if (manejadorInformacion == null) {
            manejadorInformacion = new ManejadorInformacion();
        } return manejadorInformacion;
    }
    
    public void mostrarInfCalendarioLunar(){
        String mensaje = "Calendario Lunar"
                + "\nAl Cholq’ij también se le denomina calendario lunar y marca \n"
                + "nueve lunas llenas, período en el que se gesta un ser humano. \n"
                + "De acuerdo con la cosmovisión maya, la lectura de los signos\n"
                + "y numerales mayas descritos en este calendario espiritual y\n"
                + "material le permite al ajq’ij orientar la vida de \n"
                + "las personas, según su fecha de nacimiento; y también es \n"
                + "utilizado por la Iyom para programar el recibimiento de una\n"
                + "nueva criatura";
        JOptionPane.showMessageDialog(null, 
                mensaje, 
                "Calendario Lunar", 
                JOptionPane.INFORMATION_MESSAGE, 
                new javax.swing.ImageIcon(getClass().getResource("/principal/frontend/gui/calendari_cholquij/calendario-maya-lunar.png")));
    }
    
    public void mostarInfFormasDeContar(){
        String mensaje = "Forma de contar el Cholq’ij\n\n"
                + "Una manera de contar el Cholq’ij para los maya k’iche’ de la actualidad es iniciar el conteo\n"
                + "en Waqxaqib’ B’atz’ (8 B’atz’), repitiendo así cada 260 días ese número y fecha \n"
                + "(Aj Xol Ch’ok, 2008). Cada día del calendario se combina con un numeral que va del 1 al 13, \n"
                + "hasta completar 260 días. El mismo día en que inicia la cuenta vuelve a repetirse cada \n"
                + "260 días. En la antigüedad se acostumbraba a empezar el calendario en 1 Imox y se seguía el \n"
                + "mismo proceso de multiplicación de los numerales con los días para alcanzar el total de 260 \n"
                + "(Aj Xol Ch’ok, 2008). La construcción del ciclo de 260 días del calendario Cholq’ij tiene \n"
                + "como base la disciplina vigesimal maya (13X20); “esta relación organiza una frecuencia matemática \n"
                + "del movimiento natural lunar de 13:20 que se determina en base a las gravitaciones, \n"
                + "principalmente de la Luna–Tierra, las cualidades del ser en la madre Tierra de acuerdo a su \n"
                + "día de engendración, día del nacimiento y su proyección o misión en la vida” (García, Curruchiche \n"
                + "& Taquirá, 2009, p. 234). Los días de este calendario “son representados también en los 10 \n"
                + "dedos superiores de las manos, más los 10 dedos inferiores de los pies, lo que suma 20, que \n"
                + "representa los días del Cholq’ij”, pues la construcción matemática del sistema vigesimal \n"
                + "maya “se fundamenta en el Jun Winaq de 20 dedos”";
        JOptionPane.showMessageDialog(null, 
                mensaje, 
                "Formas de Contar", 
                JOptionPane.INFORMATION_MESSAGE, 
                new javax.swing.ImageIcon(getClass().getResource("/principal/frontend/gui/calendari_cholquij/300px-Cholq'ij.jpg")));
    }
    
    public void mostrarInfDiasCholquij(){
        String mensaje = "Días del Cholq’ij\n"
                + "En maya k’iche’, los veinte días del Cholq’ij reciben los siguientes \n"
                + "nombres: B’atz’, E, Aj, I’x, Tz’ikin, Ajmaq, No’j, Tijax, \n"
                + "Kawoq, Ajpu, Imox, Iq’, Aq’ab’al, K’at, Kan, Kame, Kej, Q’anil, \n"
                + "Toj, Tz’i’. Estos nombres corresponden al de los 20 nahuales o signos \n"
                + "de los días del calendario, los cuales simbolizan ciertas \n"
                + "particularidades que se asocian a las personas según la fecha de su \n"
                + "nacimiento (Barrios, 2004; León, 1999; Aj Xol Ch’ok, 2008; Rupflin, 1999).";
        JOptionPane.showMessageDialog(null, mensaje, "Dias del Calendario", JOptionPane.INFORMATION_MESSAGE, new javax.swing.ImageIcon(getClass().getResource("/principal/frontend/gui/calendari_cholquij/dias.jpg")));
    }
    
    public void mostrarInfCholquij() {
        String mensaje = "Calendario Cholquij\n"
                + "El Cholq’ij (término maya kaqchikel) es un calendario sagrado \n"
                + "del pueblo Maya, compuesto por 260 días divididos en 13 meses\n"
                + "También recibe el nombre de calendario ritual o calendario \n"
            + "sagrado o Tzolkin";
        JOptionPane.showMessageDialog(null, mensaje, "Calendario", JOptionPane.INFORMATION_MESSAGE, new javax.swing.ImageIcon(getClass().getResource("/principal/frontend/gui/calendari_cholquij/Cholquij.jpg")));
    }
}
