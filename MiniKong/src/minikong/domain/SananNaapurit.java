package minikong.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class SananNaapurit extends Sana implements Comparable<SananNaapurit>{
    
    private HashMap<String, SananEsiintyma> vasen;
    private HashMap<String, SananEsiintyma> oikea;

    public SananNaapurit(String sana) {
        super(sana);
        this.vasen = new HashMap();
        this.oikea = new HashMap();
    }
    
    public String getVasen() {
        ArrayList<SananEsiintyma> lista = new ArrayList();
        lista.addAll(vasen.values());
        if (lista.isEmpty()) {
            return "Ei sanoja vasemmalla";
        }
        Collections.sort(lista);
        return lista.get(0).getSana();
    }
    
    public String getOikea() {
        ArrayList<SananEsiintyma> lista = new ArrayList();
        lista.addAll(oikea.values());
        if (lista.isEmpty()) {
            return "Ei sanoja oikealla";
        }
        Collections.sort(lista);
        return lista.get(0).getSana();
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
    

    @Override
    public int compareTo(SananNaapurit n) {
        if (super.getEsiintymisMaara() == n.getEsiintymisMaara()) {
            return 0;
        } else if (super.getEsiintymisMaara() > n.getEsiintymisMaara()) {
            return -1;
        } else {
            return 1;
        }
    }

    
}