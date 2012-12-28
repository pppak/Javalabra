package minikong.util;

import minikong.domain.TekstinTiedot;

public class TekstinKasittelija {

    private TekstinTiedot teksti;
    private Lukija lukija;
    private Siistija siistija;

    public TekstinKasittelija(TekstinTiedot t, Lukija l) {
        this.teksti = t;
        this.lukija = l;
        this.siistija = new Siistija();
    }

    public TekstinTiedot kasittele() {
        String edellinen = null;
        String nykyinen;
        while (lukija.onkoSeuraava()) {
            nykyinen = this.siistija.trim(lukija.seuraavaSana());
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

            teksti.getSana(nykyinen).sanaEsiintyy();
            edellinen = nykyinen;
        }
        lukija.tiedostoValmis();
        return teksti;
    }
}