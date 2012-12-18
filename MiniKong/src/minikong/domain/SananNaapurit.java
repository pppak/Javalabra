package minikong.domain;

import java.util.ArrayList;

public class SananNaapurit extends Sana implements Comparable<SananNaapurit>{
    
    private ArrayList<SananEsiintymä> vasen;
    private ArrayList<SananEsiintymä> oikea;

    public SananNaapurit(String sana) {
        super(sana);
    }
    

    @Override
    public int compareTo(SananNaapurit n) {
        if (super.getEsiintymisMaara() == n.getEsiintymisMaara()) {
            return 0;
        } else if (super.getEsiintymisMaara() > n.getEsiintymisMaara()) {
            return -1;
        } else {
            return 1;
        }
    }

    
}