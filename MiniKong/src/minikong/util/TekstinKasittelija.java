package minikong.util;

import java.io.File;
import minikong.domain.TekstinTiedot;

public class TekstinKasittelija {

    private TekstinTiedot teksti;
    private Lukija lukija;
    private Siistija siistija;

    public TekstinKasittelija(TekstinTiedot t, File f) {
        this.teksti = t;
        this.lukija = new Lukija(f);
        this.siistija = new Siistija();
    }

    public TekstinKasittelija(TekstinTiedot tt, String text) {
        this.teksti = tt;
        this.lukija = new Lukija(text);
        this.siistija = new Siistija();
    }

    public TekstinTiedot kasittele() {
        String edellinen = null;
        String nykyinen;
        while (lukija.onkoSeuraava()) {
            nykyinen = this.siistija.trim(lukija.seuraavaSana());
            if (nykyinen.isEmpty()) {
                continue;
            }
            teksti.plusSanamaara();
            
            if (!teksti.sanaListattu(nykyinen)) {
                teksti.lisaaUusiSana(nykyinen);
            }

            if (edellinen != null) {
                teksti.lisaaNaapuri(edellinen, nykyinen, false);
            }

            if (edellinen != null) {
                teksti.lisaaNaapuri(nykyinen, edellinen, true);
            }

            teksti.getSananNaapurit(nykyinen).sanaEsiintyy();
            edellinen = nykyinen;
        }
        
        lukija.tiedostoValmis();
        return teksti;
    }
}