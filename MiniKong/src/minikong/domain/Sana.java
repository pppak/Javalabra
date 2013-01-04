package minikong.domain;

public class Sana implements Comparable<Sana> {

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

    @Override
    public int compareTo(Sana e) {
        if (this.getEsiintymisMaara() == e.getEsiintymisMaara()) {
            return 0;
        } else if (this.getEsiintymisMaara() > e.getEsiintymisMaara()) {
            return -1;
        } else {
            return 1;
        }
    }
}