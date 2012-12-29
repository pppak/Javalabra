package minikong.komennot;

import minikong.domain.TekstinTiedot;

public abstract class Komento {

    private TekstinTiedot teksti;

    public Komento(TekstinTiedot teksti) {
        this.teksti = teksti;
    }

    public TekstinTiedot getTeksti() {
        return teksti;
    }

    public void setTeksti(TekstinTiedot teksti) {
        this.teksti = teksti;
    }
}
