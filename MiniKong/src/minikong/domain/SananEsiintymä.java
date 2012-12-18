package minikong.domain;

public class SananEsiintymä extends Sana implements Comparable<SananEsiintymä> {

    public SananEsiintymä(String sana) {
        super(sana);
    }

    @Override
    public int compareTo(SananEsiintymä e) {
        if (super.getEsiintymisMaara() == e.getEsiintymisMaara()) {
            return 0;
        } else if (super.getEsiintymisMaara() > e.getEsiintymisMaara()) {
            return -1;
        } else {
            return 1;
        }

    }
}
