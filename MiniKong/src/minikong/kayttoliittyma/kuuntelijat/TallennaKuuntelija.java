package minikong.kayttoliittyma.kuuntelijat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import minikong.kayttoliittyma.komponentit.Tuloslaatikko;

/** Hoitaa tulosten tallentamisen txt-tiedostona.
 * 
 * @author Pia Pakarinen
 */
public class TallennaKuuntelija implements ActionListener {

    /**
     * Tallennettavan tekstin sisältävä Tuloslaatikko.
     */
    private Tuloslaatikko tulokset;
    /**
     * Pääikkunan JFrame.
     */
    private JFrame frame;

    /**
     * Luo uuden TallennaKuuntelija olion parametrien mukaisesti.
     * @param t Tuloslaatikko
     * @param frame Pääikkunan JFrame
     */
    public TallennaKuuntelija(Tuloslaatikko t, JFrame frame) {
        this.tulokset = t;
        this.frame = frame;
    }

    /**
     * Käynnistää tallentavan komponentin, suorittaa tallennuksen, ja tulostaa kuittauksen.
     * @param ae käyttäjä painoi nappia
     */
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
            this.tulokset.addTeksti("*Tulokset tallennettu.*\n");
        } catch (IOException ex) {
        }
    }
}