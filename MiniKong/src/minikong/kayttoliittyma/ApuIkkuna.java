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
    
    private JFrame frame;
    private String ikkunanOtsikko;
    private String sulkunapinTeksti;
    private JPanel ikkunanSisalto;
    private int pituus;
    private int leveys;

    public ApuIkkuna(String otsikko, String nappiTeksti, JPanel sisalto, int l, int w) {
        this.ikkunanOtsikko = otsikko;
        this.ikkunanSisalto = sisalto;
        this.sulkunapinTeksti = nappiTeksti;
        this.pituus = l;
        this.leveys = w;
    }
    
    @Override
    public void run() {
        frame = new JFrame(this.ikkunanOtsikko);
        frame.setSize(leveys, pituus);
        
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        teeKomponentit(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setIkkunanSisalto(JPanel ikkunanSisalto) {
        this.ikkunanSisalto = ikkunanSisalto;
    }
   
    private void teeKomponentit(Container c) {
        JButton finito = new JButton(this.sulkunapinTeksti);
        
        finito.addActionListener(new SulkunappiKuuntelija(this.frame));
        
        c.add(this.ikkunanSisalto, BorderLayout.CENTER);
        c.add(finito, BorderLayout.SOUTH);
    }
}