package minikong.kayttoliittyma;

import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

/** Luo etsittävien naapurien määrän määrittävän osion Pääikkunaa varten.
 * 
 * @author Pia Pakarinen
 */

public class NaapurienMaaranValinta extends Komponentti{

    SpinnerModel num;
    
    public NaapurienMaaranValinta() {
        super();
    }    

    @Override
    void asetaRuutuun() {
        super.getGbc().gridy = 4;
    }

    @Override
    void teeKomponentit() {
        JLabel teksti = new JLabel("Naapureita näytetään: ");
        num = new SpinnerNumberModel(1, 1, 999, 1);
        JSpinner sp = new JSpinner(num);
        super.getOsa().add(teksti);
        super.getOsa().add(sp);
    }

    public int getMaara() {
        return (Integer)num.getValue();
    }    
}