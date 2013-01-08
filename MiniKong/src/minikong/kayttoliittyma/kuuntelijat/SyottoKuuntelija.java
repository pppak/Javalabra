package minikong.kayttoliittyma.kuuntelijat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;
import minikong.domain.TekstinTiedot;
import minikong.kayttoliittyma.ApuIkkuna;
import minikong.kayttoliittyma.komponentit.Tuloslaatikko;
import minikong.util.TekstinKasittelija;

/** Laittaa syötetyn tekstin käsittelyyn ja tulostaa käsittelyn tulokset.
 * 
 * @author Pia Pakarinen
 */
class SyottoKuuntelija implements ActionListener{

    private JTextArea syottoAlue;
    private TekstinTiedot teksti;
    private Tuloslaatikko tulo;
    private ApuIkkuna ikkuna;
    
    SyottoKuuntelija(JTextArea pasta, TekstinTiedot tt, Tuloslaatikko tulo, ApuIkkuna ikkuna) {
        this.syottoAlue = pasta;
        this.teksti = tt;
        this.tulo = tulo;
        this.ikkuna = ikkuna;
    }   

    @Override
    public void actionPerformed(ActionEvent ae) {
        this.teksti.uusiTeksti();
        TekstinKasittelija parser = new TekstinKasittelija(this.teksti, syottoAlue.getText());
        this.teksti = parser.kasittele();
        
        paivitaTulokset(teksti);
        this.ikkuna.getFrame().dispose();
    }

    private void paivitaTulokset(TekstinTiedot tt) {
        if (tt.getSanamaara() == 0) {
            tulo.addTeksti("Tekstiä ei syötetty.\n");
            return;
        }
        tulo.addTeksti("*Oma teksti syötetty!*\n");
        tulo.addTeksti(this.teksti.sanamaaraTulostus());
        tulo.addTeksti("---\n");
    }  
}