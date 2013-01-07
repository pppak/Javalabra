package minikong.domain;

/** Tallentaa tekstin sanoista esiintymiä, jossa sanat ovat vertailtavissa esiintymismääriensä mukaan.
 * 
 * @author Pia Pakarinen
 */

public class Sana implements Comparable<Sana> {

    /**
     * sana Stringinä
     */
    private String sana;
    /**
     * sanan esiintymismäärä
     */
    private int esiintymisMaara;

    /** Luo uuden parametrin mukaisen sanan ja asettaa esiintymismäärän nollaksi.
     * 
     * @param sana tallennettava sana
     */
    public Sana(String sana) {
        this.sana = sana;
        this.esiintymisMaara = 0;
    }

    /**
     * Nostaa esiintymismäärää yhdellä
     */
    public void sanaEsiintyy() {
        this.esiintymisMaara++;
    }

    /**
     * Palauttaa sanan kirjaimellisen muodon
     * @return sana Stringinä
     */
    public String getSana() {
        return sana;
    }

    /**
     * Palauttaa esiintymismäärän int-muotoisena.
     * @return esiintymiset
     */
    public int getEsiintymisMaara() {
        return esiintymisMaara;
    }

    /** Asettaa sanojen järjestämisen esiintymismääristä riippuvaisiksi; korkeammat
     * esiintymismäärät esitetään ensin.
     * 
     * @param e Vertailtava sana
     * @return järjestämisessä auttava luku
     */
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