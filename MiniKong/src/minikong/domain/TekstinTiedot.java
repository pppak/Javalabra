package minikong.domain;

import java.util.TreeMap;

public class TekstinTiedot {

    private int sanamaara;
    private TreeMap<String, SananNaapurit> sanojenEsiintymat;

    public TekstinTiedot() {
        this.sanojenEsiintymat = new TreeMap();
        this.sanamaara = 0;
    }
    
    public boolean sanaListattu(String sana) {
        if (this.sanojenEsiintymat.containsKey(sana)) {
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
        return this.sanojenEsiintymat.get(sana);
    }
    
    public void lisaaUusiSana(String sana){
        //deal with pisteet
        this.sanojenEsiintymat.put(sana, new SananNaapurit(sana));
    }
    
    public void lisaaNaapuri(String sana, String naapuri, Boolean vasenVai) {
        if (vasenVai) {
            this.sanojenEsiintymat.get(sana).lisaaVasen(naapuri);
        } else {
            this.sanojenEsiintymat.get(sana).lisaaOikea(naapuri);
        }
    }
    
    
}