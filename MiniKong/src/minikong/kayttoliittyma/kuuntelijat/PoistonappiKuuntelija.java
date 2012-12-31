package minikong.kayttoliittyma.kuuntelijat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import minikong.kayttoliittyma.Tuloslaatikko;

public class PoistonappiKuuntelija implements ActionListener{

    private Tuloslaatikko tulo;
    
    public PoistonappiKuuntelija(Tuloslaatikko tulo) {
        this.tulo = tulo;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        tulo.tyhjenna();
    }   
}