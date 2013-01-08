package minikong.kayttoliittyma.komponentit;

import java.awt.GridBagConstraints;
import javax.swing.JPanel;

/** Yliluokka Pääikkunan komponenteille. Määrittelee metodit pääikkunaan asettamiselle ja komponentin osien luomiselle.
 * 
 * @author Pia Pakarinen
 */

public abstract class Komponentti {

    /**
     * GridBagConstraintit kyseiselle komponentille.
     */
    private GridBagConstraints gbc;
    /**
     * Komponentin osat sisältävä JPanel-olio.
     */
    private JPanel osa;

    /**
     * Luo uuden komponentti-olion ja alustaa uudet GridBagConstraint ja JPanel oliot.
     */
    public Komponentti() {
        this.gbc = new GridBagConstraints();
        this.osa = new JPanel();
    }

    /**
     * Palauttaa komponentin sisältämän GridBagConstraint olion.
     * @return komponentin GridBagConstraint olio 
     */
    public GridBagConstraints getGbc() {
        return gbc;
    }

    /** Palauttaa komponentin JPanel olion.
     * 
     * @return komponentin JPanel olio
     */
    public JPanel getOsa() {
        return osa;
    }
    
    /**
     * Asettaa GridBagConstraint-olioon tarvittavat tiedot.
     */
    public abstract void asetaRuutuun();
    /**
     * Tekee komponentin tarvitsemat osat ja asettaa ne JPanel olioon.
     */
    public abstract void teeKomponentit();
}