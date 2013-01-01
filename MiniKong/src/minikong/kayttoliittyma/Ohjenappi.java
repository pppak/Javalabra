package minikong.kayttoliittyma;

import java.awt.GridBagConstraints;
import javax.swing.JButton;
import minikong.kayttoliittyma.kuuntelijat.OhjeKuuntelija;

public class Ohjenappi extends Komponentti {

    Ohjenappi() {
        super();
    }

    @Override
    public void teeKomponentit() {
        JButton ohje = new JButton("Ohje");
        lisaaKuuntelijat(ohje);
        super.getOsa().add(ohje);
    }

    private void lisaaKuuntelijat(JButton ohje) {
        OhjeKuuntelija ok = new OhjeKuuntelija();
        ohje.addActionListener(ok);
    }

    @Override
    public void asetaRuutuun() {
        super.getGbc().anchor = GridBagConstraints.FIRST_LINE_END;
    }
}