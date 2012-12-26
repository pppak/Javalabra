package minikong.kayttoliittyma;

import java.awt.Container;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SanaHaunOsa{

    private Container sanahaku;

    public SanaHaunOsa() {
        this.sanahaku = new Container();
        this.sanahaku.setLayout(new BoxLayout(this.sanahaku, BoxLayout.X_AXIS));
        teeKomponentit();
    }

    private void teeKomponentit() {
        JLabel hakuTeksti = new JLabel("Haettava sana: ");
        JTextField hakukentta = new JTextField();
        JButton hakuNappi = new JButton("Hae");
        //kuuntelijat  
        this.sanahaku.add(hakuTeksti);
        this.sanahaku.add(hakukentta);
        this.sanahaku.add(hakuNappi);
    }

    public Container getSanahaku() {
        return sanahaku;
    }
    
}
