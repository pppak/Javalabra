package minikong.domain;

import java.util.TreeMap;

/** Tallettaa käsiteltävän tekstin sanamäärän ja tekstin sanat SananNaapuri-luokan ilmentyminä.
 * 
 * @author Pia Pakarinen
 */

public class TekstinTiedot {

    private int sanamaara;
    private TreeMap<String, SananNaapurit> sanojenNaapurit;

    public TekstinTiedot() {
        this.sanojenNaapurit = new TreeMap();
        this.sanamaara = 0;
    }

    public boolean sanaListattu(String sana) {
        if (this.sanojenNaapurit.containsKey(sana)) {
            return true;
        }
        return false;
    }

    public void plusSanamaara() {
        this.sanamaara++;
    }

    public String sanamaaraTulostus() {
        return "Tekstin sanamäärä: " + sanamaara + ". Uniikkeja sanoja löytyy " 
                + this.sanojenNaapurit.size() + ".\n";
    }

    public SananNaapurit getSananNaapurit(String sana) {
        return this.sanojenNaapurit.get(sana);
    }

    public void lisaaUusiSana(String sana) {
        this.sanojenNaapurit.put(sana, new SananNaapurit(sana));
    }

    public void lisaaNaapuri(String sana, String naapuri, Boolean vasen) {
        if (vasen) {
            this.sanojenNaapurit.get(sana).lisaaVasen(naapuri);
        } else {
            this.sanojenNaapurit.get(sana).lisaaOikea(naapuri);
        }
    }
    
    public String kaikkiSanatTekstissäTulostus(){
        String lista = "";
        
        for (String s : this.sanojenNaapurit.keySet()) {
            lista += s + " (" + this.getSananNaapurit(s).getEsiintymisMaara() + ")\n";
        }
        return lista;
    }
   
    public void uusiTeksti(){
        this.sanamaara = 0;
        this.sanojenNaapurit = new TreeMap();
    }

    public int getSanamaara() {
        return sanamaara;
    }
}