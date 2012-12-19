package minikong.util;

import minikong.domain.TekstinTiedot;

public class TekstinKasittelija {

    private TekstinTiedot teksti;
    private Lukija lukija;

    public TekstinKasittelija(TekstinTiedot t, Lukija l) {
        this.teksti = t;
        this.lukija = l;
    }

    public TekstinTiedot kasittele() {
        String edellinen = null;
        String nykyinen;
        while (lukija.onkoSeuraava()) {
            nykyinen = lukija.seuraavaSana();
            teksti.plusSanamaara();
            
            if (edellinen != null) {
                teksti.lisaaNaapuri(edellinen, nykyinen, false);
            }
            
            if (!teksti.sanaListattu(nykyinen)) {
                teksti.lisaaUusiSana(nykyinen);
                if (edellinen != null) {
                    teksti.lisaaNaapuri(nykyinen, edellinen, true);
                }
            } else {
                if (edellinen != null) {
                    teksti.lisaaNaapuri(nykyinen, edellinen, true);
                }
            }
            edellinen = nykyinen;
        }
        lukija.tiedostoValmis();
        return teksti;
    }
}
