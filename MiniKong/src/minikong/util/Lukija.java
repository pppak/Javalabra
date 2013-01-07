package minikong.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/** Käy läpi joko File tai String muotoisen tekstin sana kerrallaan.
 * 
 * @author Pia Pakarinen
 */
public class Lukija {

    /**
     * Lukijan käyttämä Scanner-olio.
     */
    private Scanner lukija;

    /** Luo uuden Lukija olion, jonka Scanner-olio saa parametrikseen tiedoston.
     * 
     * @param tiedosto käsiteltävä tekstitiedosto
     */
    public Lukija(File tiedosto) {
        try {
            this.lukija = new Scanner(tiedosto);
        } catch (FileNotFoundException ex) {
            
        }
    }

    /** Luo uuden Lukija olion, jonka Scanner-olio saa parametrikseen Stringin.
     * 
     * @param text käsiteltävä teksti Stringinä
     */
    Lukija(String text) {
        this.lukija = new Scanner(text);
    }

    /** Palauttaa tekstissä seuraavan sanan.
     * 
     * @return seuraava sana
     */
    public String seuraavaSana() {
        return this.lukija.next();
    }

    /**
     * Sulkee Lukijan Scanner-olion.
     */
    public void tiedostoValmis() {
        this.lukija.close();
    }

    /** Tarkistaa löytyykö tekstistä seuraavaa sanaa.
     * 
     * @return true jos tekstissä vielä sanoja
     */
    public boolean onkoSeuraava() {
        return this.lukija.hasNext();
    }
}