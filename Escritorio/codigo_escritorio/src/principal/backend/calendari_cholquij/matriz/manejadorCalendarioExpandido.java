/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal.backend.calendari_cholquij.matriz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author richard
 */
public class manejadorCalendarioExpandido {

    private static int contadorEnergias = 1;
    private static int contadorNahual = 1;
    private static JLabel aux = null;
    private static final ArrayList<JLabel> energias = new ArrayList();
    private static final ArrayList<JLabel> nahuales = new ArrayList();
    private static Integer i = 1, j = 1;
    private static int filas = 0, columnas = 0;
    //info energias
    public static String energiaUno = "--HUN \nPrincipio de Unidad.\n Propósito, Atraer, Unificar. \nEl principio y origen, el ser humano como un todo.";
    public static String energiaDos = "--KA \nPrincipio de Polaridad.\n Desafío, Estabilizar, Polarizar. \nEsqueleto y esencia, Masculino y femenino;";
    public static String energiaTres = "--OX \nPrincipio del ritmo o compensación.\nServicio, Unir, Activar. \nFlujo y reflujo, ascenso y descenso, acción y relación; ";
    public static String energiaCuatro = "--KAN \nPrincipio de la medida. \nForma, Medir, Definir. \nEl cuatro como medida de todas las estructuras materiales (la pirámide),";
    public static String energiaCinco = "--HO \nPrincipio de lo nuclear. \nEsplendor, Mandar, Dar poder. \nLa capacidad de realización, la movilidad de los dedos, percibir la belleza de la naturaleza";
    public static String energiaSeis = "--UAK \nPrincipio del equilibrio orgánico \nIgualdad, Equilibrar, Organizo. \nLa polaridad del ritmo genera el principio orgánico, la ley del ordenamiento Hexagonal de las estructuras cristalinas y celulares.";
    public static String energiaSiete = "--UUK \nPrincipio de unificación mental. (Poder místico) \nArmonización, Inspirar, Canalizo. \nLos hombres somos unidades resonantes dentro de un todo Mental";
    public static String energiaOcho = "--UAXAC \nPrincipio de Resonancia armónica. (Octavas resonantes) \nIntegridad, Modelar, Armonizar. \nAsí como en música, las escalas se suceden en octavas, las energías vibratorias contactan y resuenan con \nsus respectivas equisonantes en los niveles superiores e inferiores de manifestación, como también con los \narmónicos secundarios derivados de la vibración.";
    public static String energiaNueve = "--BOLON \nPrincipio de la Periodicidad cíclica. \nIntención, Realizar, Pulso. \nTodo cuanto se mueve lo hace de acuerdo a la Ley Cósmica; la periodicidad cíclica, no la repetición de los sucesos";
    public static String energiaDiez = "--LAHUN \nPrincipio de la Manifestación. \nManifestar, Producir, Perfecciono. \nEl movimiento como energía se manifiesta en cada nivel u octava de vibración (dimensión)";
    public static String energiaOnce = "--BULUC \nPrincipio de las Estructuras disonantes. \nLiberación, Divulgar, Disolver. \nTodas las estructuras, cualquiera sea su naturaleza, tienden a ingresar a nuevas realidades";
    public static String energiaDoce = "--LAHAT \nPrincipio de la Estabilidad compleja: 2x6. \nCooperación, Universalizar, Dedicación. \nEs la polarización del equilibrio orgánico, mediante el cual cada especie gana su propio nivel de frecuencia armónica";
    public static String energiaTrece = "--OXLAHUN \nPrincipio del movimiento universal o principio de vibración. \nPresencia, Trascender, Perdurar. \nTodo cuanto existe está en perpetuo movimiento, desde lo mas sutil con las vibraciones, \nhasta lo mas denso y pesado como expresión de las bajas frecuencias,\n a tal punto que estos extremos parecen en reposo. ";

