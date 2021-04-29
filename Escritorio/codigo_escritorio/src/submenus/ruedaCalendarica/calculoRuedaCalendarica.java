/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package submenus.ruedaCalendarica;

import javax.swing.JLabel;
import javax.swing.JTextField;
import modelos.database.NahualDb;
import modelos.database.WinalDb;
import modelos.objetos.Nahual;
import modelos.objetos.Winal;

/**
 *
 * @author Esmeralda
 */
public class calculoRuedaCalendarica {

    int numeroCorrelativo = 584283;
    int numeroJUlianFechaPIvote = 2451911;

    public void calculoCuentaLarga(int cantidadDiasTranscurridos, boolean Sobrepasa,
            JTextField b, JTextField kt, JTextField t, JTextField u, JTextField txtKin) {
        int cantidadDiasJulianos = 0;
        if (Sobrepasa == true) {
            cantidadDiasJulianos = numeroJUlianFechaPIvote + cantidadDiasTranscurridos;
        } else {
            cantidadDiasJulianos = numeroJUlianFechaPIvote - cantidadDiasTranscurridos;
        }

        int diaMaya = cantidadDiasJulianos - numeroCorrelativo;
        System.out.println("cantidadDiasJulianos " + cantidadDiasJulianos);
        System.out.println("dia maya " + diaMaya);

        long Baktun = diaMaya / 144000;
        int numB = (int) Baktun;
        long Katun = (diaMaya % 144000) / 7200;
        int numK = (int) Katun;

        long Tun = (diaMaya - (Baktun * 144000) - (Katun * 7200)) / 360;
        int numT = (int) Tun;
        long Uinal = (diaMaya % 360) / 20;
        int numU = (int) Uinal;
        long kin = (diaMaya % 20);
        int numKi = (int) kin;
        System.out.println("CL");
        System.out.println(numB + " " + numK + " " + numT + " " + numU + " " + numKi);
        b.setText("" + numB);
        kt.setText("" + numK);
        t.setText("" + numT);
        u.setText("" + numU);
        txtKin.setText("" + numKi);
    }

    public void calculoTzolqin(int cantidadSobrePasa, boolean sobrePasa, JLabel icNa, JLabel nombreN, JTextField numeroN) {
        long op1 = (cantidadSobrePasa % 260);
        long op2 = (op1 % 13);
        long op3 = (op1 % 20);
        int op22 = (int) op2;
        int op33 = (int) op3;

        if (sobrePasa == true) {
            //sumar
            int numero = 13 + op22;
            if (numero > 13) {
                numero = numero - 13;
            }
            //usaremos lamat en este caso es #8
            int nahualT = 8 + op33;
            //en caso el #Nahual sea mayor a 20 entonces ajustar
            if (nahualT > 20) {
                int nahualAux = nahualT - 20;
                //buscamos en la base de datos el nahuaAux
                System.out.println("numero " + numero);
                System.out.println("nahual t " + nahualAux);
                MostrarTzolin(nahualAux, numero, icNa, nombreN, numeroN);

            } else {
                //buscamos en la base de datos el nahualTzolqin
                System.out.println("numero " + numero);
                System.out.println("nahual t  " + nahualT);
                MostrarTzolin(nahualT, numero, icNa, nombreN, numeroN);

            }

        } else {
            //restar
            int numero = 13 - op22;
            if (numero < 0) {
                numero = 13 - numero;
            }

            //usaremos lamat en este caso es #8
            int nahualT = 8 - op33;
            //en caso el #Nahual sea menor a 0 entonces ajustar
            if (nahualT < 0) {
                int nahualAux = 20 + nahualT; //sumamos porque es numero negativo
                //buscamos en la base de datos el nahualAux
                System.out.println("numero " + numero);
                System.out.println("nahual  t " + nahualAux);
                MostrarTzolin(nahualAux, numero, icNa, nombreN, numeroN);

            } else {
                //buscamos en la base de datos el nahualTzolqin
                System.out.println("numero " + numero);
                System.out.println("nahual t " + nahualT);
                MostrarTzolin(nahualT, numero, icNa, nombreN, numeroN);

            }
        }
    }

