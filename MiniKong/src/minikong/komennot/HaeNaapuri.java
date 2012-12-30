package minikong.komennot;

import minikong.domain.TekstinTiedot;

public class HaeNaapuri extends Komento {

    public HaeNaapuri(TekstinTiedot t) {
        super(t);
    }

    public String getVasen(String sana) {
        if (tarkistaOnkoNaapuria(sana, true)) {
            return "Naapureita ei löydy.";
        }
        return this.getTeksti().getSananNaapurit(sana).getSuurin(true).getSana() + " (" + this.getTeksti().getSananNaapurit(sana).getSuurin(true).getEsiintymisMaara() + ")";
    }

    public String getOikea(String sana) {
        if (tarkistaOnkoNaapuria(sana, false)) {
            return "Naapureita ei löydy.";
        }
        return this.getTeksti().getSananNaapurit(sana).getSuurin(false).getSana() + " (" + this.getTeksti().getSananNaapurit(sana).getSuurin(false).getEsiintymisMaara() + ")";
    }

    private boolean tarkistaOnkoNaapuria(String sana, Boolean vasen) {
        if (this.getTeksti().getSananNaapurit(sana).getSuurin(vasen) == null) {
            return true;
        }
        return false;
    }
}