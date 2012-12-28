package minikong.kayttoliittyma.kuuntelijat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;
import minikong.domain.TekstinTiedot;
import minikong.kayttoliittyma.TulosLaatikko;
import minikong.komennot.HankiTiedosto;
import minikong.util.Lukija;

public class TiedostoKuuntelija implements ActionListener {

    private Lukija lukija;
    private TekstinTiedot teksti;
    private JFrame frame;
    private TulosLaatikko tulo;

    public TiedostoKuuntelija(Lukija lukija, TekstinTiedot teksti, JFrame frame, TulosLaatikko tulo) {
        this.lukija = lukija;
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
        HankiTiedosto ks = new HankiTiedosto(teksti, lukija, file);
        ks.suorita();
        
        tulo.addTeksti("*Uusi tiedosto valittu!* \n");
        tulo.addTeksti("Valittu tiedosto: " + tiedVal.getName(file) + "\n");
        tulo.addTeksti("Tekstin sanamäärä: " + this.teksti.getSanamaara() + "\n");
        tulo.addTeksti("---\n");
    }
}