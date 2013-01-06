package minikong.kayttoliittyma;

import java.awt.GridBagConstraints;
import javax.swing.JPanel;

/** Yliluokka Pääikkunan komponenteille. Määrittelee metodit pääikkunaan asettamiselle ja komponentin osien luomiselle.
 * 
 * @author Pia Pakarinen
 */

public abstract class Komponentti {
    
    private GridBagConstraints gbc;
    private JPanel osa;

    public Komponentti() {
        this.gbc = new GridBagConstraints();
        this.osa = new JPanel();
    }

    public GridBagConstraints getGbc() {
        return gbc;
    }

    public JPanel getOsa() {
        return osa;
    }
    
    abstract void asetaRuutuun();
    abstract void teeKomponentit();
}