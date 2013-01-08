package minikong.kayttoliittyma.komponentit;

import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import minikong.domain.TekstinTiedot;
import minikong.kayttoliittyma.kuuntelijat.HaeKuuntelija;
import minikong.kayttoliittyma.kuuntelijat.ListausKuuntelija;

/** Luo käyttöliittymän kolmannella rivillä sijaitsevat osat sanojen hakuun ja 
 * valitun tekstin uniikkien sanojen tulostamiseen.
 * 
 * @author Pia Pakarinen
 */

public class SanahakuJaSanojenTulostus extends Komponentti{

    /**
     * Tuloslaatikko joka välitetään edelleen osien kuuntelijoille
     */
    private Tuloslaatikko tulo;
    /**
     * Käsiteltävän tekstin tiedot, jotka välitetään eteenpäin kuuntelijoille
     */
    private TekstinTiedot tt;
    /**
     * NaapurienMaaraanValinta olio; välitetään kuuntelijoille
     */
    private NaapurienMaaranValinta nm;
    
    /** Asetetaan yläluokan konstruktorin mukaisesti perityt oliot; asetetaan omat 
     * attribuutit parametrien mukaan.
     * 
     * @param tulo Tuloslaatikko olio
     * @param tt TekstinTiedot olio
     * @param nm NaapurienMaaranValinta olio
     * 
     * @see minikong.kayttoliittyma.Komponentti#Komponentti() 
     */
    public SanahakuJaSanojenTulostus(Tuloslaatikko tulo, TekstinTiedot tt, NaapurienMaaranValinta nm) {
        super();
        this.nm = nm;
        this.tt = tt;
        this.tulo = tulo;
    }
    
    /**
     * Tekee sanahakuun ja sanojen näyttämiseen liittyvät komponentit ja asettaa näille kuuntelijat.
     *
     * @see minikong.kayttoliittyma.SanahakuJaSanojenTulostus#lisaaHakuKuuntelijat(javax.swing.JButton, javax.swing.JTextField, minikong.kayttoliittyma.kuuntelijat.HaeKuuntelija) 
     */
    @Override
    public void teeKomponentit(){
        super.getOsa().setLayout(new GridBagLayout());
        JLabel hakuTeksti = new JLabel("Haettava sana: ");
        JTextField hakukentta = new JTextField(20);
        JButton hakunappi = new JButton("Hae");
        
        lisaaHakuKuuntelijat(hakunappi, hakukentta);
        
        JButton sanat = new JButton("Näytä sanat");
        sanat.addActionListener(new ListausKuuntelija(tt)); 
        
        super.getOsa().add(hakuTeksti);
        super.getOsa().add(hakukentta);
        super.getOsa().add(hakunappi);
        super.getOsa().add(sanat);
    }

    /**
     * Luo uuden HaeKuuntelija olion ja lisää sen hakukentälle ja hakunapille.
     * @param n hae-nappi hakukentän vieressä
     * @param k hakukenttä
     * 
     * @see minikong.kayttoliittyma.kuuntelijat.HaeKuuntelija
     */
    private void lisaaHakuKuuntelijat(JButton n, JTextField k) {
        HaeKuuntelija hk = new HaeKuuntelija(tt, tulo, nm, k);
        n.addActionListener(hk);
        k.addActionListener(hk);
    }
    
    /**
     * Asettaa sanahaun ja sanojen tulostukseen johtavat komponentit pääikkunan
     * kolmannelle riville.
     */
    @Override
    public void asetaRuutuun() {
        super.getGbc().gridy = 3;
        super.getGbc().insets = new Insets(5, 0, 5, 13);
    }
}