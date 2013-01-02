
package minikong;

import javax.swing.SwingUtilities;
import minikong.domain.TekstinTiedot;
import minikong.kayttoliittyma.Paaikkuna;

public class MiniKong {

    public static void main(String[] args) {        
        Paaikkuna GUI = new Paaikkuna(new TekstinTiedot());
        SwingUtilities.invokeLater(GUI);
    }
}