    //Constantes de url
    private static final String INCIO_URL_DE_NUMERO = "/com/imagenesNumerosMayas/numero";
    private static final String INCIO_URL_DE_NAHUAL = "/com/imagenesNahualesMayas/Nahual";

//creacion de cuadricula  
    public void cuadricula(JPanel cuadroPanel, JTextArea infoText, JLabel nahual, JLabel energia) {
        try {
            filas = 21;
            columnas = 14;
            int n = 0;
            for (i = 1; i <= filas; i++) {
                for (j = 1; j <= columnas; j++) {
                    aux = (JLabel) cuadroPanel.add(new JLabel() {
                        {
                            setOpaque(true);
                            setPreferredSize(new Dimension(2, 2));
                            setBackground(Color.WHITE);

                            int n2 = j - 1;
                            int n1 = i - 1;
                            if (n1 == 0 && (n2 == 0 || n2 == 1 || n2 == 2 || n2 == 3 || n2 == 4 || n2 == 5 || n2 == 6
                                    || n2 == 7 || n2 == 8 || n2 == 9 || n2 == 10 || n2 == 11 || n2 == 12 || n2 == 13)) {
                                //   setText("Energia");
                                setText("Energia "+ n2);

                            } else if (n2 == 0 && (n1 == 0 || n1 == 1 || n1 == 2 || n1 == 3 || n1 == 4 || n1 == 5 || n1 == 6
                                    || n1 == 7 || n1 == 8 || n1 == 9 || n1 == 10 || n1 == 11 || n1 == 12 || n1 == 13
                                    || n1 == 14 || n1 == 15 || n1 == 16 || n1 == 17 || n1 == 18 || n1 == 19 || n1 == 20)) {
                               // setText("Nahual");
                                setText("Nahual "+n1);

                            } else {
                                setText("" + n2);
                            }

                        }
                    });
                    energias.add(aux);
                    if ((i == 2 || i == 3 || i == 4 || i == 5 || i == 6 || i == 7 || i == 8 || i == 9 || i == 10 || i == 11
                            || i == 12 || i == 13 || i == 14 || i == 15 || i == 16 || i == 17 || i == 18 || i == 19 || i == 20 || i == 21) && j == 1) {
                        nahuales.add(aux);
                    }
                    verInformacion(aux, i, j, infoText, nahual, energia);
                }
            }
            cuadroPanel.setLayout(new GridLayout(filas, columnas, 2, 2));
     //       cargarDatos();

        } catch (NumberFormatException nex) {
            cuadroPanel.add(new JLabel("sólo números!"));
        }
        cuadroPanel.validate();
        cuadroPanel.repaint();
    }
//carga de datos en las etiquetas    

    public void cargarDatos() {
        for (int k = 1; k < energias.size(); k++) {
            agregarEnergia(energias.get(k));
        }
        for (int k = 0; k < nahuales.size(); k++) {
            agregarNahual(nahuales.get(k));
        }
    }

    private void agregarEnergia(JLabel label) {

        switch (contadorEnergias) {
            case 1:
                label.setText(Energias.UNO.getNombre());
                contadorEnergias++;
                break;
            case 2:
                label.setText(Energias.DOS.getNombre());
                contadorEnergias++;
                break;
            case 3:
                label.setText(Energias.TRES.getNombre());
                contadorEnergias++;
                break;
            case 4:
                label.setText(Energias.CUATRO.getNombre());
                contadorEnergias++;
                break;
            case 5:
                label.setText(Energias.CINCO.getNombre());
                contadorEnergias++;
                break;
            case 6:
                label.setText(Energias.SEIS.getNombre());
                contadorEnergias++;
                break;
            case 7:
                label.setText(Energias.SIETE.getNombre());
                contadorEnergias++;
                break;
            case 8:
                label.setText(Energias.OCHO.getNombre());
                contadorEnergias++;
                break;
            case 9:
                label.setText(Energias.NUEVE.getNombre());
                contadorEnergias++;
                break;
            case 10:
                label.setText(Energias.DIEZ.getNombre());
                contadorEnergias++;
                break;
            case 11:
                label.setText(Energias.ONCE.getNombre());
                contadorEnergias++;
                break;
            case 12:
                label.setText(Energias.DOCE.getNombre());
                contadorEnergias++;
                break;
            case 13:
                label.setText(Energias.TRECE.getNombre());
                contadorEnergias++;
                break;
            default:
                break;
        }
    }

