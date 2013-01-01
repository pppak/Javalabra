package minikong.kayttoliittyma;

import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import minikong.domain.TekstinTiedot;
import minikong.kayttoliittyma.kuuntelijat.TiedostoKuuntelija;

public class TiedostonValinta extends Komponentti{

    private TekstinTiedot tt;
    private JFrame frame;
    private Tuloslaatikko tulo;

    TiedostonValinta(Tuloslaatikko tulo, JFrame frame, TekstinTiedot tt) {
        super();
        this.tt = tt;
        this.frame = frame;
        this.tulo = tulo;
    }

    @Override
    public void asetaRuutuun() {
        super.getGbc().gridy = 1;
        super.getGbc().insets = new Insets(10, -10, 5, 10);
    }

    @Override
    public void teeKomponentit() {
        JButton tiedosto = new JButton("Valitse tekstitiedosto...");
        lisaaKuuntelija(tiedosto);
        super.getOsa().add(tiedosto);
    }

    private void lisaaKuuntelija(JButton tiedosto) {
        TiedostoKuuntelija tied = new TiedostoKuuntelija(tt, frame, tulo);
        tiedosto.addActionListener(tied);
    }
}