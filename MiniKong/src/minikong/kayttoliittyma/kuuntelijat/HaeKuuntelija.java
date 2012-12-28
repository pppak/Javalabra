package minikong.kayttoliittyma.kuuntelijat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import minikong.domain.TekstinTiedot;
import minikong.kayttoliittyma.TulosLaatikko;
import minikong.komennot.HaeSana;

public class HaeKuuntelija implements ActionListener{

    private JTextField sana;
    private TekstinTiedot teksti;
    private TulosLaatikko tulos;
    
    public HaeKuuntelija(JTextField hakukentta, TekstinTiedot teksti, TulosLaatikko tulos) {
        this.sana = hakukentta;
        this.teksti = teksti;
        this.tulos = tulos;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (teksti.getSanamaara() == 0) {
            tulos.addTeksti("Valitse ensin teksti josta sanaa etsitään! \n");
            return;
        }
        if (!teksti.sanaListattu(sana.getText())) {
            tulos.addTeksti("Sanaa \'" + sana.getText() + "\' ei löydy valitusta tekstistä. \n");
            return;
        }
        
        HaeSana haku = new HaeSana(teksti);
        tulos.addTeksti("Haettu sana: " + sana.getText() + "\n");
        tulos.addTeksti("Sana esiintyy tekstissä " + teksti.getSana(sana.getText()).getEsiintymisMaara() + " kertaa" + "\n");
        tulos.addTeksti("Yleisin naapurisana vasemmalla: " + haku.getVasen(sana.getText()) + "\n");
        tulos.addTeksti("Yleisin naapurisana oikealla: " + haku.getOikea(sana.getText()) + "\n"); 
        tulos.addTeksti("***\n");
    }
}