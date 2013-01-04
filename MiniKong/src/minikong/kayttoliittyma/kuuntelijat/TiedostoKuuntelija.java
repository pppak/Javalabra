package minikong.kayttoliittyma.kuuntelijat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;
import minikong.domain.TekstinTiedot;
import minikong.kayttoliittyma.Tuloslaatikko;
import minikong.util.TekstinKasittelija;

public class TiedostoKuuntelija implements ActionListener {

    private TekstinTiedot teksti;
    private JFrame frame;
    private Tuloslaatikko tulo;

    public TiedostoKuuntelija(TekstinTiedot teksti, JFrame frame, Tuloslaatikko tulo) {
        this.teksti = teksti;
        this.frame = frame;
        this.tulo = tulo;
    }

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
            tulo.addTeksti("Tiedostoa ei löydy.");
            return;
        }
        
        this.teksti.uusiTeksti();
        TekstinKasittelija parser = new TekstinKasittelija(this.teksti, file);
        this.teksti = parser.kasittele();
        
        paivitaTulokset(tiedVal, file);        
    }

    private void paivitaTulokset(JFileChooser tiedVal, File file) {
        tulo.addTeksti("*Uusi tiedosto valittu!* \n");
        tulo.addTeksti("Valittu tiedosto: " + tiedVal.getName(file) + "\n");
        tulo.addTeksti("Tekstin sanamäärä: " + this.teksti.getSanamaara() 
                + ". Uniikkeja sanoja esiintyy tekstissä " + this.teksti.uniikitSanat() + ".\n");
        tulo.addTeksti("---\n");
    }
}