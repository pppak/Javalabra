package minikong.kayttoliittyma.kuuntelijat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import minikong.kayttoliittyma.Viesti;

public class OhjeKuuntelija implements ActionListener{

    Viesti ohjeViesti;

    public OhjeKuuntelija() { 
        String teksti = teeViesti();
        this.ohjeViesti = new Viesti("Ohje", teksti, 300, 300);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        this.ohjeViesti.run();
    }   

    private String teeViesti() {
        StringBuilder viesti = new StringBuilder();
        viesti.append("<html>");
        viesti.append("<br>");
        viesti.append("Aloita valitsemalla tekstitiedosto.");
        viesti.append("<br>");
        viesti.append("Tiedoston tulee olla muotoa txt.");
        viesti.append("<br>");
        viesti.append("Kirjoita tämän jälkeen hakukentään haettava sana.");
        viesti.append("<br>");
        viesti.append("Tulokset esitetään muodossa \"sana\" (esiintymismäärä).");
        viesti.append("<br>");
        viesti.append("Mahdolliset virheilmoitukset tulostetaan myös ikkunan alaosaan.");
        viesti.append("<br>");
        viesti.append("<br>");
        viesti.append("</html>");
        return viesti.toString();
    }
}