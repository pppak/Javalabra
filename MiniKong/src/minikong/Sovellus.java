package minikong;

import java.util.HashMap;
import java.util.Scanner;
import minikong.domain.TekstinTiedot;
import minikong.komennot.*;
import minikong.util.Lukija;

public class Sovellus {
    
    private Lukija lukija;
    private HashMap<Integer, Komento> komennot;
    private TekstinTiedot teksti; //muuta:arraylist tms. jos laajennetaan
    
    public Sovellus() { 
        this.lukija = new Lukija();
        this.teksti = new TekstinTiedot();
        teeKomennot();
    }
    
    public void suorita() {
        //korvataan myöhemmin GUI:lla yms
        Scanner s = new Scanner(System.in);
        int valinta = s.nextInt();
        while (valinta == 1 || valinta == 2) {
            this.komennot.get(valinta).suorita();
            System.out.println("Sanamäärä: " + this.komennot.get(valinta).getTeksti().getSanamaara());;
            valinta = s.nextInt();
        }
    }

    private void teeKomennot() {
        this.komennot = new HashMap();
        this.komennot.put(1, new HankiTiedosto(teksti, lukija));
        this.komennot.put(2, new HaeSana(teksti, lukija));
    }
    
    
}
