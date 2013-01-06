package minikong.kayttoliittyma;

import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import minikong.domain.TekstinTiedot;
import minikong.kayttoliittyma.kuuntelijat.SyottonappiKuuntelija;
import minikong.kayttoliittyma.kuuntelijat.TiedostoKuuntelija;

/** Luo napit käsiteltävän tekstin valitsemiseen joko tiedostona tai suoraan
 * syötettävänä.
 * 
 * @author Pia Pakarinen
 */

public class TekstinValinta extends Komponentti{

    private TekstinTiedot tt;
    private JFrame frame;
    private Tuloslaatikko tulo;

    TekstinValinta(Tuloslaatikko tulo, JFrame frame, TekstinTiedot tt) {
        super();
        this.tt = tt;
        this.frame = frame;
        this.tulo = tulo;
    }

    @Override
    public void asetaRuutuun() {
        super.getGbc().gridy = 1;
        super.getGbc().insets = new Insets(0, 30, 0, 0);
    }

    @Override
    public void teeKomponentit() {
        JButton tiedosto = new JButton("Valitse tekstitiedosto...");
        JButton syota = new JButton("Syötä tekstiä");
        lisaaKuuntelija(tiedosto, syota);
        super.getOsa().add(tiedosto);
        super.getOsa().add(syota);
    }

    private void lisaaKuuntelija(JButton tiedosto, JButton syota) {
        TiedostoKuuntelija tied = new TiedostoKuuntelija(tt, frame, tulo);
        tiedosto.addActionListener(tied);
        
        SyottonappiKuuntelija sk = new SyottonappiKuuntelija(tt, tulo);
        syota.addActionListener(sk);
    }
}