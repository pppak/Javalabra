package minikong.kayttoliittyma;

import java.awt.Container;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import minikong.kayttoliittyma.kuuntelijat.SulkunappiKuuntelija;

public class Viesti implements Runnable{
    
    private JFrame frame;
    private String ikkunanOtsikko;
    private String tekstiBody;
    private int pituus;
    private int leveys;

    public Viesti(String o, String t, int l, int w) {
        this.ikkunanOtsikko = o;
        this.tekstiBody = t;
        this.pituus = l;
        this.leveys = w;
    }
    
    @Override
    public void run() {
        frame = new JFrame(this.ikkunanOtsikko);
        frame.setSize(leveys, pituus);
        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        teeKomponentit(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }

    private void teeKomponentit(Container c) {
        c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));
        JLabel info = new JLabel(this.tekstiBody);
        JButton finito = new JButton("OK");
        
        finito.addActionListener(new SulkunappiKuuntelija(this.frame));
        
        c.add(info);
        c.add(finito);
    }
    
}