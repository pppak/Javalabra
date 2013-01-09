package minikong.kayttoliittyma.kuuntelijat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import minikong.domain.TekstinTiedot;
import minikong.kayttoliittyma.komponentit.NaapurienMaaranValinta;
import minikong.kayttoliittyma.komponentit.Tuloslaatikko;
import minikong.util.NaapuriHaku;

/**
 * Suorittaa sanan naapureiden haun tulosten tulostuksen.
 *
 * @author Pia Pakarinen
 */
public class HaeKuuntelija implements ActionListener {

    /**
     * Haettavan sanan sisältävä JTextField tekstikenttä.
     */
    private JTextField kentta;
    /**
     * Tulokset sisältävä TekstinTiedot olio.
     */
    private TekstinTiedot teksti;
    /**
     * Tuloslaatikko johon tulokset tulostetaan.
     */
    private Tuloslaatikko tulos;
    /**
     * Tulostettavien naapurien maaran sisältävä NaapurienMaaranValinta olio.
     */
    private NaapurienMaaranValinta naapurienMr;

    /**
     * Asettaa attribuutit parametrien mukaisiksi.
     *
     * @param teksti TekstinTiedot
     * @param tulos Tuloslaatikko
     * @param nm NaapurienMaaranValinta
     * @param haku JTextField hakukenttä
     */
    public HaeKuuntelija(TekstinTiedot teksti, Tuloslaatikko tulos, NaapurienMaaranValinta nm, JTextField haku) {
        this.teksti = teksti;
        this.tulos = tulos;
        this.naapurienMr = nm;
        this.kentta = haku;
    }

    /**
     * Luo NaapuriHaku komennon ja asettaa tämän palauttaman tulostuksen Pääikkunan
     * Tuloslaatikkoon.
     * @param ae käyttäjän suorittama toiminto
     * 
     * @see minikong.komennot.NaapuriHaku
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        NaapuriHaku hn = new NaapuriHaku(this.teksti, this.naapurienMr.getMaara(),
            this.kentta.getText());
        
        this.tulos.addTeksti(hn.tee());
    }
}