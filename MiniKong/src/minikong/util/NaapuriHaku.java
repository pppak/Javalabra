package minikong.util;

import minikong.domain.SananNaapurit;
import minikong.domain.TekstinTiedot;

/**
 * Muodostaa sanan naapurin haun tulostukset.
 *
 * @author Pia Pakarinen
 */
public class NaapuriHaku{

    /**
     * TekstinTiedot joka sisältää haettavat tiedot.
     */
    private TekstinTiedot tt;
    /**
     * Haettavien naapureiden määrä.
     */
    private int maara;
    /**
     * Sana, jonka naapureita haetaan.
     */
    private String haettu;

    /**
     * Asettaa attribuutit parametrien mukaisiki ja siistii haettavan sanan.
     *
     * @param teksti TekstinTiedot
     * @param maara Naapurien määrä
     * @param haku Haettava sana
     */
    public NaapuriHaku(TekstinTiedot teksti, int maara, String haku) {
        this.tt = teksti;
        this.maara = maara;
        this.haettu = new Siistija().trim(haku);
    }

    /**
     * Palauttaa tulostettavat tiedot.
     *
     * @return käyttöliittymän tulostus
     */
    public String tee() {
        if (tarkistaTeksti()) {
            return "Valitse ensin teksti josta sanaa etsitään! \n";
        } else if (tarkistaHaettu()) {
            return "Sanaa \'" + haettu + "\' ei löydy tekstistä.\n";
        }

        return teeTulostus();
    }

    /**
     * Tarkistaa, onko käsittelyssä tyhjä teksti.
     *
     * @return true, jos käsiteltävä teksti on tyhjä
     */
    private boolean tarkistaTeksti() {
        if (this.tt.getSanamaara() == 0) {
            return true;
        }
        return false;
    }

    /**
     * Tarkistaa onko haettava sana tyhjä ja löytyykö sitä tekstistä.
     *
     * @return true jos haettavan naapureita ei ole mahdollista hakea
     */
    private boolean tarkistaHaettu() {
        if (this.haettu.isEmpty() || !this.tt.sanaListattu(haettu)) {
            return true;
        }
        return false;
    }

    /**
     * Muodostaa haettavan sanan naapureiden tulostusmuodon.
     *
     * @return käyttäjälle tulostettava teksti
     */
    private String teeTulostus() {
        SananNaapurit sana = tt.getSananNaapurit(haettu);
        return "Haettu sana: " + haettu + "\n"
                + "Sana esiintyy tekstissä " + sana.getEsiintymisMaara() + " kertaa" + "\n"
                + "Yleisimmät naapurisanat vasemmalla: " + sana.tulostaNaapurit(maara, true) + "\n"
                + "Yleisimmät naapurisanat oikealla: " + sana.tulostaNaapurit(maara, false) + "\n"
                + "***\n";
    }
}