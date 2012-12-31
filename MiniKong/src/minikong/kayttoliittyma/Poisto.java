package minikong.kayttoliittyma;

import java.awt.Container;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import minikong.kayttoliittyma.kuuntelijat.PoistonappiKuuntelija;

public class Poisto {

    Poisto(Tuloslaatikko tulo, Container container, GridBagConstraints gbc) {
        lisaaIkkunaan(teeKomponentit(tulo), asennaRuutuun(gbc), container);
    }

    private JButton teeKomponentit(Tuloslaatikko tulo) {
        JButton clear = new JButton("Poista tulokset");
        lisaaKuuntelija(clear, tulo);
        return clear;
    }

    private void lisaaKuuntelija(JButton clear, Tuloslaatikko tulo) {
        PoistonappiKuuntelija pnk = new PoistonappiKuuntelija(tulo);
        clear.addActionListener(pnk);
    }

    private GridBagConstraints asennaRuutuun(GridBagConstraints gbc) {
        gbc.anchor = GridBagConstraints.PAGE_END;
        gbc.gridy = 4;
        return gbc;
    }

    private void lisaaIkkunaan(JButton komp, GridBagConstraints c, Container container) {
        container.add(komp, c);
    }
}