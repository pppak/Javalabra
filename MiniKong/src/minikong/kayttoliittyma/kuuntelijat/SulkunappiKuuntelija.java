package minikong.kayttoliittyma.kuuntelijat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class SulkunappiKuuntelija implements ActionListener {

    private JFrame f;
    
    public SulkunappiKuuntelija(JFrame frame) {
        this.f = frame;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        f.dispose();
    }    
}