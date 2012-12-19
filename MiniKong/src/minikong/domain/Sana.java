package minikong.domain;

import minikong.util.Siistija;

public abstract class Sana{

    private String sana;
    private int esiintymisMaara;
    private Siistija siistija;
    
    public Sana(String sana) {
        this.siistija = new Siistija();
        this.sana = this.siistija.trim(sana);
        this.esiintymisMaara = 1;
    }
    
    public void sanaEsiintyy() {
        this.esiintymisMaara++;
    }

    public Siistija getSiistija() {
        return siistija;
    }

    public String getSana() {
        return sana;
    }

    public int getEsiintymisMaara() {
        return esiintymisMaara;
    }
    
}