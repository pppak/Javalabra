package minikong.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class SananNaapurit extends Sana{
    
    private HashMap<String, SananEsiintyma> vasen;
    private HashMap<String, SananEsiintyma> oikea;

    public SananNaapurit(String sana) {
        super(sana);
        this.vasen = new HashMap();
        this.oikea = new HashMap();
    }
    
    public String getSuurin(Boolean onkoVasen) {
        ArrayList<SananEsiintyma> jarjestettavaLista = new ArrayList();
        if (onkoVasen) {
            jarjestettavaLista.addAll(vasen.values());
        } else {
            jarjestettavaLista.addAll(oikea.values());
        }
        if (jarjestettavaLista.isEmpty()) {
            return "ei sanoja"; //toteuta paremmin?
        }
        Collections.sort(jarjestettavaLista);
        return jarjestettavaLista.get(0).getSana();
    }
    
    public void lisaaVasen(String v) {
        if (this.vasen.containsKey(v)) {
            SananEsiintyma es = this.vasen.get(v);
            es.sanaEsiintyy();
            this.vasen.put(v, es);
        } else {
            this.vasen.put(v, new SananEsiintyma(v));
        }
    }
    
    public void lisaaOikea(String o) {
        if (this.oikea.containsKey(o)) {
            SananEsiintyma es = this.oikea.get(o);
            es.sanaEsiintyy();
            this.oikea.put(o, es);
        } else {
            this.oikea.put(o, new SananEsiintyma(o));
        }
    }
    
}