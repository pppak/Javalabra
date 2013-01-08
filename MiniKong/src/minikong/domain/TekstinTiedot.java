package minikong.domain;

import java.util.TreeMap;

/** Tallettaa käsiteltävän tekstin sanamäärän ja tekstin sanat SananNaapuri-luokan ilmentyminä.
 * 
 * @author Pia Pakarinen
 */
public class TekstinTiedot {

    /**
     * Tekstissä esiintyvien sanojen kokonaismäärä.
     */
    private int sanamaara;
    
    /**
     * Lista tekstissä esiintyistä sanoista SanaNaapurit-olioina.
     */
    private TreeMap<String, SananNaapurit> sanojenNaapurit;

    /**
     * Luodaan uusi TekstinTiedot-olio tyhjällä sanalistalla ja sanamäärällä 0.
     */
    public TekstinTiedot() {
        this.sanojenNaapurit = new TreeMap();
        this.sanamaara = 0;
    }

    /** Tarkistaa löytyykö parametrina annettua sanaa tekstistä.
     * 
     * @param sana haettava sana
     * @return true jos sana löytyy tekstistä
     */
    public boolean sanaListattu(String sana) {
        if (this.sanojenNaapurit.containsKey(sana)) {
            return true;
        }
        return false;
    }

    /**
     * Nostaa tekstin sanamäärää yhdellä.
     */
    public void plusSanamaara() {
        this.sanamaara++;
    }

    /** Luo käyttöliittymää varten String-olion jossa on tietoa tekstin kokonaissanamäärästä
     * ja tekstissä esiintyvien uniikkien sanojen määrästä.
     * 
     * @return tietoa tekstin sanamääristä
     */
    public String sanamaaraTulostus() {
        return "Tekstin sanamäärä: " + sanamaara + ". Erilaisia sanoja löytyy " 
                + this.sanojenNaapurit.size() + ".\n";
    }

    /** Palauttaa parametrina saadun sanan SananNaapurit-esiintymän.
     * 
     * @param sana haettava sana
     * @return parametrina saadun sanan SananNaapurit-esiintymä
     */
    public SananNaapurit getSananNaapurit(String sana) {
        return this.sanojenNaapurit.get(sana);
    }

    /** Lisätään uusi sana tekstin tietoihin.
     * 
     * @param sana lisättävä sana
     */
    public void lisaaUusiSana(String sana) {
        this.sanojenNaapurit.put(sana, new SananNaapurit(sana));
    }

    /** Lisätään parametrina saadulle sanalle parametrina saatu naapuri halutulle
     * listalle.
     * 
     * @param sana sana jolle naapuri lisätään
     * @param naapuri lisättävä naapuri
     * @param vasen true jos naapuri esiintyi vasemmalla
     */
    public void lisaaNaapuri(String sana, String naapuri, Boolean vasen) {
        if (vasen) {
            this.sanojenNaapurit.get(sana).lisaaVasen(naapuri);
        } else {
            this.sanojenNaapurit.get(sana).lisaaOikea(naapuri);
        }
    }
    
    /** Muodostaa tekstin kaikista tekstissä esiintyvistä sanoista ja niiden
     * esiintymismääristä.
     * 
     * @return tietoa tekstin sanoista käyttöliittymän tulostusta varten
     */
    public String kaikkiSanatTekstissäTulostus(){
        String lista = "";
        
        for (String s : this.sanojenNaapurit.keySet()) {
            lista += s + " (" + this.getSananNaapurit(s).getEsiintymisMaara() + ")\n";
        }
        return lista;
    }
   
    /**
     * Nollaa entisen tekstin uuden asettamista varten.
     */
    public void uusiTeksti(){
        this.sanamaara = 0;
        this.sanojenNaapurit = new TreeMap();
    }

    /** Palauttaa tekstin sanamäärän.
     * 
     * @return tekstin sanamäärä
     */
    public int getSanamaara() {
        return sanamaara;
    }
}