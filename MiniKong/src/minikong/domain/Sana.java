package minikong.domain;

public abstract class Sana{

    private String sana;
    private int esiintymisMaara;
    
    public Sana(String sana) {
        this.sana = sana;
        this.esiintymisMaara = 0;
    }
    
    public void sanaEsiintyy() {
        this.esiintymisMaara++;
    }

    public String getSana() {
        return sana;
    }

    public int getEsiintymisMaara() {
        return esiintymisMaara;
    }
    
    
}
