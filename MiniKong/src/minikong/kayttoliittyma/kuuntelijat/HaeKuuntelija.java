package minikong.kayttoliittyma.kuuntelijat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import minikong.domain.SananNaapurit;
import minikong.domain.TekstinTiedot;
import minikong.kayttoliittyma.NaapurienMaaranValinta;
import minikong.kayttoliittyma.Tuloslaatikko;
import minikong.util.Siistija;

/** Suorittaa sanan naapureiden haun tulosten tulostuksen.
 * 
 * @author Pia Pakarinen
 */

public class HaeKuuntelija implements ActionListener {

    private JTextField kentta;
    private TekstinTiedot teksti;
    private Tuloslaatikko tulos;
    private NaapurienMaaranValinta naapurienMr;

    public HaeKuuntelija(TekstinTiedot teksti, Tuloslaatikko tulos, NaapurienMaaranValinta nm, JTextField haku) {
        this.teksti = teksti;
        this.tulos = tulos;
        this.naapurienMr = nm;
        this.kentta = haku;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (teksti.getSanamaara() == 0) {
            tulos.addTeksti("Valitse ensin teksti josta sanaa etsitään! \n");
            return;
        }

        Siistija siisti = new Siistija();
        String haettu = siisti.trim(kentta.getText());
        
        if (haettu.isEmpty()) {
            return;
        }

        if (!teksti.sanaListattu(haettu)) {
            tulos.addTeksti("Sanaa \'" + haettu + "\' ei löydy valitusta tekstistä. \n");
            return;
        }

        tulostenTulostus(haettu);
    }

    private void tulostenTulostus(String haettu) {
        SananNaapurit sana = teksti.getSananNaapurit(haettu);
        tulos.addTeksti("Haettu sana: " + haettu + "\n");
        tulos.addTeksti("Sana esiintyy tekstissä " + sana.getEsiintymisMaara() + " kertaa" + "\n");
        tulos.addTeksti("Yleisimmät naapurisanat vasemmalla: " + sana.tulostaNaapurit(naapurienMr.getMaara(), true) + "\n");
        tulos.addTeksti("Yleisimmät naapurisanat oikealla: " + sana.tulostaNaapurit(naapurienMr.getMaara(), false) + "\n");
        tulos.addTeksti("***\n");
    }
}