package minikong.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lukija {
    
    private Scanner lukija;

    public Lukija(File tiedosto) throws FileNotFoundException {
        this.lukija = new Scanner(tiedosto);
    }
    
    public String seuraavaSana() {
        return this.lukija.next();
    }
    
    public void tiedostoValmis(){
        this.lukija.close();
    }
    
    public boolean onkoSeuraava() {
        return this.lukija.hasNext();
    }   
}