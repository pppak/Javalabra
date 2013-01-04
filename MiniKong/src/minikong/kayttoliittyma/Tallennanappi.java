package minikong.kayttoliittyma;

import javax.swing.JButton;
import javax.swing.JFrame;
import minikong.kayttoliittyma.kuuntelijat.TallennaKuuntelija;

public class Tallennanappi extends Komponentti{
    
    Tuloslaatikko l;
    JFrame frame;

    public Tallennanappi(Tuloslaatikko l, JFrame frame) {
        super();
        this.l = l;
        this.frame = frame;
    }

    @Override
    public void asetaRuutuun() {
        super.getGbc().gridy = 5;
    }

    @Override
    public void teeKomponentit() {
        JButton tallenna = new JButton("Tallenna tulokset...");
        lisaaKuuntelija(tallenna);
        super.getOsa().add(tallenna);
    }
    
    private void lisaaKuuntelija(JButton t){
        TallennaKuuntelija tk = new TallennaKuuntelija(this.l, frame);
        t.addActionListener(tk);
    }   
}