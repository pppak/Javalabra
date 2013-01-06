package minikong.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/** Tallettaa Sana-luokan attribuuttien lisäksi jonkun tietyn sanan välittömät naapurit oikealta ja vasemmalta listoina.
 * 
 * @author Pia Pakarinen
 */

public class SananNaapurit extends Sana{
    
    private HashMap<String, Sana> vasen;
    private HashMap<String, Sana> oikea;

    public SananNaapurit(String sana) {
        super(sana);
        this.vasen = new HashMap();
        this.oikea = new HashMap();
    }
    
    private ArrayList<Sana> getSuurimmatJarjestyksessa(Boolean onkoVasen) {
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
    
    public String tulostaNaapurit(int maara, Boolean vasen) {
        ArrayList<Sana> naapurit = this.getSuurimmatJarjestyksessa(vasen);
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
    
    public void lisaaVasen(String v) {
        if (this.vasen.containsKey(v)) {
            this.vasen.get(v).sanaEsiintyy();
        } else {
            this.vasen.put(v, new Sana(v));
            this.vasen.get(v).sanaEsiintyy();
            
        }
    }
    
    public void lisaaOikea(String o) {
        if (this.oikea.containsKey(o)) {
            this.oikea.get(o).sanaEsiintyy();
        } else {
            this.oikea.put(o, new Sana(o));
            this.oikea.get(o).sanaEsiintyy();
        }
    }
}