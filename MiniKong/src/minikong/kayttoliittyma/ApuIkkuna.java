package minikong.kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import minikong.kayttoliittyma.kuuntelijat.SulkunappiKuuntelija;

public class ApuIkkuna implements Runnable{
    
    private JFrame frame;
    private String ikkunanOtsikko;
    private String sulkunapinTeksti;
    private JPanel ikkunanSisalto;
    private int pituus;
    private int leveys;

    public ApuIkkuna(String o, String nappiTeksti, JPanel sis, int l, int w) {
        this.ikkunanOtsikko = o;
        this.ikkunanSisalto = sis;
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
   
    private void teeKomponentit(Container c) {
        JButton finito = new JButton(this.sulkunapinTeksti);
        
        finito.addActionListener(new SulkunappiKuuntelija(this.frame));
        
        c.add(this.ikkunanSisalto, BorderLayout.CENTER);
        c.add(finito, BorderLayout.SOUTH);
    }
}