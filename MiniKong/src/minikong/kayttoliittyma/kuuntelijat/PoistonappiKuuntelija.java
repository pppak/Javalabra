package minikong.kayttoliittyma.kuuntelijat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import minikong.kayttoliittyma.TulosLaatikko;

public class PoistonappiKuuntelija implements ActionListener{

    private TulosLaatikko tulo;
    
    public PoistonappiKuuntelija(TulosLaatikko tulo) {
        this.tulo = tulo;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        tulo.tyhjenna();
    }   
}