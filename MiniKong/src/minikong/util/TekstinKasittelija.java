package minikong.util;

import java.io.File;
import minikong.domain.TekstinTiedot;

/** Käy tekstin läpi sana sanalta ja tallentaa kaikkien erilaisten sanojen esiintymät ja näiden naapurit.
 * 
 * @author Pia Pakarinen
 */
public class TekstinKasittelija {

    /** Tiedot tallettava TekstinTiedot olio
     *
     */
    private TekstinTiedot teksti;
    /**
     * Tekstin sana sanalta läpikäyvä Lukija olio
     */
    private Lukija lukija;
    /**
     * Siistii läpikäytävät sanat
     */
    private Siistija siistija;

    /** Luo uuden Siistija olion, uuden Lukija olion joka saa parametrikseen annetun tiedoston, ja
     * asettaa tekstin.
     * 
     * @param tt TekstinTiedot olio johon käsittelyn tiedot tallennetaan
     * @param f Käyttäjän antama tekstitiedosto
     */
    public TekstinKasittelija(TekstinTiedot tt, File f) {
        this.teksti = tt;
        this.lukija = new Lukija(f);
        this.siistija = new Siistija();
    }

    /** Luo uuden Siistija olion, uuden Lukija olion joka saa parametrikseen annetun String-muotoisen tekstin, 
     * ja asettaa tekstin.
     * 
     * @param tt TekstinTiedot olio johon käsittelyn tiedot tallennetaan
     * @param text Käyttäjän syöttämä tekstitiedosto
     */
    public TekstinKasittelija(TekstinTiedot tt, String text) {
        this.teksti = tt;
        this.lukija = new Lukija(text);
        this.siistija = new Siistija();
    }

    /** Käy annetun tekstin läpi sana kerrallaan ja tallentaa tekstin sanamäärän, jokaisen 
     * uniikin tekstissä esiintyvän sanan, sekä listat sanojen välittömistä naapureista.
     * 
     * @return valmis TekstinTiedot olio
     */
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