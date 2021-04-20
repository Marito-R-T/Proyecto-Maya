package principal.backend.calendari_cholquij.matriz;

import principal.backend.calendari_cholquij.matriz.elementos.EnergiaCholqij;
import principal.backend.calendari_cholquij.matriz.elementos.KinCholqij;
import principal.backend.calendari_cholquij.matriz.elementos.NahualCholqij;

/**
 *
 * @author jesfrin
 */
public class CalendarioCholqij {

    //COnstantes de url
    private static final String INCIO_URL_DE_NUMERO = "/com/imagenesNumerosMayas/numero";
    private static final String INCIO_URL_DE_NAHUAL = "/com/imagenesNahualesMayas/Nahual";
    //Elementos de calendario
    private final KinCholqij[][] diasDeCalendarioCholtij = new KinCholqij[20][13];
    private final EnergiaCholqij energias[];
    private final NahualCholqij nahuales[];
    private String informacionDeNahuales[];
    
    //informacion de nahuales
    public static final String nahualImox = "Imox significa la esencia de nuestra conciencia y de nuestra mente. "+"\n"+"Imox es el lado izquierdo, la parte sutil del ser humano. Imox es la sensibilidad, lo inusual y lo excéntrico.";
    public static final String nahualIq = "Iq simboliza el espíritu vital, el relámpago, la tempestad. Iq´ simboliza las corrientes del aire, la limpieza"+"\n"+" y la pureza del cristal. "+"\n"+"En este día nació el viento y así se origino la vida. Iq´ es el purificador del cuerpo, de la mente y del espíritu.";
    public static final String nahualAqabal = "Aqabal significa el amanecer y el atardecer, la luz y la oscuridad. Aq´ab´al es el signo de la renovación,"+"\n"+" de las oportunidades y la dualidad."+"\n"+ " Este día es para pedir claridad, nuevas oportunidades, renovación de la vida y la estabilidad.";
    public static final String nahualKat = "Kat significa la red para pescar y para guardar el maíz. K´at también significa los enredos y los problemas."+"\n"+"Kat es el día propicio para desenredar un problema y pedir por la abundancia.";
    public static final String nahualKan = "Kan significa la serpiente emplumada. Kan es el movimiento, creador y formador del universo."+"\n"+ " Kan es la evolución humana, el desarrollo espiritual, la justicia, la verdad, la inteligencia y la paz.";
    public static final String nahualKame ="Kame significa la muerte, que es lo único seguro, todos nacemos un día y luego volvemos al origen. Kame es la"+"\n"+" muerte para el mundo maya, es una energía positiva."+"\n"+ " Kame es un día especial para tener contacto con los ancestros.";
    public static final String nahualKej = "Kej significa venado. Kej son los cuatro pilares que sostienen el cielo y la tierra. Kej son los cuatro puntos"+"\n"+" cardinales, los cuatro caminos. Kej es el conocimiento del poder a través de la existencia física. "+"\n"+ "La armonía es la mayor fuerza de este día.";
    public static final String nahualQanil = "Q´anil significa germen, semilla, vida y creación. Q´anil es la creación del universo, en especial la vida de la madre"+"\n"+" naturaleza. "+"\n"+ "Q´anil es un día para pedir por la germinación y la vida.";
    public static final String nahualToj = "Toj significa la divinidad del sol. Toj es el fuego del espíritu del Ajaw. "+"\n"+ "Toj es la nivelación con la justicia, la vida y la esperanza.";
    public static final String nahualTzi = "Tz´i´ significa perro, secretario, escritura, justicia y autoridad. Tz´i´ es el guardián de la ley material y espiritual. "+"\n"+ "Tz´i´ representa la fidelidad, el orden y la exactitud. ";
    public static final String nahualBatz = "B´atz´ simboliza el tiempo desarrollado, la evolución y la vida humana. B´atz´ representa el principio de la vida,"+"\n"+" el tiempo infinito de la inteligencia y la sabiduría. B´atz´ también simboliza los fenómenos cósmicos y "+"\n"+"la sabiduría original.";
    public static final String nahualE = "E simboliza el camino del destino, el guía, el que nos lleva a un punto objetivo y preciso, la búsqueda de la "+"\n"+"realización en todas las situaciones, aspectos y manifestaciones de la vida.";
    public static final String nahualAj ="Aj representa a las nuevas generaciones. Significa el cañaveral, la abundancia, la unidad, el poder divino, "+"\n"+"la clarividencia, las palabras sagradas. Aj es el amor a la humanidad, la telepatía, las señales del cuerpo "+"\n"+"y los sueños inesperados.";
    public static final String nahualIx = "I´x significa el jaguar o el tigre, la energía felina. I´x representa a la mujer y el altar maya. I´x es la "+"\n"+"energía que protege a los cerros, planicies y montañas.\n" +"I’x es principio de la vitalidad, unión de los puntos vitales de todos los seres vivos";
    public static final String nahualTzikin ="Tz´ikin significa pájaro guardián, la libertad, el mensajero, el tesoro, la suerte y el dinero. Tz´ikin es el mejor"+"\n"+" día para el amor, para pedir abundancia material y espiritual, tanto en lo particular como en lo comunitario.";
    public static final String nahualAjmac ="Ajmaq significa el perdón y el pecado, representa lo más oscuro de la noche y el primer rayo de luz. Ajmaq es"+"\n"+" tierra, espíritu de los abuelos y sabiduría ancestral. Ajmaq es la conciencia planetaria y la energía exterior.";
    public static final String nahualNoj ="No´j simboliza el movimiento del cielo y la tierra. No´j es la cueva o caverna, poder de la inteligencia o sabiduría. "+"\n"+"No´j también significa las ideas y pensamientos. No´j es un día propicio para pedir claridad en"+"\n"+" la toma de decisiones.";
    public static final String nahualTijax ="Tijax simboliza el cuchillo de obsidiana, el cuchillo de doble filo. Tijax es la fuerza y el poder del guerrero. "+"\n"+"Tijax simboliza lo drástico, el sufrimiento, las revelaciones por medio de imágenes fugaces. Tijax es el"+"\n"+" poder del trueno y el rayo.";
    public static final String nahualKawoq ="Kawoq significa la fuerza de la unión, la conciencia y el desarrollo del plan cósmico. Kawoq significa crecimiento,"+"\n"+" fertilidad, energía para la abundancia material y espiritual. Kawoq simboliza a la mujer, la esposa y a "+"\n"+"la Sagrada vara de la autoridad.";
    public static final String nahualAjpu ="Ajpu es el día de la grandeza y de la fuerza de la vida. Ajpu son los cazadores seguros y certeros. "+"\n"+"Ajpu es apto para obtener la certeza, la seguridad, el valor y la energía para vencer los obstáculos.";
    
    
    public CalendarioCholqij(boolean esParaCuadricula) {
        energias = new EnergiaCholqij[13];
        nahuales = new NahualCholqij[20];
        informacionDeNahuales=llenarInformacionDeNahuales();
        if (!esParaCuadricula) {
            crearEnergias();
            crearNahuales();
        } else {

        }
        crearCalendario();
    }

