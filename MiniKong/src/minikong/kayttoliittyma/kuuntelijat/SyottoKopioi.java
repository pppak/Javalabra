package minikong.kayttoliittyma.kuuntelijat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;
import minikong.domain.TekstinTiedot;
import minikong.kayttoliittyma.Tuloslaatikko;
import minikong.util.TekstinKasittelija;

class SyottoKopioi implements ActionListener{

    private JTextArea pasta;
    private TekstinTiedot tt;
    private Tuloslaatikko tulo;
    
    SyottoKopioi(JTextArea pasta, TekstinTiedot tt, Tuloslaatikko tulo) {
        this.pasta = pasta;
        this.tt = tt;
        this.tulo = tulo;
    }   

    @Override
    public void actionPerformed(ActionEvent ae) {
        TekstinKasittelija parser = new TekstinKasittelija(this.tt, pasta.getText());
        this.tt = parser.kasittele();
        
        paivitaTulokset(tt);
    }

    private void paivitaTulokset(TekstinTiedot tt) {
        tulo.addTeksti("*Oma tiedosto syötetty!*\n");
        tulo.addTeksti("Tekstin sanamäärä: " + tt.getSanamaara() + "\n");
        tulo.addTeksti("---\n");
    }
    
}