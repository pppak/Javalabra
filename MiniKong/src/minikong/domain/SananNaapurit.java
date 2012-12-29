package minikong.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class SananNaapurit extends Sana{
    
    private HashMap<String, Sana> vasen;
    private HashMap<String, Sana> oikea;

    public SananNaapurit(String sana) {
        super(sana);
        this.vasen = new HashMap();
        this.oikea = new HashMap();
    }
    
    public Sana getSuurin(Boolean onkoVasen) {
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
        return jarjestettavaLista.get(0);
    }
    
    public void lisaaVasen(String v) {
        if (this.vasen.containsKey(v)) {
            Sana es = this.vasen.get(v);
            es.sanaEsiintyy();
            this.vasen.put(v, es);
        } else {
            this.vasen.put(v, new Sana(v));
        }
    }
    
    public void lisaaOikea(String o) {
        if (this.oikea.containsKey(o)) {
            Sana es = this.oikea.get(o);
            es.sanaEsiintyy();
            this.oikea.put(o, es);
        } else {
            this.oikea.put(o, new Sana(o));
        }
    }
}