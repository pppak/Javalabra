package minikong.komennot;

import minikong.domain.TekstinTiedot;

public abstract class Komento {

    private TekstinTiedot teksti;
    
    public Komento(TekstinTiedot t) {
        this.teksti = t;
    }

    public TekstinTiedot getTeksti() {
        return this.teksti;
    }

    public void setTeksti(TekstinTiedot teksti) {
        this.teksti = teksti;
    }
    
}
