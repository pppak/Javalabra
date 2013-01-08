package minikong.kayttoliittyma.komponentit;

import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import minikong.domain.TekstinTiedot;
import minikong.kayttoliittyma.kuuntelijat.SyottonappiKuuntelija;
import minikong.kayttoliittyma.kuuntelijat.TiedostoKuuntelija;

/** Luo napit käsiteltävän tekstin valitsemiseen joko tiedostona tai suoraan
 * syötettävänä.
 * 
 * @author Pia Pakarinen
 */

public class TekstinValinta extends Komponentti{

    /**
     * Kuuntelijalle välitettävä TekstinTiedot olio.
     */
    private TekstinTiedot tt;
    /**
     * Pääikkunan JFrame.
     */
    private JFrame frame;
    /**
     * Kuuntelijalle välitettävä Tuloslaatikko.
     */
    private Tuloslaatikko tulo;

    /** Kutsuu yläluokan konstruktoria, asettaa attribuutit parametrien mukaisiksi.
     * 
     * @param tulo Tuloslaatikko
     * @param frame Pääikkunan JFrame
     * @param tt  TekstinTiedot
     * 
     * @see minikong.kayttoliittyma.Komponentti#Komponentti() 
     */
    public TekstinValinta(Tuloslaatikko tulo, JFrame frame, TekstinTiedot tt) {
        super();
        this.tt = tt;
        this.frame = frame;
        this.tulo = tulo;
    }

    /**
     * Asettaa tekstinvalinnan pääikkunan toiselle riville (gridy = 1).
     */
    @Override
    public void asetaRuutuun() {
        super.getGbc().gridy = 1;
        super.getGbc().insets = new Insets(0, 30, 0, 0);
    }

    /**
     * Luo napit tekstiedoston valintaa ja tekstin syöttöä varten, kutsuu niille
     * kuuntelijat lisäävää metodia, ja asettaa ne yläluokan JPaneliin.
     */
    @Override
    public void teeKomponentit() {
        JButton tiedosto = new JButton("Valitse tekstitiedosto...");
        JButton syota = new JButton("Syötä tekstiä");
        lisaaKuuntelija(tiedosto, syota);
        super.getOsa().add(tiedosto);
        super.getOsa().add(syota);
    }

    /** Lisää parametreina saaduille napeille TiedostoKuuntelijan ja SyottoNappiKuuntelijan.
     * 
     * @param tiedosto nappi jolle lisätään TiedostoKuuntelija
     * @param syota nappi jolle lisätään SyottoNappiKuuntelija
     * 
     * @see minikong.kayttoliittyma.kuuntelijat.TiedostoKuuntelija
     * @see minikong.kayttoliittyma.kuuntelijat.SyottonappiKuuntelija
     */
    private void lisaaKuuntelija(JButton tiedosto, JButton syota) {
        TiedostoKuuntelija tied = new TiedostoKuuntelija(tt, frame, tulo);
        tiedosto.addActionListener(tied);
        
        SyottonappiKuuntelija sk = new SyottonappiKuuntelija(tt, tulo);
        syota.addActionListener(sk);
    }
}