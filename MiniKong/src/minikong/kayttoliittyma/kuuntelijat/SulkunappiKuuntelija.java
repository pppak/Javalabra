package minikong.kayttoliittyma.kuuntelijat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/** Sulkee valitun ikkunan.
 * 
 * @author Pia Pakarinen
 */
public class SulkunappiKuuntelija implements ActionListener {

    /**
     * Suljettavan ikkunan frame.
     */
    private JFrame f;
    
    /**
     * Asettaa attribuutin parametrin mukaiseksi.
     * @param frame asetettava JFrame
     */
    public SulkunappiKuuntelija(JFrame frame) {
        this.f = frame;
    }

    /**
     * Poistaa ikkunan.
     * @param ae käyttäjä painoi nappia
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        f.dispose();
    }    
}