    public void calculoHaab(int cantidadSobrepasa, boolean sobrePasa, JLabel iconH, JLabel nombreH, JTextField diaH) {
        //iniciamos en kankin ->13
        //sino es de 13 a 0
        long op1 = cantidadSobrepasa % 365;
        int opc2 = (int) op1;
        int numHaab = 0;
        int iteracion = 13;

        if (sobrePasa == true) {        //si sobrepasa entonces vamos de 13 a 18
            numHaab = opc2 - 9;
            if (numHaab < 0) {
                //entonces  acoplamos
                int auxHaab = 20 - numHaab;
                //buscamos en base de datos el nahual haab
                System.out.println("numero " + auxHaab);
                System.out.println("nahual " + iteracion);
                MostrarHaab(iconH, nombreH, diaH, auxHaab, iteracion);

            } else {
                while (numHaab >= 0 && numHaab >= 20) { // para restar debe ser mayor  a 0 y 20  
                    //restaremos 20 o 5 depende si la iteracion == 18
                    iteracion++;
                    if (iteracion == 18) {
                        //restamos 5 y comienza la iteracion en 0 porque termina el ciclo tzolquin el 18
                        iteracion = 0;
                        numHaab = numHaab - 5;

                    } else {
                        //restamos 20
                        numHaab = numHaab - 20;
                    }
                }

                //verificar si se puede restar 5 en caso la iteracion haya quedado en 18 y el numero sea mayor a 5
                if (iteracion == 18 && numHaab >= 5) {
                    //se hace una iteracion mas
                    iteracion = 0;
                    numHaab = numHaab - 5;
                    //buscamos en base de datos el nahual haab
                    System.out.println("nuemro " + numHaab);
                    System.out.println("nahual " + iteracion);
                    MostrarHaab(iconH, nombreH, diaH, numHaab, iteracion);

                } else {
                    //buscamos en base de datos el nahual haab
                    System.out.println("mumero " + numHaab);
                    System.out.println(" nahual " + iteracion);
                    MostrarHaab(iconH, nombreH, diaH, numHaab, iteracion);

                }
            }

        } else {
            //en caso que no sobrepasa la iteracion va disminuyendo 
            numHaab = -opc2 + 11;
            if (numHaab >= 0) {
                //buscamos en base de datos el nahual haab
                System.out.println("numero-- " + numHaab);
                System.out.println("nahual-- " + iteracion);
                MostrarHaab(iconH, nombreH, diaH, numHaab, iteracion);

            } else {
                while (numHaab < 0) { // para restar debe ser mayor  a 0 y 20  
                    //restaremos 20 o 5 depende si la iteracion == 18
                    iteracion--;
                    if (iteracion == -1) {
                        //restamos 5 y comienza la iteracion en 0 porque termina el ciclo tzolquin el 18
                        iteracion = 18;
                        numHaab = numHaab + 5;
                        System.out.println("+ 5 ");
                    } else {
                        //restamos 20
                        numHaab = numHaab + 20;
                        System.out.println("+20  ");
                    }
                }
                //buscamos en la base de datos el nahual haab
                System.out.println("numero++ " + numHaab);
                System.out.println("nahual++ " + iteracion);
                MostrarHaab(iconH, nombreH, diaH, numHaab, iteracion);

            }
        }
    }

    public void MostrarHaab(JLabel iconH, JLabel nombreH, JTextField diaH, int numero, int idNahualHab) {
        WinalDb w = new WinalDb();

        Winal winalMostrar = w.getWinal(idNahualHab);
        if (winalMostrar == null) {
        } else {
            winalMostrar.getImagen().colocarImagen(iconH, 115, 75);
            diaH.setText("" + numero);
            nombreH.setText(winalMostrar.getNombre());
        }
    }

    public void MostrarTzolin(int idNahual, int numero, JLabel icoNT, JLabel nombreNT, JTextField numeroNT) {
        NahualDb n = new NahualDb();

        Nahual nMostrar = n.getNahual(idNahual);

        if (nMostrar == null) {
        } else {
            System.out.println(nMostrar.getImagen().getDirEscritorio());
            nMostrar.getImagen().colocarImagen(icoNT, 115, 75);
            nombreNT.setText(nMostrar.getNombre());
            numeroNT.setText("" + numero);
        }

    }
}
