package minikong.kayttoliittyma.kuuntelijat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import minikong.kayttoliittyma.ApuIkkuna;

/** Luo ohje-ikkunan ja sen sisältämän tekstin.
 * 
 * @author Pia Pakarinen
 */
public class OhjeKuuntelija implements ActionListener{

    /**
     * ApuIkkuna jossa ohje esitetään.
     */
    ApuIkkuna ohjeViesti;

    /**
     * Luo uuden ApuIkkunan ja asettaa siihen halutun sisällön.
     * 
     * @see minikong.kayttoliittyma.ApuIkkuna
     * @see minikong.kayttoliittyma.kuuntelijat.OhjeKuuntelija#teeViesti() 
     */
    public OhjeKuuntelija() { 
        JPanel sisalto = new JPanel();
        String teksti = teeViesti();
        sisalto.add(new JLabel(teksti));
        this.ohjeViesti = new ApuIkkuna("Ohje", "OK", sisalto, 300, 300);
    }

    /**
     * Ohjeen sisältävä ApuIkkuna näkyy käyttäjälle.
     * @param ae käyttäjä painoi nappia
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        this.ohjeViesti.run();
    }   

    /**
     * Rakentaa käyttäjälle näytettävän ohjeviestin.
     * @return ohjeviesti
     */
    private String teeViesti() {
        StringBuilder viesti = new StringBuilder();
        viesti.append("<html>");
        viesti.append("<br>");
        viesti.append("Aloita valitsemalla tekstitiedosto, tai syöttämällä teksti itse.");
        viesti.append("<br>");
        viesti.append("Tiedoston tulee olla muotoa txt.");
        viesti.append("<br>");
        viesti.append("Kirjoita tämän jälkeen hakukenttään haettava sana.");
        viesti.append("<br>");
        viesti.append("Valitse seuraavaksi näytettävien naapurien määrä.");
        viesti.append("<br>");
        viesti.append("Tulokset esitetään muodossa: sana (esiintymismäärä).");
        viesti.append("<br>");
        viesti.append("Naapurit tulostuvat esiintymismäärien mukaisessa järjestyksessä.");
        viesti.append("<br>");
        viesti.append("Hauissa ei huomioda lainausmerkkejä tai välimerkkejä sanan lopussa tai alussa");
        viesti.append("<br>");
        viesti.append("silloin kun ne esiintyvät kieliopillisesti tai toistuvasti peräkkäin.");
        viesti.append("<br>");
        viesti.append("Mahdolliset virheilmoitukset tulostetaan myös ikkunan alaosaan.");
        viesti.append("<br>");
        viesti.append("<br>");
        viesti.append("</html>");
        return viesti.toString();
    }
}