package principal.backend.calendari_cholquij.matriz;

import principal.backend.calendari_cholquij.matriz.elementos.KinCholqij;

/**
 *
 * @author jesfrin
 */
public class ManejadorDeCalendarioCholqij {

    private CalendarioCholqij calendario;
    private int numeroDeNahual;
    private int numeroDeEnergia;

    public ManejadorDeCalendarioCholqij() {
        this.calendario = new CalendarioCholqij(false);
        this.numeroDeEnergia = 1;
        this.numeroDeNahual = 1;
    }

    /**
     * La energia aumenta basado en el nahual, si sobrepasan su limite superior
     * vuelven a su limite superior
     * @return 
     */
    public KinCholqij verDiaSiguiente() {
        if(numeroDeNahual == 20){
            numeroDeNahual = 1;
            if(numeroDeEnergia == 13){
                numeroDeEnergia = 1;
            } else {
                numeroDeEnergia++;
            }
        }else{
            numeroDeNahual++;
        }
        return calendario.getDiasDeCalendarioCholtij()[numeroDeNahual - 1][numeroDeEnergia - 1];
    }

    /**
     * La energia disminuye basado en el nahual, si sobrepasan su limite inferior
     * vuelven a su limite inferior
     * @return 
     */
    public KinCholqij verDiaAnterior() {
        if(numeroDeNahual==1){
            numeroDeNahual=20;
            if(numeroDeEnergia==1){
                numeroDeEnergia=13;
            }else{
                numeroDeEnergia--;
            }
        }else{
            numeroDeNahual--;
        }
        return calendario.getDiasDeCalendarioCholtij()[numeroDeNahual - 1][numeroDeEnergia - 1];
    }

    public CalendarioCholqij getCalendario() {
        return calendario;
    }

    public void setCalendario(CalendarioCholqij calendario) {
        this.calendario = calendario;
    }

    public int getNumeroDeNahual() {
        return numeroDeNahual;
    }

    public void setNumeroDeNahual(int numeroDeNahual) {
        this.numeroDeNahual = numeroDeNahual;
    }

    public int getNumeroDeEnergia() {
        return numeroDeEnergia;
    }

    public void setNumeroDeEnergia(int numeroDeEnergia) {
        this.numeroDeEnergia = numeroDeEnergia;
    }

}
