package minikong.kayttoliittyma.komponentit;

import javax.swing.JButton;
import minikong.kayttoliittyma.kuuntelijat.PoistonappiKuuntelija;

/** Luo napin tuloslaatikon tyhjentämistä varten.
 * 
 * @author Pia Pakarinen
 */

public class TulostenPoisto extends Komponentti{

    /**
     * Kuuntelijalle välitettävä Tuloslaatikko.
     * @see minikong.kayttoliittyma.Tuloslaatikko
     */
    private Tuloslaatikko tulo;
    
    /**
     * Kutsuu yläluokan konstruktoria, asettaa tulo attribuutin saadun parametrin mukaiseksi.
     * @param tulo Tuloslaatikko
     */
    public TulostenPoisto(Tuloslaatikko tulo) {
        super();
        this.tulo = tulo;
    }

    /**
     * Lisää parametrina saadulle napille PoistoNappiKuuntelijan.
     * @param poisto nappi joka tyhjentää tuloslaatikon
     * @see minikong.kayttoliittyma.kuuntelijat.PoistonappiKuuntelija
     */
    private void lisaaKuuntelija(JButton poisto) {
        PoistonappiKuuntelija pnk = new PoistonappiKuuntelija(tulo);
        poisto.addActionListener(pnk);
    }

    /**
     * Asettaa poistonapin pääikkunan seitsemännelle riville.
     */
    @Override
    public void asetaRuutuun() {
        super.getGbc().gridy = 7;
    }

    /**
     * Luo uuden JButton olion, kutsuu sille kuuntelijan lisäävää metodia, ja
     * asettaa sen yläluokan JPanel olioon.
     * 
     * @see minikong.kayttoliittyma.TulostenPoisto#lisaaKuuntelija(javax.swing.JButton) 
     */
    @Override
    public void teeKomponentit() {
        JButton poisto = new JButton("Poista tulokset");
        lisaaKuuntelija(poisto);
        super.getOsa().add(poisto);
    }
}