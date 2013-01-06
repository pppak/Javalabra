package minikong.kayttoliittyma.kuuntelijat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import minikong.kayttoliittyma.Tuloslaatikko;

/** Hoitaa tulosten tallentamisen txt-tiedostona.
 * 
 * @author Pia Pakarinen
 */
public class TallennaKuuntelija implements ActionListener {

    private Tuloslaatikko tulokset;
    private JFrame frame;

    public TallennaKuuntelija(Tuloslaatikko t, JFrame frame) {
        this.tulokset = t;
        this.frame = frame;

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        JFileChooser fc = new JFileChooser();

        int valinta = fc.showSaveDialog(this.frame);

        if (valinta == JFileChooser.CANCEL_OPTION) {
            return;
        }

        try {
            File f = fc.getSelectedFile();
            FileWriter fw = new FileWriter(f);
            BufferedWriter out = new BufferedWriter(fw);
            out.write(tulokset.getTulokset().getText());
            out.close();
        } catch (IOException ex) {
        }
    }
}