package minikong.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/** Tallettaa Sana-luokan attribuuttien lisäksi jonkun tietyn sanan välittömät naapurit oikealta ja vasemmalta listoina.
 * 
 * @author Pia Pakarinen
 */

public class SananNaapurit extends Sana{
    
    /**
     * Lista sanan välittömistä naapureista vasemmalla puolella Sana-olioina
     */
    private HashMap<String, Sana> vasen;
    
    /**
     * Lista sanan välittömistä naapureista oikealla puolella Sana-olioina
     */
    private HashMap<String, Sana> oikea;

    /** Luo uuden SananNaapurit olion, joka asettaa esiintymismäärän ja sanan itse 
     * yliluoka konstruktorin mukaisesti, ja alustaa uudet tyhjät listat naapureita varten.
     * 
     * @param sana sana itse 
     */
    public SananNaapurit(String sana) {
        super(sana);
        this.vasen = new HashMap();
        this.oikea = new HashMap();
    }
    
    /** Järjestää sanan joko oikeat tai vasemmat naapurit ja palauttaa järjestetyn listan.
     * 
     * @param onkoVasen true jos halutaan järjestää listoista vasen
     * @return järjestetty lista
     */
    private ArrayList<Sana> jarjestaLista(Boolean onkoVasen) {
        ArrayList<Sana> jarjestettavaLista = new ArrayList();
        if (onkoVasen) {
            jarjestettavaLista.addAll(vasen.values());
        } else {
            jarjestettavaLista.addAll(oikea.values());
        }
        if (jarjestettavaLista.isEmpty()) {
            return null;
        }
        Collections.sort(jarjestettavaLista);
        return jarjestettavaLista;
    }
    
    /** Luo parametrien mukaisen suuruusjärjestyksessä olevan tulostuksen sanan naapureista.
     * 
     * @param maara kuinka monta naapureista tulostetaan
     * @param vasen true jos tulostetaan naapurit vasemmalta
     * @return käyttöliittymässä tulostettava teksti naapureista
     */
    public String tulostaNaapurit(int maara, Boolean vasen) {
        ArrayList<Sana> naapurit = this.jarjestaLista(vasen);
        if (naapurit == null) {
            return "Naapureita ei löydy.\n";
        }
        if (maara > naapurit.size()) {
            maara = naapurit.size();
        }
        String tulostus = "";
        for (int i = 0; i < maara; i++) {
           tulostus += "\n" + naapurit.get(i).getSana() + " (" + naapurit.get(i).getEsiintymisMaara() + ")";
        }
        return tulostus;
    }
    
    /** Lisää naapuriksi vasemmalle listalle uuden sanan, tai nostaa esiintymän esiintymismäärää jos
     * naapuri on jo löydetty.
     * 
     * @param v naapuriksi lisättävä sana
     */
    public void lisaaVasen(String v) {
        if (this.vasen.containsKey(v)) {
            this.vasen.get(v).sanaEsiintyy();
        } else {
            this.vasen.put(v, new Sana(v));
            this.vasen.get(v).sanaEsiintyy();
            
        }
    }
    
    /** Lisää naapuriksi oikealle listalle uuden sanan, tai nostaa esiintymän esiintymismäärää jos
     * naapuri on jo löydetty.
     * 
     * @param o naapuriksi lisättävä sana
     */
    public void lisaaOikea(String o) {
        if (this.oikea.containsKey(o)) {
            this.oikea.get(o).sanaEsiintyy();
        } else {
            this.oikea.put(o, new Sana(o));
            this.oikea.get(o).sanaEsiintyy();
        }
    }
}