package minikong.kayttoliittyma;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import minikong.domain.TekstinTiedot;
import minikong.kayttoliittyma.kuuntelijat.HaeKuuntelija;
import minikong.kayttoliittyma.kuuntelijat.ListausKuuntelija;

public class SanahakuJaSanojenTulostus extends Komponentti{

    private Tuloslaatikko tulo;
    private TekstinTiedot tt;
    private NaapurienMaaranValinta nm;
    
    SanahakuJaSanojenTulostus(Tuloslaatikko tulo, TekstinTiedot tt, NaapurienMaaranValinta nm) {
        super();
        this.nm = nm;
        this.tt = tt;
        this.tulo = tulo;
    }
    
    @Override
    public void teeKomponentit(){
        super.getOsa().setLayout(new GridBagLayout());
        JLabel hakuTeksti = new JLabel("Haettava sana: ");
        JTextField hakukentta = new JTextField(20);
        JButton hakunappi = new JButton("Hae");
        
        lisaaHakuKuuntelijat(hakunappi, hakukentta, new HaeKuuntelija(tt, tulo, nm, hakukentta));
        
        JButton sanat = new JButton("Näytä sanat");
        sanat.addActionListener(new ListausKuuntelija(tt)); 
        
        super.getOsa().add(hakuTeksti);
        super.getOsa().add(hakukentta);
        super.getOsa().add(hakunappi);
        super.getOsa().add(sanat);
    }

    private void lisaaHakuKuuntelijat(JButton n, JTextField k, HaeKuuntelija hk) {
        n.addActionListener(hk);
        k.addActionListener(hk);
    }
    
    @Override
    void asetaRuutuun() {
        super.getGbc().anchor = GridBagConstraints.FIRST_LINE_START;
        super.getGbc().gridy = 3;
        super.getGbc().insets = new Insets(0, 0, 5, 0);
    }
}