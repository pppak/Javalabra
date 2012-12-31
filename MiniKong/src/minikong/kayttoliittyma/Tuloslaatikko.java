package minikong.kayttoliittyma;

import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Tuloslaatikko {

    private JScrollPane loota;
    private JTextArea tulokset;

    public Tuloslaatikko() {
        tulokset = new JTextArea();
        tulokset.setEditable(false);
        loota = new JScrollPane(tulokset);
        loota.setPreferredSize(new Dimension(450, 300));
    }

    public void addTeksti(String tulos) {
        tulokset.append(tulos);
    }

    public void tyhjenna() {
        tulokset.setText("");
    }

    public Component getLaatikko() {
        return loota;
    }
}