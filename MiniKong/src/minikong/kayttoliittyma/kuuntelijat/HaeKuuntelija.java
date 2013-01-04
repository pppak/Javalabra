package minikong.kayttoliittyma.kuuntelijat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import minikong.domain.TekstinTiedot;
import minikong.kayttoliittyma.Tuloslaatikko;
import minikong.komennot.HaeNaapuri;
import minikong.util.Siistija;

public class HaeKuuntelija implements ActionListener {

    private JTextField kentta;
    private TekstinTiedot teksti;
    private Tuloslaatikko tulos;
    private String haettu;

    public HaeKuuntelija(TekstinTiedot teksti, Tuloslaatikko tulos) {
        this.kentta = null;
        this.teksti = teksti;
        this.tulos = tulos;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (teksti.getSanamaara() == 0) {
            tulos.addTeksti("Valitse ensin teksti josta sanaa etsitään! \n");
            return;
        }

        Siistija siisti = new Siistija();
        haettu = siisti.trim(kentta.getText());
        if (haettu.isEmpty()) {
            return;
        }
        if (!teksti.sanaListattu(haettu)) {
            tulos.addTeksti("Sanaa \'" + haettu + "\' ei löydy valitusta tekstistä. \n");
            return;
        }

        tulostenTulostus();
    }

    private void tulostenTulostus() {
        HaeNaapuri haku = new HaeNaapuri(teksti);
        tulos.addTeksti("Haettu sana: " + haettu + "\n");
        tulos.addTeksti("Sana esiintyy tekstissä " + teksti.getSananNaapurit(haettu).getEsiintymisMaara() + " kertaa" + "\n");
        tulos.addTeksti("Yleisin naapurisana vasemmalla: " + haku.getVasen(haettu) + "\n");
        tulos.addTeksti("Yleisin naapurisana oikealla: " + haku.getOikea(haettu) + "\n");
        tulos.addTeksti("***\n");
    }

    public void setHakukentta(JTextField hakukentta) {
        this.kentta = hakukentta;
    }
}