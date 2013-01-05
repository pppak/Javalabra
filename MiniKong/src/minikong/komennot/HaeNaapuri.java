package minikong.komennot;

import minikong.domain.Sana;
import minikong.domain.TekstinTiedot;

public class HaeNaapuri{
    
    private TekstinTiedot teksti;
    private int maara;

    public HaeNaapuri(TekstinTiedot t, int mr) {
        this.teksti = t;
        this.maara = mr;
    }

    public String getVasen(String sana) {
        if (tarkistaOnkoNaapuria(sana, true)) {
            return "Naapureita ei löydy.";
        }
        String naapurit = "";
        int l = this.teksti.getSananNaapurit(sana).getSuurimmat(true).size();
        if (maara > l) {
            maara = l;
        }
        for (int i = 0; i < maara; i++) {
            Sana s = this.teksti.getSananNaapurit(sana).getSuurimmat(true).get(i);
            naapurit += "\n" + s.getSana() + " (" + s.getEsiintymisMaara() + ")";
        }
        return naapurit;
    }

    public String getOikea(String sana) {
        if (tarkistaOnkoNaapuria(sana, false)) {
            return "Naapureita ei löydy.";
        }
        String naapurit = "";
        int l = this.teksti.getSananNaapurit(sana).getSuurimmat(false).size();
        if (maara > l) {
            maara = l;
        }
        for (int i = 0; i < maara; i++) {
            Sana s = this.teksti.getSananNaapurit(sana).getSuurimmat(false).get(i);
            naapurit += "\n" + s.getSana() + " (" + s.getEsiintymisMaara() + ")";
        }
        return naapurit;
    }

    private boolean tarkistaOnkoNaapuria(String sana, Boolean vasen) {
        if (this.teksti.getSananNaapurit(sana).getSuurimmat(vasen) == null) {
            return true;
        }
        return false;
    }
}