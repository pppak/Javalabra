package minikong.kayttoliittyma;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Viesti implements Runnable{
    
    private JFrame frame;
    private JLabel tekstiKentta;
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
        frame = new JFrame();
        tekstiKentta = setTeksti(this.tekstiBody);
        
    }

    public JLabel setTeksti(String t) {
        return new JLabel(this.tekstiBody);
    }
    
}