    private void agregarNahual(JLabel label) {

        switch (contadorNahual) {
            case 1:
                label.setText(Nahuales.IMOX.toString());
                contadorNahual++;
                break;
            case 2:
                label.setText(Nahuales.IQ.toString());
                contadorNahual++;
                break;
            case 3:
                label.setText((Nahuales.AQABAL.toString()));
                contadorNahual++;
                break;
            case 4:
                label.setText(Nahuales.KAT.toString());
                contadorNahual++;
                break;
            case 5:
                label.setText(Nahuales.KAN.toString());
                contadorNahual++;
                break;
            case 6:
                label.setText(Nahuales.KAME.toString());
                contadorNahual++;
                break;
            case 7:
                label.setText(Nahuales.KEJ.toString());
                contadorNahual++;
                break;
            case 8:
                label.setText(Nahuales.QANIL.toString());
                contadorNahual++;
                break;
            case 9:
                label.setText(Nahuales.TOJ.toString());
                contadorNahual++;
                break;
            case 10:
                label.setText(Nahuales.TZI.toString());
                contadorNahual++;
                break;
            case 11:
                label.setText(Nahuales.BATZ.toString());
                contadorNahual++;
                break;
            case 12:
                label.setText(Nahuales.E.toString());
                contadorNahual++;
                break;
            case 13:
                label.setText(Nahuales.AJ.toString());
                contadorNahual++;
                break;
            case 14:
                label.setText(Nahuales.IX.toString());
                contadorNahual++;
                break;
            case 15:
                label.setText(Nahuales.TZIKIN.toString());
                contadorNahual++;
                break;
            case 16:
                label.setText(Nahuales.AJMAC.toString());
                contadorNahual++;
                break;
            case 17:
                label.setText(Nahuales.NOJ.toString());
                contadorNahual++;
                break;
            case 18:
                label.setText(Nahuales.TIJAX.toString());
                contadorNahual++;
                break;
            case 19:
                label.setText(Nahuales.KAWOQ.toString());
                contadorNahual++;
                break;
            case 20:
                label.setText(Nahuales.AJPU.toString());
                contadorNahual++;
                break;

            default:
                break;
        }
    }
//obtencion de la informacion de cada energia y nahual

    private String obtenerEnergia(int energia) {
        switch (energia) {
            case 1:
                return Energias.UNO.getInfo();
            case 2:
                return Energias.DOS.getInfo();
            case 3:
                return Energias.TRES.getInfo();
            case 4:
                return Energias.CUATRO.getInfo();
            case 5:
                return Energias.CINCO.getInfo();
            case 6:
                return Energias.SEIS.getInfo();
            case 7:
                return Energias.SIETE.getInfo();
            case 8:
                return Energias.OCHO.getInfo();
            case 9:
                return Energias.NUEVE.getInfo();
            case 10:
                return Energias.DIEZ.getInfo();
            case 11:
                return Energias.ONCE.getInfo();
            case 12:
                return Energias.DOCE.getInfo();
            case 13:
                return Energias.TRECE.getInfo();
            default:
                break;
        }
        return "";
    }

