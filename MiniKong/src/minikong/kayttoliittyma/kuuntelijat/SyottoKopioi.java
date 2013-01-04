package minikong.kayttoliittyma.kuuntelijat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;
import minikong.domain.TekstinTiedot;
import minikong.kayttoliittyma.ApuIkkuna;
import minikong.kayttoliittyma.Tuloslaatikko;
import minikong.util.TekstinKasittelija;

class SyottoKopioi implements ActionListener{

    private JTextArea pasta;
    private TekstinTiedot tt;
    private Tuloslaatikko tulo;
    private ApuIkkuna ikkuna;
    
    SyottoKopioi(JTextArea pasta, TekstinTiedot tt, Tuloslaatikko tulo, ApuIkkuna ikkuna) {
        this.pasta = pasta;
        this.tt = tt;
        this.tulo = tulo;
        this.ikkuna = ikkuna;
    }   

    @Override
    public void actionPerformed(ActionEvent ae) {
        TekstinKasittelija parser = new TekstinKasittelija(this.tt, pasta.getText());
        this.tt = parser.kasittele();
        
        paivitaTulokset(tt);
        this.ikkuna.getFrame().dispose();
    }

    private void paivitaTulokset(TekstinTiedot tt) {
        if (tt.getSanamaara() == 0) {
            tulo.addTeksti("Tekstiä ei syötetty.\n");
            return;
        }
        tulo.addTeksti("*Oma tiedosto syötetty!*\n");
        tulo.addTeksti("Tekstin sanamäärä: " + tt.getSanamaara() + "\n");
        tulo.addTeksti("---\n");
    }
    
}