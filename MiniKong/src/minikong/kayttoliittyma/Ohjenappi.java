package minikong.kayttoliittyma;

import java.awt.Container;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import minikong.kayttoliittyma.kuuntelijat.OhjeKuuntelija;

public class Ohjenappi {
    
    private Container container;
    private GridBagConstraints gbc;

    Ohjenappi(Container container, GridBagConstraints gridBagConstraints) {
        this.container = container;
        gbc = gridBagConstraints;
        asetaRuutuun();
        teeKomponentit();
    }

    private void teeKomponentit() {
        JButton ohje = new JButton("Ohje");
        lisaaKuuntelijat(ohje);
    }

    private void lisaaKuuntelijat(JButton ohje) {
        OhjeKuuntelija ok = new OhjeKuuntelija();
        ohje.addActionListener(ok);
        lisaaPaaikkunaan(ohje);
    }

    private void asetaRuutuun() {
        gbc.anchor = GridBagConstraints.FIRST_LINE_END;                
    }

    private void lisaaPaaikkunaan(JButton ohje) {
        container.add(ohje, gbc);
    }
}