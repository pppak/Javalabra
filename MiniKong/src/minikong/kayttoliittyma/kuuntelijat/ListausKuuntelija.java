package minikong.kayttoliittyma.kuuntelijat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import minikong.domain.TekstinTiedot;
import minikong.kayttoliittyma.ApuIkkuna;
import minikong.kayttoliittyma.komponentit.Tuloslaatikko;

/** Luo uuden ikkunan ja tuloslaatikon jossa näytetään tekstissä esiintyvät uniikit sanat.
 * 
 * @author Pia Pakarinen
 */
public class ListausKuuntelija implements ActionListener{

    /**
     * Tiedot sanoista sisältävä TekstinTiedot olio.
     */
    private TekstinTiedot tt;
    
    /**
     * Asettaa attribuutin parametrin mukaiseksi.
     * @param tt TekstinTiedot
     */
    public ListausKuuntelija(TekstinTiedot tt) {
        this.tt = tt;
    }

    /**
     * Luo uuden ikkunan ja Tuloslaatikon, ja tulostaa tähän tiedot tekstin sanoista.
     * @param ae käyttäjä on painanut nappia
     * 
     * @see minikong.kayttoliittyma.ApuIkkuna
     * @see minikong.kayttoliittyma.komponentit.Tuloslaatikko
     * @see minikong.domain.TekstinTiedot#kaikkiSanatTekstissäTulostus() 
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        Tuloslaatikko sanat = new Tuloslaatikko();
        sanat.addTeksti(tt.kaikkiSanatTekstissäTulostus());
        
        JPanel osat = new JPanel();
        osat.add(sanat.getLaatikko());
        
        ApuIkkuna ikkuna = new ApuIkkuna("Tekstistä löytyvät sanat", "OK", osat, 450, 450);
        ikkuna.run();
    }   
}