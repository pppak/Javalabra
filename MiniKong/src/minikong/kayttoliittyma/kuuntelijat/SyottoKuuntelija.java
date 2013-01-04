package minikong.kayttoliittyma.kuuntelijat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;
import minikong.domain.TekstinTiedot;
import minikong.kayttoliittyma.ApuIkkuna;
import minikong.kayttoliittyma.Tuloslaatikko;
import minikong.util.TekstinKasittelija;

class SyottoKuuntelija implements ActionListener{

    private JTextArea pasta;
    private TekstinTiedot teksti;
    private Tuloslaatikko tulo;
    private ApuIkkuna ikkuna;
    
    SyottoKuuntelija(JTextArea pasta, TekstinTiedot tt, Tuloslaatikko tulo, ApuIkkuna ikkuna) {
        this.pasta = pasta;
        this.teksti = tt;
        this.tulo = tulo;
        this.ikkuna = ikkuna;
    }   

    @Override
    public void actionPerformed(ActionEvent ae) {
        this.teksti.uusiTeksti();
        TekstinKasittelija parser = new TekstinKasittelija(this.teksti, pasta.getText());
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
        tulo.addTeksti("Tekstin sanamäärä: " + tt.getSanamaara() + ". Uniikkeja sanoja esiintyy tekstissä " + this.teksti.uniikitSanat() + ".\n");
        tulo.addTeksti("---\n");
    }
    
}