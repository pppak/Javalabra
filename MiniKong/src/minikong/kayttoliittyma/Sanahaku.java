package minikong.kayttoliittyma;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import minikong.domain.TekstinTiedot;
import minikong.kayttoliittyma.kuuntelijat.HaeKuuntelija;

public class Sanahaku extends Komponentti{

    private Tuloslaatikko tulo;
    private TekstinTiedot tt;
    
    Sanahaku(Tuloslaatikko tulo, TekstinTiedot tt) {
        super();
        this.tt = tt;
        this.tulo = tulo;
    }
    
    @Override
    public void teeKomponentit(){
        super.getOsa().setLayout(new GridBagLayout());
        JLabel hakuTeksti = new JLabel("Haettava sana: ");
        JTextField hakukentta = new JTextField(20);
        JButton hakunappi = new JButton("Hae");
        lisaaKuuntelija(hakunappi, hakukentta, new HaeKuuntelija(tt, tulo));
        super.getOsa().add(hakuTeksti);
        super.getOsa().add(hakukentta);
        super.getOsa().add(hakunappi);
    }

    private void lisaaKuuntelija(JButton n, JTextField k, HaeKuuntelija hk) {
        hk.setHakukentta(k);
        n.addActionListener(hk);
        k.addActionListener(hk);
    }
    
    @Override
    void asetaRuutuun() {
        super.getGbc().anchor = GridBagConstraints.FIRST_LINE_START;
        super.getGbc().gridy = 2;
        super.getGbc().insets = new Insets(0, 0, 5, 0);
    }
}