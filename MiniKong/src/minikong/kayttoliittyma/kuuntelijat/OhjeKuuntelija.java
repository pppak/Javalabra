package minikong.kayttoliittyma.kuuntelijat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import minikong.kayttoliittyma.Viesti;

public class OhjeKuuntelija implements ActionListener{

    Viesti ohjeViesti;

    public OhjeKuuntelija() {
        String teksti = "<html>Syötä ohjelmalle jokin \'txt\' muotoinen tiedosto.<br> Tämän jälkeen voit hakea sanan naapureita tekstistä. <br>Tulokset ja tietoa mahdollisista virheellisistä<br> syötteistä ilmestyvät ikkunan alaosaan.</html>";
        this.ohjeViesti = new Viesti("Ohje", teksti, 300, 300);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        this.ohjeViesti.run();
    }
    
    
    
}
