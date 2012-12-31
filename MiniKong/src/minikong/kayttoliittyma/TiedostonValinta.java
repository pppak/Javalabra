package minikong.kayttoliittyma;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import minikong.domain.TekstinTiedot;
import minikong.kayttoliittyma.kuuntelijat.TiedostoKuuntelija;

public class TiedostonValinta {

    private TekstinTiedot tt;
    private JFrame frame;
    private Tuloslaatikko tulo;

    TiedostonValinta(Tuloslaatikko tulo, Container container, GridBagConstraints gbc, JFrame frame, TekstinTiedot tt) {
        this.tt = tt;
        this.frame = frame;
        this.tulo = tulo;
        lisaaKomponentit(teeKomponentit(), asetaRuutuun(gbc), container);
    }

    private GridBagConstraints asetaRuutuun(GridBagConstraints c) {
        c.gridy = 1;
        c.insets = new Insets(10, -10, 5, 10);
        return c;
    }

    private JButton teeKomponentit() {
        JButton tiedosto = new JButton("Valitse tekstitiedosto...");
        lisaaKuuntelija(tiedosto);
        return tiedosto;
    }

    private void lisaaKuuntelija(JButton tiedosto) {
        TiedostoKuuntelija tied = new TiedostoKuuntelija(tt, frame, tulo);
        tiedosto.addActionListener(tied);
    }

    private void lisaaKomponentit(JButton k, GridBagConstraints c, Container container) {
        container.add(k, c);
    }
}