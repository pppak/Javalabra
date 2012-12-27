package minikong.kayttoliittyma;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import minikong.domain.TekstinTiedot;

public class Paaikkuna implements Runnable{
    
    private JFrame frame;
    private TekstinTiedot teksti;

    public Paaikkuna(TekstinTiedot teksti) {
        this.teksti = teksti;
    }
    
    

    @Override
    public void run() {
        frame = new JFrame();
        frame.setPreferredSize(new Dimension(500, 500));
        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        teeKomponentit(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }
    
    public JFrame getFrame() {
        return frame;
    }

    private void teeKomponentit(Container container) {
        container.setLayout(new GridBagLayout());
        
        JButton ohje = new JButton("Ohje");
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.FIRST_LINE_END;        
        container.add(ohje, c);
        
        JButton tiedosto = new JButton("Valitse tekstitiedosto...");
        c = new GridBagConstraints();
        c.gridy = 1;
        c.insets = new Insets(10, -10, 5, 10);
        container.add(tiedosto, c);
        
        //kuuntelijat
        //JFileChooser tiedVal = new JFileChooser();
        //tiedVal.setFileFilter(new FileNameExtensionFilter("Tekstitiedostot", "txt"));
        
        
        JPanel sanahaku = new JPanel();
        sanahaku.setLayout(new GridBagLayout());
        JLabel hakuTeksti = new JLabel("Haettava sana: ");
        JTextField hakukentta = new JTextField(20);
        JButton hakuNappi = new JButton("Hae");
        sanahaku.add(hakuTeksti);
        sanahaku.add(hakukentta);
        sanahaku.add(hakuNappi);
        c = new GridBagConstraints();
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        c.gridy = 2;
        c.insets = new Insets(0, 0, 5, 0);
        container.add(sanahaku, c);
        
        JTextArea tulokset = new JTextArea();
        tulokset.setEditable(false);
        JScrollPane tulo2 = new JScrollPane(tulokset);
        tulo2.setPreferredSize(new Dimension(450, 300));
        c = new GridBagConstraints();
        c.gridy = 3;
        container.add(tulo2, c);
        
        JButton clear = new JButton("Poista tulokset");
        c = new GridBagConstraints();
        c.anchor = GridBagConstraints.PAGE_END;
        c.gridy = 4;
        container.add(clear, c);
        
    }
    
}