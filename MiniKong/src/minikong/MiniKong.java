
package minikong;

import javax.swing.SwingUtilities;
import minikong.kayttoliittyma.Paaikkuna;

public class MiniKong {

    public static void main(String[] args) {
        Sovellus s = new Sovellus();
       // s.suorita();
        
        Paaikkuna p = new Paaikkuna();
        SwingUtilities.invokeLater(p);
    }
}