    /**
     * Las energias van intercaladas y van dependiendo de la fila asi: Fila 1->
     * (1) (1+7) (8-6) (2+7)...si la suma sobrepasara 13 entonces se restara 6,
     * asi en cada fila se puede comenzar sumando o restando,basado en la
     * condicion anterior Si la fila sobrepasara los 13 se regresara a 1
     */
    private void crearCalendario() {//El metodo se basa en el avance de filas
        int numeroDeFila = 1;
        for (int i = 0; i < nahuales.length; i++) {
            if (numeroDeFila == 14) {
                numeroDeFila = 1;
            }
            int valorDeEnergiaEnColumna = numeroDeFila;//El numero de fila es la base para saber la energia
            for (int j = 0; j < energias.length; j++) {
                KinCholqij dia = new KinCholqij(nahuales[i]);
                if (j == 0) {
                } else if (valorDeEnergiaEnColumna + 7 >= 14) {
                    valorDeEnergiaEnColumna -= 6;
                } else {
                    valorDeEnergiaEnColumna += 7;
                }
                dia.setEnergia(energias[valorDeEnergiaEnColumna - 1]);
                diasDeCalendarioCholtij[i][j] = dia;
            }
            numeroDeFila++;
        }
    }

    private void crearEnergias() {//Se crean 13 energias
        int numeroDeImagen;
        for (int i = 0; i < energias.length; i++) {
            numeroDeImagen = i + 1;
            this.energias[i] = new EnergiaCholqij(i + 1, INCIO_URL_DE_NUMERO + numeroDeImagen + ".jpg", "");
        }
    }

    private void crearNahuales() {//Se crean 20 nahuales
        int numeroDeImagen;
        for (int i = 0; i < nahuales.length; i++) {
            numeroDeImagen = i + 1;
            this.nahuales[i] = new NahualCholqij(i + 1, INCIO_URL_DE_NAHUAL + numeroDeImagen + ".jpg", informacionDeNahuales[i]);
        }
    }

    private String[] llenarInformacionDeNahuales() {
        String[] info = new String[20];
        info[0] = nahualImox;
        info[1] = nahualIq;
        info[2] = nahualAqabal;
        info[3] = nahualKat;
        info[4] = nahualKan;
        info[5] = nahualKame;
        info[6] = nahualKej;
        info[7] = nahualQanil;
        info[8] = nahualToj;
        info[9] = nahualTzi;
        info[10] = nahualBatz;
        info[11] = nahualE;
        info[12] = nahualAj;
        info[13] = nahualIx;
        info[14] = nahualTzikin;
        info[15] = nahualAjmac;
        info[16] = nahualNoj;
        info[17] = nahualTijax;
        info[18] = nahualKawoq;
        info[19] = nahualAjpu;
        return info;
    }

    public KinCholqij[][] getDiasDeCalendarioCholtij() {
        return diasDeCalendarioCholtij;
    }

}