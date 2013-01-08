package minikong.kayttoliittyma.komponentit;

import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

/** Luo etsittävien naapurien määrän määrittävän osion Pääikkunaa varten.
 * 
 * @author Pia Pakarinen
 */

public class NaapurienMaaranValinta extends Komponentti{

    /**
     * Haettavien naapurien määrän näyttävä ja valitseva SpinnerModel olio.
     */
    SpinnerModel num;
    
    /**
     * Luo NaapurienMaaranValinta olion yläluokan konstruktorin mukaisesti.
     * 
     * @see minikong.kayttoliittyma.Komponentti#Komponentti() 
     */
    public NaapurienMaaranValinta() {
        super();
    }    

    /**
     * Asettaa NaapurienMaaranValinta olion pääikkunan neljännelle riville.
     */
    @Override
    public void asetaRuutuun() {
        super.getGbc().gridy = 4;
    }

    /**
     * Luo tekstin ja numerokentän ja asettaa nämä yläluokan JPanel olioon.
     */
    @Override
    public void teeKomponentit() {
        JLabel teksti = new JLabel("Naapureita näytetään: ");
        num = new SpinnerNumberModel(1, 1, 999, 1);
        JSpinner sp = new JSpinner(num);
        super.getOsa().add(teksti);
        super.getOsa().add(sp);
    }

    /**
     * Palauttaa numerokentässä olevan luvun.
     * @return luku joka kertoo etsittävien naapurien määrän
     */
    public int getMaara() {
        return (Integer)num.getValue();
    }    
}