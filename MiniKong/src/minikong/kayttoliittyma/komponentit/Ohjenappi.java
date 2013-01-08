package minikong.kayttoliittyma.komponentit;

import java.awt.GridBagConstraints;
import javax.swing.JButton;
import minikong.kayttoliittyma.kuuntelijat.OhjeKuuntelija;

/** Luo napin ohjeikkunaa varten.
 * 
 * @author Pia Pakarinen
 */
public class Ohjenappi extends Komponentti {

    /**
     * Luo uuden olion yläluokan konstruktorin mukaisesti.
     * @see minikong.kayttoliittyma.Komponentti#Komponentti() 
     */
    public Ohjenappi() {
        super();
    }

    /**
     * Luo napin Ohjeikkunaa varten, kutsuu kuuntelijan lisäävää metodia ja lisää napin
     * yläluokan JPanel olioon.
     * 
     * @see minikong.kayttoliittyma.Ohjenappi#lisaaKuuntelijat(javax.swing.JButton) 
     */
    @Override
    public void teeKomponentit() {
        JButton ohje = new JButton("Ohje");
        lisaaKuuntelijat(ohje);
        super.getOsa().add(ohje);
    }

    /**
     * Lisää parametrina annetulle napille ohjeikkunan luovan kuuntelijan.
     * @param ohje nappi jolle kuuntelija lisätään
     */
    private void lisaaKuuntelijat(JButton ohje) {
        OhjeKuuntelija ok = new OhjeKuuntelija();
        ohje.addActionListener(ok);
    }

    /**
     * Asettaa Ohjenapin pääikkunan ensimmäisen rivin loppuun.
     */
    @Override
    public void asetaRuutuun() {
        super.getGbc().anchor = GridBagConstraints.FIRST_LINE_END;
    }
}