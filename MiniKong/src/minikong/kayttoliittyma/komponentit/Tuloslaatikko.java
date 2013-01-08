package minikong.kayttoliittyma.komponentit;

import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/** Luo laatikon jossa hakujen ja tekstinkäsittelyn tulokset näytetään.
 * 
 * @author Pia Pakarinen
 */

public class Tuloslaatikko extends Komponentti {

    /**
     * Attribuutin tulokset sisältävä JScrollPane
     * @see minikong.kayttoliittyma.Tuloslaatikko#tulokset
     */
    private JScrollPane laatikko;
    /**
     * JTextArea johon tieto tuloksista tulostetaan.
     */
    private JTextArea tulokset;

    /**
     * Kutsuu yläluokan konstruktoria, asettaa attribuuteille uudet oliot; asettaa tulokset
     * ei-editoitaviksi ja asettaa laatikolle halutun koon.
     */
    public Tuloslaatikko() {
        super();
        tulokset = new JTextArea();
        tulokset.setEditable(false);
        laatikko = new JScrollPane(tulokset);
        laatikko.setPreferredSize(new Dimension(450, 300));
    }

    /**
     * Lisää tuloslaatikkon parametrinä saadun tekstin.
     * @param tulos laatikkoon tulostettava teksti
     */
    public void addTeksti(String tulos) {
        tulokset.append(tulos);
    }

    /**
     * Poistaa tuloslaatikosta tekstin.
     */
    public void tyhjenna() {
        tulokset.setText("");
    }

    /**
     * Palauttaa attribuutin laatikko.
     * @return laatikko
     * @see minikong.kayttoliittyma.Tuloslaatikko#laatikko
     */
    public Component getLaatikko() {
        return laatikko;
    }

    /**
     * Palauttaa attribuutin tulokset.
     * @return tulokset
     * @see minikong.kayttoliittyma.Tuloslaatikko#tulokset
     */
    public JTextArea getTulokset() {
        return tulokset;
    }

    /**
     * Asettaa Tuloslaatikon pääikkunan viidennelle riville.
     */
    @Override
    public void asetaRuutuun() {
        super.getGbc().gridy = 5;
    }

    /**
     * Lisää JScrollPane olion laatikko yläluokan JPanel olioon.
     * @see minikong.kayttoliittyma.Tuloslaatikko#laatikko
     */
    @Override
    public void teeKomponentit() {
        super.getOsa().add(this.laatikko);
    }
}