    private String obtenerNahual(int nahual) {
        switch (nahual) {
            case 1:
                return Nahuales.IMOX.getInfo();
            case 2:
                return Nahuales.IQ.getInfo();
            case 3:
                return Nahuales.AQABAL.getInfo();
            case 4:
                return Nahuales.KAT.getInfo();
            case 5:
                return Nahuales.KAN.getInfo();
            case 6:
                return Nahuales.KAME.getInfo();
            case 7:
                return Nahuales.KEJ.getInfo();
            case 8:
                return Nahuales.QANIL.getInfo();
            case 9:
                return Nahuales.TOJ.getInfo();
            case 10:
                return Nahuales.TZI.getInfo();
            case 11:
                return Nahuales.BATZ.getInfo();
            case 12:
                return Nahuales.E.getInfo();
            case 13:
                return Nahuales.AJ.getInfo();
            case 14:
                return Nahuales.IX.getInfo();
            case 15:
                return Nahuales.TZIKIN.getInfo();
            case 16:
                return Nahuales.AJMAC.getInfo();
            case 17:
                return Nahuales.NOJ.getInfo();
            case 18:
                return Nahuales.TIJAX.getInfo();
            case 19:
                return Nahuales.KAWOQ.getInfo();
            case 20:
                return Nahuales.AJPU.getInfo();

            default:
                break;
        }
        return "";
    }
//obtencion de las imagenes de cada energia y nahual

    private void imagenNahual(int fila, JLabel nahual) {
        String path = INCIO_URL_DE_NAHUAL + fila + ".jpg";
        cargarImagen(path, nahual);
    }

    private void imagenEnergia(int columna, JLabel energia) {
        String path = INCIO_URL_DE_NUMERO + columna + ".jpg";
        cargarImagen(path, energia);
    }

    private void cargarImagen(String path, JLabel label) {
        try {
            URL url = this.getClass().getResource(path);
            ImageIcon icon = new ImageIcon(url);
            label.setIcon(icon);
        } catch (Exception e) {
            System.out.println("? URL");
        }
    }

    private void imagenEnergia2(int columna, JLabel energia) {
        int columna2 = columna - 1;
        String path = INCIO_URL_DE_NUMERO + columna + ".jpg";
        cargarImagen2(path, energia);
    }

    private void cargarImagen2(String path, JLabel label) {
        try {
            URL url = this.getClass().getResource(path);
            ImageIcon icon = new ImageIcon(url);
            Icon iconUs = new ImageIcon(icon.getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT));
            label.setIcon(iconUs);
        } catch (Exception e) {
            System.out.println("? URL");
        }
    }

    private void verInformacion(JLabel label, int filaA, int columnaA, JTextArea infoText, JLabel nahual, JLabel energia) {
        int fila = filaA - 1;
        int columna = columnaA - 1;

        label.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent arg) {
                infoText.setText("");
                infoText.append("NAHUAL\n");
                infoText.append(contarTexto(obtenerNahual(fila)));
                infoText.append("\n\nENERGIA\n");
                infoText.append(contarTexto(obtenerEnergia(columna)));
                imagenNahual(fila, nahual);
                imagenEnergia(columna, energia);
            }

            @Override
            public void mouseEntered(MouseEvent arg0) {
                // areaTexto.setText("El ratón se ha situado sobre la etiqueta");
            }

            @Override
            public void mouseExited(MouseEvent arg0) {
                //areaTexto.setText(mensageAreaTexto);
            }

            @Override
            public void mousePressed(MouseEvent arg0) {
            }

            @Override
            public void mouseReleased(MouseEvent arg0) {
            }
        });
    }

    private String contarTexto(String text) {
        String retornar = "";
        String[] split = text.split(" ");
        if (split.length > 0) {
            int contador = 0;
            String cadena;
            for (int a = 0; a < split.length; a++) {
                cadena = split[a].replaceAll("\n", "");
                cadena = cadena.replaceAll(" ", "");
                cadena = cadena.replaceAll("\t", "");
                if (a == 1) {
                    retornar += "\n";
                }
                if (contador == 3) {
                    retornar += cadena + "\n";
                    contador = 0;
                } else {
                    retornar += cadena + " ";
                    contador++;
                }
            }
            return retornar;
        }
        return "";

    }
}
