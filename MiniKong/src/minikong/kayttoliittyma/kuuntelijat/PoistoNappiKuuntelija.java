package minikong.kayttoliittyma.kuuntelijat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import minikong.kayttoliittyma.TulosLaatikko;

public class PoistoNappiKuuntelija implements ActionListener{

    private TulosLaatikko tulo;
    
    public PoistoNappiKuuntelija(TulosLaatikko tulo) {
        this.tulo = tulo;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        tulo.tyhjenna();
        tulo.getLaatikko().repaint();
    }
   
}