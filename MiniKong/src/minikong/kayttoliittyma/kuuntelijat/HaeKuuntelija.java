package minikong.kayttoliittyma.kuuntelijat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import minikong.domain.TekstinTiedot;
import minikong.kayttoliittyma.Tuloslaatikko;
import minikong.komennot.HaeNaapuri;

public class HaeKuuntelija implements ActionListener{

    private JTextField sana;
    private TekstinTiedot teksti;
    private Tuloslaatikko tulos;
    
    public HaeKuuntelija(TekstinTiedot teksti, Tuloslaatikko tulos) {
        this.sana = null;
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
        
        tulostenTulostus();        
    }

    private void tulostenTulostus() {
        HaeNaapuri haku = new HaeNaapuri(teksti);
        tulos.addTeksti("Haettu sana: " + sana.getText() + "\n");
        tulos.addTeksti("Sana esiintyy tekstissä " + teksti.getSananNaapurit(sana.getText()).getEsiintymisMaara() + " kertaa" + "\n");
        tulos.addTeksti("Yleisin naapurisana vasemmalla: " + haku.getVasen(sana.getText()) + "\n");
        tulos.addTeksti("Yleisin naapurisana oikealla: " + haku.getOikea(sana.getText()) + "\n"); 
        tulos.addTeksti("***\n");
    }
    
    public void setHakukentta(JTextField hakukentta){
        this.sana = hakukentta;
    }
}