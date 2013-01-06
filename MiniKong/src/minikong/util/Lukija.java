package minikong.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/** Käy läpi joko File tai String muotoisen tekstin sana kerrallaan.
 * 
 * @author Pia Pakarinen
 */
public class Lukija {

    private Scanner lukija;

    public Lukija(File tiedosto) {
        try {
            this.lukija = new Scanner(tiedosto);
        } catch (FileNotFoundException ex) {
            
        }
    }

    Lukija(String text) {
        this.lukija = new Scanner(text);
    }

    public String seuraavaSana() {
        return this.lukija.next();
    }

    public void tiedostoValmis() {
        this.lukija.close();
    }

    public boolean onkoSeuraava() {
        return this.lukija.hasNext();
    }
}