package minikong.kayttoliittyma.kuuntelijat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import minikong.kayttoliittyma.komponentit.Tuloslaatikko;

/** Tyhjentää tulokset laatikosta.
 * 
 * @author Pia Pakarinen
 */
public class PoistonappiKuuntelija implements ActionListener{

    /**
     * Tuloslaatikko joka tyhjennetään.
     */
    private Tuloslaatikko tulo;
    
    /**
     * Asettaa Tuloslaatikko tulon parametrien mukaiseksi.
     * @param tulo Tuloslaatikko
     */
    public PoistonappiKuuntelija(Tuloslaatikko tulo) {
        this.tulo = tulo;
    }

    /**
     * Tyhjentää Tuloslaatikon tekstistä.
     * @param ae käyttäjä painaa nappia
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        tulo.tyhjenna();
    }   
}