package minikong.kayttoliittyma.kuuntelijat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;
import minikong.domain.TekstinTiedot;
import minikong.kayttoliittyma.komponentit.Tuloslaatikko;
import minikong.util.TekstinKasittelija;

/** Hankkii ja laittaa valitun tekstitiedoston käsittelyyn.
 * 
 * @author Pia Pakarinen
 */
public class TiedostoKuuntelija implements ActionListener {

    /**
     * Käsiteltävä TekstinTiedot.
     */
    private TekstinTiedot teksti;
    /**
     * Pääikkunan JFrame.
     */
    private JFrame frame;
    /**
     * Tulokset näyttävä Tuloslaatikko.
     */
    private Tuloslaatikko tulo;

    /**
     * Luo uuden parametrien mukaisen TiedostoKuuntelija olion.
     * @param teksti TekstinTiedot
     * @param frame Pääikkunan JFrame
     * @param tulo Tuloslaatikko
     */
    public TiedostoKuuntelija(TekstinTiedot teksti, JFrame frame, Tuloslaatikko tulo) {
        this.teksti = teksti;
        this.frame = frame;
        this.tulo = tulo;
    }

    /**
     * Valitsee tiedoston, tarkistaa sen olemassaolon ja asettaa sen käsittelyyn.
     * @param ae käyttäjä painoi nappia
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        JFileChooser tiedVal = new JFileChooser();
        tiedVal.setFileFilter(new FileNameExtensionFilter("Tekstitiedostot", "txt"));

        int valinta = tiedVal.showOpenDialog(frame);

        if (valinta == JFileChooser.CANCEL_OPTION) {
            return;
        }
        
        File file = tiedVal.getSelectedFile();
        
        if (!file.exists()) {
            tulo.addTeksti("Tiedostoa ei löydy.\n");
            return;
        }
        
        this.teksti.uusiTeksti();
        TekstinKasittelija parser = new TekstinKasittelija(this.teksti, file);
        this.teksti = parser.kasittele();
        
        paivitaTulokset(file.getName());        
    }

    /**
     * Asettaa tiedot valitusta tiedostosta käyttäjän nähtäväksi.
     * @param nimi valitun tiedoston nimi
     */
    private void paivitaTulokset(String nimi) {
        tulo.addTeksti("*Uusi tiedosto valittu!* \n");
        tulo.addTeksti("Valittu tiedosto: " + nimi + "\n");
        tulo.addTeksti(this.teksti.sanamaaraTulostus());
        tulo.addTeksti("---\n");
    }
}