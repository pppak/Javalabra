package minikong.komennot;

import java.io.File;
import minikong.domain.TekstinTiedot;
import minikong.util.Lukija;
import minikong.util.TekstinKasittelija;

public class HankiTiedosto extends Komento {

    private Lukija lukija;
    private File tiedosto;

    public HankiTiedosto(TekstinTiedot t, File tiedosto) {
        super(t);
        this.tiedosto = tiedosto;
    }

    public void suorita() {
        this.lukija = new Lukija(tiedosto);
        
        TekstinKasittelija parser = new TekstinKasittelija(super.getTeksti(), lukija);
        super.setTeksti(parser.kasittele());

    }
}