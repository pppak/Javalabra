package minikong.kayttoliittyma.kuuntelijat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;
import minikong.domain.TekstinTiedot;
import minikong.kayttoliittyma.ApuIkkuna;
import minikong.kayttoliittyma.komponentit.Tuloslaatikko;
import minikong.util.TekstinKasittelija;

/** Laittaa syötetyn tekstin käsittelyyn ja tulostaa käsittelyn tulokset.
 * 
 * @author Pia Pakarinen
 */
class SyottoKuuntelija implements ActionListener{

    /**
     * Laatikko, johon käsiteltävän tekstin voi syöttää.
     */
    private JTextArea syottoAlue;
    /**
     * Tiedot tallentava TekstinTiedot olio.
     */
    private TekstinTiedot teksti;
    /**
     * Käyttäjälle tulostuksen näyttävä Tuloslaatikko.
     */
    private Tuloslaatikko tulo;
    /**
     * Tekstin syötön mahdollistava ApuIkkuna.
     */
    private ApuIkkuna ikkuna;
    
    /**
     * Asettaa attribuuteiksi parametreina saadut tiedot.
     * @param pasta alue johon käyttäjän on mahdollista syöttää tekstiä
     * @param tt TekstinTiedot, tallentaja
     * @param tulo Tuloslaatikko johon tulee tulostus
     * @param ikkuna Syöttöikkuna
     */
    SyottoKuuntelija(JTextArea pasta, TekstinTiedot tt, Tuloslaatikko tulo, ApuIkkuna ikkuna) {
        this.syottoAlue = pasta;
        this.teksti = tt;
        this.tulo = tulo;
        this.ikkuna = ikkuna;
    }   

    /**
     * Asettaa syötetyn tekstin tiedot tyhjään TekstinTiedot olioon.
     * @param ae käyttäjä painoi nappia
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        this.teksti.uusiTeksti();
        TekstinKasittelija parser = new TekstinKasittelija(this.teksti, syottoAlue.getText());
        this.teksti = parser.kasittele();
        
        paivitaTulokset();
        this.ikkuna.getFrame().dispose();
    }

    /**
     * Muodostaa tekstin syötöstä syntyvän tulostuksen.
     */
    private void paivitaTulokset() {
        if (teksti.getSanamaara() == 0) {
            tulo.addTeksti("Tekstiä ei syötetty.\n");
            return;
        }
        tulo.addTeksti("*Oma teksti syötetty!*\n");
        tulo.addTeksti(this.teksti.sanamaaraTulostus());
        tulo.addTeksti("---\n");
    }  
}