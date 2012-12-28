package minikong.komennot;

import minikong.domain.TekstinTiedot;

public class HaeSana extends Komento{

    public HaeSana(TekstinTiedot t) {
        super(t);
    }
    
    public String getVasen(String sana) {
        return this.getTeksti().getSana(sana).getSuurin(true).getSana() + " (" + this.getTeksti().getSana(sana).getSuurin(true).getEsiintymisMaara() +")";
    }

    public String getOikea(String sana) {
        return this.getTeksti().getSana(sana).getSuurin(false).getSana() + " (" + this.getTeksti().getSana(sana).getSuurin(false).getEsiintymisMaara() + ")";
    }
    
}