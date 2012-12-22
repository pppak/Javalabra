package minikong.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lukija {
    
    private Scanner luk;

    public Lukija() {
        this.luk = new Scanner("");
    }

    public Lukija(File tiedosto) throws FileNotFoundException {
        this.luk = new Scanner(tiedosto);
    }
    
    public String seuraavaSana() {
        return this.luk.next();
    }
    
    public void tiedostoValmis(){
        this.luk.close();
    }
    
    public boolean onkoSeuraava() {
        return this.luk.hasNext();
    }
    
    
}
