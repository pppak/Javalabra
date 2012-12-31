package minikong.kayttoliittyma;

import java.awt.*;
import javax.swing.*;
import minikong.domain.TekstinTiedot;
import minikong.kayttoliittyma.kuuntelijat.*;

public class Paaikkuna implements Runnable {

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

        Ohje ohje = new Ohje(container, new GridBagConstraints());

        Tuloslaatikko tulo = new Tuloslaatikko();
        GridBagConstraints c = new GridBagConstraints();
        c.gridy = 3;
        container.add(tulo.getLaatikko(), c);

        Sanahaku sanahaku = new Sanahaku(tulo, container, new GridBagConstraints(), new HaeKuuntelija(this.teksti, tulo));

        TiedostonValinta tiedval = new TiedostonValinta(tulo, container, new GridBagConstraints(), this.getFrame(), this.teksti);

        Poisto poisto = new Poisto(tulo, container, new GridBagConstraints());
    }
}