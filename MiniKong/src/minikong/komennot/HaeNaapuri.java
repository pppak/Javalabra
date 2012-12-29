package minikong.komennot;

import minikong.domain.TekstinTiedot;

public class HaeNaapuri extends Komento{

    public HaeNaapuri(TekstinTiedot t) {
        super(t);
    }
    
    public String getVasen(String sana) {
        return this.getTeksti().getSananNaapurit(sana).getSuurin(true).getSana() + " (" + this.getTeksti().getSananNaapurit(sana).getSuurin(true).getEsiintymisMaara() +")";
    }

    public String getOikea(String sana) {
        return this.getTeksti().getSananNaapurit(sana).getSuurin(false).getSana() + " (" + this.getTeksti().getSananNaapurit(sana).getSuurin(false).getEsiintymisMaara() + ")";
    }    
}