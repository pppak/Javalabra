package minikong.domain;

import java.util.TreeMap;

public class TekstinTiedot {

    private int sanamaara;
    private TreeMap<String, SananEsiintyma> sanojenEsiintymat;

    public TekstinTiedot() {
        this.sanojenEsiintymat = new TreeMap();
    }

    public void setSanamaara(int sanamaara) {
        this.sanamaara = sanamaara;
    }

    public int getSanamaara() {
        return sanamaara;
    }
    
    public SananEsiintyma getSana(String sana) {
        return this.sanojenEsiintymat.get(sana);
    }
    
    
}
