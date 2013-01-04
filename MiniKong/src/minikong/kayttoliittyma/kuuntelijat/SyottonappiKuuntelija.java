package minikong.kayttoliittyma.kuuntelijat;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import minikong.domain.TekstinTiedot;
import minikong.kayttoliittyma.ApuIkkuna;
import minikong.kayttoliittyma.Tuloslaatikko;

public class SyottonappiKuuntelija implements ActionListener{

    TekstinTiedot tt;
    JFrame frame;
    Tuloslaatikko tulo;
    ApuIkkuna syotto;
    
    public SyottonappiKuuntelija(TekstinTiedot tt, JFrame frame, Tuloslaatikko tulo) {
        this.tt = tt;
        this.frame = frame;
        this.tulo = tulo;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        GridBagConstraints gbc = new GridBagConstraints();
        JPanel ikkuna = new JPanel(new GridBagLayout());
        JLabel ohje = new JLabel(teeTeksti());
        ikkuna.add(ohje);
        JTextArea pasta = new JTextArea();
        pasta.setEditable(true);
        JScrollPane sp = new JScrollPane(pasta);
        gbc.gridy = 1;
        ikkuna.add(sp, gbc);
        JButton syota = new JButton("OK");
        SyottoKopioi sk = new SyottoKopioi(pasta, tt, tulo);
        syota.addActionListener(sk);
        gbc.gridy = 2;
        ikkuna.add(syota, gbc);
        sp.setPreferredSize(new Dimension(450, 300));
        syotto = new ApuIkkuna("Tekstin syöttö", "Peru", ikkuna, 400, 400);
        syotto.run();
    }
    
    private String teeTeksti() {
        return "";
    }
}