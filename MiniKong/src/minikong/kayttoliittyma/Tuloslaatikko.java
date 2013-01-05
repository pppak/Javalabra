package minikong.kayttoliittyma;

import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Tuloslaatikko extends Komponentti {

    private JScrollPane laatikko;
    private JTextArea tulokset;

    public Tuloslaatikko() {
        super();
        tulokset = new JTextArea();
        tulokset.setEditable(false);
        laatikko = new JScrollPane(tulokset);
        laatikko.setPreferredSize(new Dimension(450, 300));
    }

    public void addTeksti(String tulos) {
        tulokset.append(tulos);
    }

    public void tyhjenna() {
        tulokset.setText("");
    }

    public Component getLaatikko() {
        return laatikko;
    }

    public JTextArea getTulokset() {
        return tulokset;
    }

    @Override
    void asetaRuutuun() {
        super.getGbc().gridy = 5;
    }

    @Override
    void teeKomponentit() {
        super.getOsa().add(this.laatikko);
    }
}