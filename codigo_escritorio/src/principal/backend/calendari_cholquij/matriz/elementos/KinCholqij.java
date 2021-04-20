package principal.backend.calendari_cholquij.matriz.elementos;

/**
 *
 * @author jesfrin
 */
public class KinCholqij {

    private NahualCholqij nahual;
    private EnergiaCholqij energia;
    
    public KinCholqij(NahualCholqij nahual){
        this.nahual = nahual;
    }

    public KinCholqij(NahualCholqij nahual, EnergiaCholqij energia) {
        this.nahual = nahual;
        this.energia = energia;
    }

    public NahualCholqij getNahual() {
        return nahual;
    }

    public void setNahual(NahualCholqij nahual) {
        this.nahual = nahual;
    }

    public EnergiaCholqij getEnergia() {
        return energia;
    }

    public void setEnergia(EnergiaCholqij energia) {
        this.energia = energia;
    }

    
    
}
