
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

    /** Luo TekstinTiedot olion. Luo käyttöliittymän ja käynnistää sen.
     * 
     * @param args 
     */
    public static void main(String[] args) {        
        Paaikkuna GUI = new Paaikkuna(new TekstinTiedot());
        SwingUtilities.invokeLater(GUI);
    }
}