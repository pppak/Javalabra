package minikong.kayttoliittyma;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import minikong.domain.TekstinTiedot;

public class Paaikkuna implements Runnable {

    private JFrame frame;
    private TekstinTiedot teksti;

    public Paaikkuna(TekstinTiedot t) {
        this.teksti = t;
    }

    @Override
    public void run() {
        frame = new JFrame();
        frame.setPreferredSize(new Dimension(500, 500));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        teeKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void teeKomponentit(Container container) {
        container.setLayout(new GridBagLayout());
        
        ArrayList<Komponentti> osat = new ArrayList();
        Tuloslaatikko tulo = new Tuloslaatikko();
        osat.add(tulo);
        
        Poisto poisto = new Poisto(tulo);
        osat.add(poisto);
        
        Ohjenappi ohje = new Ohjenappi();
        osat.add(ohje);
        
        Sanahaku sanahaku = new Sanahaku(tulo, this.teksti);
        osat.add(sanahaku);
        
        TiedostonValinta tiedval = new TiedostonValinta(tulo, this.frame, this.teksti);
        osat.add(tiedval);
        
        lisaaIkkunaan(osat, container);
        
    }

    private void lisaaIkkunaan(ArrayList<Komponentti> osat, Container container) {
        for (Komponentti komponentti : osat) {
            komponentti.asetaRuutuun();
            komponentti.teeKomponentit();
            container.add(komponentti.getOsa(), komponentti.getGbc());
        }
    }
}