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

    private TekstinTiedot tt;
    
    public ListausKuuntelija(TekstinTiedot tt) {
        this.tt = tt;
    }

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