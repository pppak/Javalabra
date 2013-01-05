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
        frame.setPreferredSize(new Dimension(600, 600));

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
        
        NaapurienMaara nm = new NaapurienMaara();
        osat.add(nm);
        
        SanahakuJaSanojenTulostus sanahaku = new SanahakuJaSanojenTulostus(tulo, this.teksti, nm);
        osat.add(sanahaku);
        
        TekstinValinta tiedval = new TekstinValinta(tulo, this.frame, this.teksti);
        osat.add(tiedval);
                
        Tallennanappi tnappi = new Tallennanappi(tulo, this.frame);
        osat.add(tnappi);
        
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