package minikong.kayttoliittyma;

import javax.swing.JButton;
import minikong.kayttoliittyma.kuuntelijat.PoistonappiKuuntelija;

public class TulostenPoisto extends Komponentti{

    private Tuloslaatikko tulo;
    
    TulostenPoisto(Tuloslaatikko tulo) {
        super();
        this.tulo = tulo;
    }

    private void lisaaKuuntelija(JButton poisto) {
        PoistonappiKuuntelija pnk = new PoistonappiKuuntelija(tulo);
        poisto.addActionListener(pnk);
    }

    @Override
    public void asetaRuutuun() {
        super.getGbc().gridy = 7;
    }

    @Override
    public void teeKomponentit() {
        JButton poisto = new JButton("Poista tulokset");
        lisaaKuuntelija(poisto);
        super.getOsa().add(poisto);
    }
}