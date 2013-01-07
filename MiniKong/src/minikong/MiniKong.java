
package minikong;

import javax.swing.SwingUtilities;
import minikong.domain.TekstinTiedot;
import minikong.kayttoliittyma.Paaikkuna;

/** Luo ja käynnistää käyttöliittymän ja TekstinTiedot olion.
 * 
 * @author Pia Pakarinen
 * 
 */

public class MiniKong {

    public static void main(String[] args) {        
        Paaikkuna GUI = new Paaikkuna(new TekstinTiedot());
        SwingUtilities.invokeLater(GUI);
    }
}