/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal.backend.calendari_cholquij.matriz;


/**
 *
 * @author richard
 */
public enum Nahuales {
    
    
    IMOX(CalendarioCholqij.nahualImox,1),
    IQ(CalendarioCholqij.nahualIq,2),
    AQABAL(CalendarioCholqij.nahualAqabal,3),
    KAT(CalendarioCholqij.nahualKat,4),
    KAN(CalendarioCholqij.nahualKan,5),
    KAME(CalendarioCholqij.nahualKame,6),
    KEJ(CalendarioCholqij.nahualKej,7),
    QANIL(CalendarioCholqij.nahualQanil,8),
    TOJ(CalendarioCholqij.nahualToj,9),
    TZI(CalendarioCholqij.nahualTzi,10),
    BATZ(CalendarioCholqij.nahualBatz,11),
    E(CalendarioCholqij.nahualE,12),
    AJ(CalendarioCholqij.nahualAj,13),
    IX(CalendarioCholqij.nahualIx,14),
    TZIKIN(CalendarioCholqij.nahualTzikin,15),
    AJMAC(CalendarioCholqij.nahualAjmac,16),
    NOJ(CalendarioCholqij.nahualNoj,17),
    TIJAX(CalendarioCholqij.nahualTijax,18),
    KAWOQ(CalendarioCholqij.nahualKawoq,19),
    AJPU(CalendarioCholqij.nahualAjpu,20);
    
    private String info;
    private int numeroNahual;
    
    private Nahuales(String info, int numeroNahual){
        this.info = info;
        this.numeroNahual = numeroNahual;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getNumeroNahual() {
        return numeroNahual;
    }

    public void setNumeroNahual(int numeroNahual) {
        this.numeroNahual = numeroNahual;
    }
    
    
}
