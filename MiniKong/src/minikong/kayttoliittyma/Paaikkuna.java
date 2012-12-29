package minikong.kayttoliittyma;

import java.awt.*;
import javax.swing.*;
import minikong.domain.TekstinTiedot;
import minikong.kayttoliittyma.kuuntelijat.*;

public class Paaikkuna implements Runnable{
    
    private JFrame frame;
    private TekstinTiedot teksti;
    
    public Paaikkuna(TekstinTiedot t) {
        this.teksti = t;
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

        teeOhjenappi(container, new GridBagConstraints());
                
        TulosLaatikko tulo = new TulosLaatikko();
        GridBagConstraints c = new GridBagConstraints();
        c.gridy = 3;
        container.add(tulo.getLaatikko(), c);
        
        teeSananHaku(tulo, container, new GridBagConstraints());
    
        teeTiedostonValinta(tulo, container, new GridBagConstraints());
        
        teePoistonappi(tulo, container, new GridBagConstraints());        
    }    

    private void teeOhjenappi(Container container, GridBagConstraints c) {
        JButton ohje = new JButton("Ohje");
        OhjeKuuntelija ok = new OhjeKuuntelija();
        ohje.addActionListener(ok);
        c.anchor = GridBagConstraints.FIRST_LINE_END;        
        container.add(ohje, c);
    }

    private void teeSananHaku(TulosLaatikko tulo, Container container, GridBagConstraints c) {
        JPanel sanahaku = new JPanel();
        sanahaku.setLayout(new GridBagLayout());
        JLabel hakuTeksti = new JLabel("Haettava sana: ");
        JTextField hakukentta = new JTextField(20);
        JButton hakuNappi = new JButton("Hae");
        HaeKuuntelija hk = new HaeKuuntelija(hakukentta, this.teksti, tulo);
        hakuNappi.addActionListener(hk);
        hakukentta.addActionListener(hk);
        sanahaku.add(hakuTeksti);
        sanahaku.add(hakukentta);
        sanahaku.add(hakuNappi);
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        c.gridy = 2;
        c.insets = new Insets(0, 0, 5, 0);
        container.add(sanahaku, c);
    }

    private void teeTiedostonValinta(TulosLaatikko tulo, Container container, GridBagConstraints c) {
        JButton tiedosto = new JButton("Valitse tekstitiedosto...");
        TiedostoKuuntelija tied = new TiedostoKuuntelija(teksti, this.getFrame(), tulo);
        tiedosto.addActionListener(tied);
        c.gridy = 1;
        c.insets = new Insets(10, -10, 5, 10);
        container.add(tiedosto, c);
    }

    private void teePoistonappi(TulosLaatikko tulo, Container container, GridBagConstraints c) {
        JButton clear = new JButton("Poista tulokset");
        PoistonappiKuuntelija pnk = new PoistonappiKuuntelija(tulo);
        clear.addActionListener(pnk);
        c.anchor = GridBagConstraints.PAGE_END;
        c.gridy = 4;
        container.add(clear, c);
    }
}