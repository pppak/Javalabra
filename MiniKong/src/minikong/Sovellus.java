package minikong;

import java.util.HashMap;
import java.util.Scanner;
import javax.swing.SwingUtilities;
import minikong.domain.TekstinTiedot;
import minikong.kayttoliittyma.Paaikkuna;
import minikong.komennot.*;
import minikong.util.Lukija;

public class Sovellus {
    
    private Lukija lukija;
    private HashMap<Integer, Komento> komennot;
    private TekstinTiedot teksti; //muuta:arraylist tms. jos laajennetaan
    
    public Sovellus() { 
        this.lukija = new Lukija();
        this.teksti = new TekstinTiedot();
    }
    
    public void suorita() {
        //korvataan myöhemmin GUI:lla yms
        Paaikkuna GUI = new Paaikkuna(this.teksti);
        SwingUtilities.invokeLater(GUI);
    }
 
}
