package minikong.domain;

public class SananEsiintyma extends Sana implements Comparable<SananEsiintyma> {

    public SananEsiintyma(String sana) {
        super(sana);
    }
    
    @Override
    public int compareTo(SananEsiintyma e) {
        if (super.getEsiintymisMaara() == e.getEsiintymisMaara()) {
            return 0;
        } else if (super.getEsiintymisMaara() > e.getEsiintymisMaara()) {
            return -1;
        } else {
            return 1;
        }

    }
}
