package minikong.kayttoliittyma;

import java.awt.GridBagConstraints;
import javax.swing.JButton;
import minikong.kayttoliittyma.kuuntelijat.PoistonappiKuuntelija;

public class Poisto extends Komponentti{

    private Tuloslaatikko tulo;
    
    Poisto(Tuloslaatikko tulo) {
        super();
        this.tulo = tulo;
    }

    private void lisaaKuuntelija(JButton poisto) {
        PoistonappiKuuntelija pnk = new PoistonappiKuuntelija(tulo);
        poisto.addActionListener(pnk);
    }

    @Override
    public void asetaRuutuun() {
        super.getGbc().anchor = GridBagConstraints.PAGE_END;
        super.getGbc().gridy = 4;
    }

    @Override
    public void teeKomponentit() {
        JButton poisto = new JButton("Poista tulokset");
        lisaaKuuntelija(poisto);
        super.getOsa().add(poisto);
    }
}