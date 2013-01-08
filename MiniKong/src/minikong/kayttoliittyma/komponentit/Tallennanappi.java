package minikong.kayttoliittyma.komponentit;

import javax.swing.JButton;
import javax.swing.JFrame;
import minikong.kayttoliittyma.kuuntelijat.TallennaKuuntelija;

/** Luo napin tulosten tallentamista varten.
 * 
 * @author Pia Pakarinen
 */
public class Tallennanappi extends Komponentti{
    
    /**
     * Kuuntelijalle välitettävä TulosLaatikko
     */
    Tuloslaatikko l;
    /**
     * Kuuntelijalle välitettävä pääikkunan frame olio
     */
    JFrame frame;

    /** Asettaa l ja frame attribuutit annettujen parametrien mukaisiksi, kutsuu yläluokan konstruktoria.
     * 
     * @param l Tuloslaatikko
     * @param frame Pääikkunan frame
     * 
     * @see minikong.kayttoliittyma.Komponentti#Komponentti()
     */
    public Tallennanappi(Tuloslaatikko l, JFrame frame) {
        super();
        this.l = l;
        this.frame = frame;
    }

    /**
     * Asettaa tallennanapin sijainnin pääikkkunassa kuudennelle riville.
     */
    @Override
    public void asetaRuutuun() {
        super.getGbc().gridy = 6;
    }

    /**
     * Luo tulosten tallentamista varten JButton olion, kutsuu sille kuuntelijan luovaa
     * metodia, ja asettaa napin yliluokan JPaneliin.
     * 
     * @see minikong.kayttoliittyma.Tallennanappi#lisaaKuuntelija(javax.swing.JButton) 
     */
    @Override
    public void teeKomponentit() {
        JButton tallenna = new JButton("Tallenna tulokset...");
        lisaaKuuntelija(tallenna);
        super.getOsa().add(tallenna);
    }
    
    /**
     * Lisää parametrina olevalle napille uuden TallennaKuuntelija olion kuuntelijaksi.
     * @param t nappi, jolle kuuntelija lisätään
     * 
     * @see minikong.kayttoliittyma.kuuntelijat.TallennaKuuntelija
     */
    private void lisaaKuuntelija(JButton t){
        TallennaKuuntelija tk = new TallennaKuuntelija(this.l, frame);
        t.addActionListener(tk);
    }   
}