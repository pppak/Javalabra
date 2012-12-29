package minikong;

import javax.swing.SwingUtilities;
import minikong.domain.TekstinTiedot;
import minikong.kayttoliittyma.Paaikkuna;

public class Sovellus {
    
    private TekstinTiedot teksti; //muuta:arraylist tms. jos laajennetaan
    
    public Sovellus() { 
        this.teksti = new TekstinTiedot();
    }
    
    public void suorita() {
        Paaikkuna GUI = new Paaikkuna(this.teksti);
        SwingUtilities.invokeLater(GUI);
    } 
}