package minikong.kayttoliittyma;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import minikong.kayttoliittyma.kuuntelijat.HaeKuuntelija;

public class Sanahaku {

    Sanahaku(Tuloslaatikko tulo, Container container, GridBagConstraints gridBagConstraints, HaeKuuntelija stalkkeri) {
        lisaaIkkunaan(container, teeKomponentit(stalkkeri), teeIkkunaanAsetus(gridBagConstraints));
    }
    
    private JPanel teeKomponentit(HaeKuuntelija stalkkeri){
        JPanel sanahaku = new JPanel();
        sanahaku.setLayout(new GridBagLayout());
        JLabel hakuTeksti = new JLabel("Haettava sana: ");
        JTextField hakukentta = new JTextField(20);
        JButton hakunappi = new JButton("Hae");
        lisaaKuuntelija(hakunappi, hakukentta, stalkkeri);
        sanahaku.add(hakuTeksti);
        sanahaku.add(hakukentta);
        sanahaku.add(hakunappi);
        return sanahaku;
    }

    private void lisaaKuuntelija(JButton n, JTextField k, HaeKuuntelija hk) {
        hk.setHakukentta(k);
        n.addActionListener(hk);
        k.addActionListener(hk);
    }
    
    private GridBagConstraints teeIkkunaanAsetus(GridBagConstraints gbc) {
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.gridy = 2;
        gbc.insets = new Insets(0, 0, 5, 0);
        return gbc;
    }

    private void lisaaIkkunaan(Container container, JPanel k, GridBagConstraints c) {
        container.add(k, c);
    }
}