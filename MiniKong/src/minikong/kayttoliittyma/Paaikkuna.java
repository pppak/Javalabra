package minikong.kayttoliittyma;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import minikong.domain.TekstinTiedot;

/** Luo käyttöliittymän pääikkunan ja asettaa sen komponentit.
 * 
 * @author Pia Pakarinen
 */

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
        
        ArrayList<Komponentti> paaikkunanOsat = new ArrayList();
        
        Tuloslaatikko tulo = new Tuloslaatikko();
        paaikkunanOsat.add(tulo);
        
        TulostenPoisto poisto = new TulostenPoisto(tulo);
        paaikkunanOsat.add(poisto);
        
        Ohjenappi ohje = new Ohjenappi();
        paaikkunanOsat.add(ohje);
        
        NaapurienMaaranValinta nm = new NaapurienMaaranValinta();
        paaikkunanOsat.add(nm);
        
        SanahakuJaSanojenTulostus sanahaku = new SanahakuJaSanojenTulostus(tulo, this.teksti, nm);
        paaikkunanOsat.add(sanahaku);
        
        TekstinValinta tiedval = new TekstinValinta(tulo, this.frame, this.teksti);
        paaikkunanOsat.add(tiedval);
                
        Tallennanappi tnappi = new Tallennanappi(tulo, this.frame);
        paaikkunanOsat.add(tnappi);
        
        lisaaIkkunaan(paaikkunanOsat, container);
    }

    private void lisaaIkkunaan(ArrayList<Komponentti> osat, Container container) {
        for (Komponentti komponentti : osat) {
            komponentti.asetaRuutuun();
            komponentti.teeKomponentit();
            container.add(komponentti.getOsa(), komponentti.getGbc());
        }
    }
}