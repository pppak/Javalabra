package minikong.domain;

import java.util.TreeMap;
import minikong.util.Siistija;

public class TekstinTiedot {
    
    private Siistija siistija;
    private int sanamaara;
    private TreeMap<String, SananNaapurit> sanojenNaapurit;

    public TekstinTiedot() {
        siistija = new Siistija();
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

    public int getSanamaara() {
        return sanamaara;
    }
    
    public SananNaapurit getSana(String sana) {
        return this.sanojenNaapurit.get(sana);
    }
    
    public void lisaaUusiSana(String sana){
        sana = this.siistija.trim(sana);
        this.sanojenNaapurit.put(sana, new SananNaapurit(sana));
    }
    
    public void lisaaNaapuri(String sana, String naapuri, Boolean vasenVai) {
        sana = this.siistija.trim(sana);
        if (vasenVai) {
            this.sanojenNaapurit.get(sana).lisaaVasen(naapuri);
        } else {
            this.sanojenNaapurit.get(sana).lisaaOikea(naapuri);
        }
    }
    
    
}