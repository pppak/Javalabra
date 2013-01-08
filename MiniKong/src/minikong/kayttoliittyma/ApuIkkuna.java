package minikong.kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import minikong.kayttoliittyma.kuuntelijat.SulkunappiKuuntelija;

/** Luo uuden parametrien mukaisen pop-up ikkunan ja asettaa sen sisällön.
 * 
 * @author Pia Pakarinen
 */

public class ApuIkkuna implements Runnable{

    /**
     * Uuden ikkunan frame-olio.
     */
    private JFrame frame;
    /**
     * ApuIkkuna olion otsikkoteksti.
     */
    private String ikkunanOtsikko;
    /**
     * Ikkunan sulkevaan nappiin asetettava teksti.
     */
    private String sulkunapinTeksti;
    /**
     * Ikkunaan sisältö.
     */
    private JPanel ikkunanSisalto;
    /**
     * Ikkunan korkeus.
     */
    private int pituus;
    /**
     * Ikkunan leveys.
     */
    private int leveys;

    /**
     * Luo uuden parametrien mukaisen pop-up ikkunan.
     * 
     * @param otsikko ikkunan otsikko
     * @param nappiTeksti ikkunan sulkevan napin teksti
     * @param sisalto osat jotka ikkuna sisältää
     * @param l ikkunan korkeus
     * @param w ikkunan leveys
     */
    public ApuIkkuna(String otsikko, String nappiTeksti, JPanel sisalto, int l, int w) {
        this.ikkunanOtsikko = otsikko;
        this.ikkunanSisalto = sisalto;
        this.sulkunapinTeksti = nappiTeksti;
        this.pituus = l;
        this.leveys = w;
    }
    
    /**
     * Tekee ja käynnistää ikkunan.
     */
    @Override
    public void run() {
        frame = new JFrame(this.ikkunanOtsikko);
        frame.setSize(leveys, pituus);
        
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        teeKomponentit(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Palauttaa ikkunan frame-olion.
     * @return ikkunan sisältämä JFrame
     */
    public JFrame getFrame() {
        return frame;
    }

    /**
     * Asettaa ikkunan sisällön määrittelevän JPanel-olion.
     * @param ikkunanSisalto ikkunan sisällöksi asetettava frame-olio
     */
    public void setIkkunanSisalto(JPanel ikkunanSisalto) {
        this.ikkunanSisalto = ikkunanSisalto;
    }
   
    /**
     * Tekee ikkunan sulkevan napin ja asettaa tälle kuuntelijan. Asettaa ikkunan
     * sisällön ja napin ikkunaan.
     * @param c ikkunan container-olio
     * 
     * @see minikong.kayttoliittyma.kuuntelijat.SulkunappiKuuntelija
     */
    private void teeKomponentit(Container c) {
        JButton finito = new JButton(this.sulkunapinTeksti);
        
        finito.addActionListener(new SulkunappiKuuntelija(this.frame));
        
        c.add(this.ikkunanSisalto, BorderLayout.CENTER);
        c.add(finito, BorderLayout.SOUTH);
    }
}