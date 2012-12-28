package minikong.komennot;

import minikong.domain.TekstinTiedot;

public class HaeSana extends Komento{

    public HaeSana(TekstinTiedot t) {
        super(t);
    }
    
    public String getVasen(String sana) {
        return this.getTeksti().getSana(sana).getSuurin(true);
    }

    public String getOikea(String sana) {
        return this.getTeksti().getSana(sana).getSuurin(false);
    }
    
}
