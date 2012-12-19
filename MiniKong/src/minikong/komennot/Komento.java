package minikong.komennot;

import minikong.domain.TekstinTiedot;
import minikong.util.Lukija;

public abstract class Komento {

    private TekstinTiedot teksti;
    public Lukija lukija;
    
    public Komento(TekstinTiedot t, Lukija l) {
        this.lukija = l;
        this.teksti = t;
    }

    public TekstinTiedot getTeksti() {
        return this.teksti;
    }

    public void setTeksti(TekstinTiedot teksti) {
        this.teksti = teksti;
    }
    
    public abstract void suorita();
    
}
