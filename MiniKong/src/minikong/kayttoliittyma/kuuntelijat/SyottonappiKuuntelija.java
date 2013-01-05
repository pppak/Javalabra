package minikong.kayttoliittyma.kuuntelijat;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import minikong.domain.TekstinTiedot;
import minikong.kayttoliittyma.ApuIkkuna;
import minikong.kayttoliittyma.Tuloslaatikko;

public class SyottonappiKuuntelija implements ActionListener{

    TekstinTiedot tt;
    Tuloslaatikko tulo;
    ApuIkkuna syottoIkkuna;
    
    public SyottonappiKuuntelija(TekstinTiedot tt, Tuloslaatikko tulo) {
        this.tt = tt;
        this.tulo = tulo;
        //sisältö asetetaan myöhemmin; getFrame tarpeellinen ennen kuin valmis
        this.syottoIkkuna = new ApuIkkuna("Tekstin syöttö", "Peru", null, 400, 400);        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        JPanel ikkuna = new JPanel(new GridBagLayout());
        ikkuna = teeIkkuna(ikkuna);
        syottoIkkuna.setIkkunanSisalto(ikkuna);
        syottoIkkuna.run();
    }
    
    private String teeTeksti() {
        return "<html>Kopioi tai kirjoita alla olevaan ikkunaan teksti, <br>"
                + "josta haluat suorittaa haut.";
    }

    private JPanel teeIkkuna(JPanel ikkuna) {
        GridBagConstraints gbc = new GridBagConstraints();
        
        JLabel ohje = new JLabel(teeTeksti());
        ikkuna.add(ohje);
        
        JTextArea syottoAlue = new JTextArea();
        syottoAlue.setEditable(true);
        JScrollPane sp = new JScrollPane(syottoAlue);
        sp.setPreferredSize(new Dimension(450, 300));
        gbc.gridy = 1;
        ikkuna.add(sp, gbc);
        
        JButton syota = new JButton("OK");
        SyottoKuuntelija sk = new SyottoKuuntelija(syottoAlue, tt, tulo, syottoIkkuna);
        syota.addActionListener(sk);
        gbc.gridy = 2;
        ikkuna.add(syota, gbc);
        
        return ikkuna;
    }
}