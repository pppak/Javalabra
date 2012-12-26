package minikong.kayttoliittyma;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class Paaikkuna implements Runnable{
    
    private JFrame frame;

    @Override
    public void run() {
        frame = new JFrame();
        frame.setPreferredSize(new Dimension(500, 300));
        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        teeKomponentit(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }
    
    public JFrame getFrame() {
        return frame;
    }

    private void teeKomponentit(Container container) {
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        
        JButton tiedosto = new JButton("Valitse tekstitiedosto...");
        //kuuntelijat
        //JFileChooser tiedVal = new JFileChooser();
        //tiedVal.setFileFilter(new FileNameExtensionFilter("Tekstitiedostot", "txt"));
        
        JTextArea tulokset = new JTextArea();
        tulokset.setEditable(false);
        
        container.add(tiedosto);
        container.add(new SanaHaunOsa().getSanahaku());
        container.add(tulokset);
              
    }
    
}
