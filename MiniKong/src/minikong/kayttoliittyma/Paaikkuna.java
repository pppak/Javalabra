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
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import minikong.domain.TekstinTiedot;
import minikong.kayttoliittyma.kuuntelijat.OhjeKuuntelija;
import minikong.kayttoliittyma.kuuntelijat.PoistoNappiKuuntelija;
import minikong.kayttoliittyma.kuuntelijat.TiedostoKuuntelija;
import minikong.util.Lukija;

public class Paaikkuna implements Runnable{
    
    private JFrame frame;
    private TekstinTiedot teksti;
    private Lukija lukija;

    public Paaikkuna(TekstinTiedot t, Lukija l) {
        this.teksti = t;
        this.lukija = l;
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
        OhjeKuuntelija ok = new OhjeKuuntelija();
        ohje.addActionListener(ok);
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.FIRST_LINE_END;        
        container.add(ohje, c);
                
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
        
        TulosLaatikko tulo = new TulosLaatikko();
        c = new GridBagConstraints();
        c.gridy = 3;
        container.add(tulo.getLaatikko(), c);
        
        JButton tiedosto = new JButton("Valitse tekstitiedosto...");
        TiedostoKuuntelija tied = new TiedostoKuuntelija(lukija, teksti, this.getFrame(), tulo);
        tiedosto.addActionListener(tied);
        c = new GridBagConstraints();
        c.gridy = 1;
        c.insets = new Insets(10, -10, 5, 10);
        container.add(tiedosto, c);
        
        JButton clear = new JButton("Poista tulokset");
        PoistoNappiKuuntelija pnk = new PoistoNappiKuuntelija(tulo);
        clear.addActionListener(pnk);
        c = new GridBagConstraints();
        c.anchor = GridBagConstraints.PAGE_END;
        c.gridy = 4;
        container.add(clear, c);
        
    }
    
}