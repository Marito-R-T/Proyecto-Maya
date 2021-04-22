package principal.backend.calendari_cholquij.matriz;

/**
 *
 * @author richard
 */
public enum Energias {
    UNO("HUN ",manejadorCalendarioExpandido.energiaUno,1),
    DOS("KA ",manejadorCalendarioExpandido.energiaDos,2),
    TRES("OX ",manejadorCalendarioExpandido.energiaTres,3),
    CUATRO("KAN ",manejadorCalendarioExpandido.energiaCuatro,4),
    CINCO("HO ",manejadorCalendarioExpandido.energiaCinco,5),
    SEIS("UAK ",manejadorCalendarioExpandido.energiaSeis,6),
    SIETE("UUK ",manejadorCalendarioExpandido.energiaSiete,7),
    OCHO("UAXAC ",manejadorCalendarioExpandido.energiaOcho,8),
    NUEVE("BOLON ",manejadorCalendarioExpandido.energiaNueve,9),
    DIEZ("LAHUN ",manejadorCalendarioExpandido.energiaDiez,10),
    ONCE("BULUC ",manejadorCalendarioExpandido.energiaOnce,11),
    DOCE("LAHAT ",manejadorCalendarioExpandido.energiaDoce,12),
    TRECE("OXLAHUN ",manejadorCalendarioExpandido.energiaTrece,13);
    
    private String nombre;
    private String info;
    private int numeroEnergia;
    
    private Energias(String nombre,String info, int numeroEnergia){
        this.nombre = nombre;
        this.info = info;
        this.numeroEnergia = numeroEnergia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getNumeroEnergia() {
        return numeroEnergia;
    }

    public void setNumeroEnergia(int numeroEnergia) {
        this.numeroEnergia = numeroEnergia;
    }
  
    
    
}
