package minikong.kayttoliittyma;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import minikong.domain.TekstinTiedot;
import minikong.kayttoliittyma.komponentit.*;

/** Luo käyttöliittymän pääikkunan ja asettaa sen komponentit.
 * 
 * @author Pia Pakarinen
 */

public class Paaikkuna implements Runnable {

    /**
     * Pääikkunan JFrame olio.
     */
    private JFrame frame;
    /**
     * Käsiteltävän tekstin tiedot.
     */
    private TekstinTiedot teksti;

    /**
     * Luo uuden Paaikkunan ja asettaa tälle annetun TekstinTiedot olion.
     * @param t tiedot tallettava TekstinTiedot olio
     */
    public Paaikkuna(TekstinTiedot t) {
        this.teksti = t;
    }

    /**
     * Käynnistää ja kokoaa Pääikkunan, kutsuu teeKomponentit metodia.
     */
    @Override
    public void run() {
        frame = new JFrame();
        frame.setPreferredSize(new Dimension(600, 600));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        teeKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Tekee pääikkunaan kuuluvat osat ja asettaa ne odottamaan listalle. Lopuksi kutsuu lisaaIkkunaan
     * metodia.
     * @param container Pääikkunan container olio 
     */
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

    /**
     * Alustaa parametrina annetun listan Komponentti-oliot kutsumalla näiden asetaRuutuun ja
     * teeKomponentit metodeja. Asettaa oliot pääikkunan container olioon komponentin tietojen mukaisesti.
     * @param osat lista pääikkunaan asetettavista eri osista
     * @param container pääikkunan container olio
     * 
     * @see minikong.kayttoliittyma.Komponentti#asetaRuutuun() 
     * @see minikong.kayttoliittyma.Komponentti#teeKomponentit() 
     */
    private void lisaaIkkunaan(ArrayList<Komponentti> osat, Container container) {
        for (Komponentti komponentti : osat) {
            komponentti.asetaRuutuun();
            komponentti.teeKomponentit();
            container.add(komponentti.getOsa(), komponentti.getGbc());
        }
    }
}