package minikong.kayttoliittyma.kuuntelijat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import minikong.kayttoliittyma.ApuIkkuna;

public class OhjeKuuntelija implements ActionListener{

    ApuIkkuna ohjeViesti;

    public OhjeKuuntelija() { 
        JPanel sisalto = new JPanel();
        String teksti = teeViesti();
        sisalto.add(new JLabel(teksti));
        this.ohjeViesti = new ApuIkkuna("Ohje", "OK", sisalto, 300, 300);
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
        viesti.append("Kirjoita tämän jälkeen hakukenttään haettava sana.");
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