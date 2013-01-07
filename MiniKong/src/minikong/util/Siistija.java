package minikong.util;

import java.util.ArrayList;

/**
 * Poistaa valitusta sanasta yleisimmät välimerkit lopusta ja alusta. Muuntaa
 * sanan pienikirjaimisiksi. Ei täysin käsittele peräkkäisiä eri välimerkkejä.
 *
 * @author Pia Pakarinen
 */
public class Siistija {

    /**
     * Metodi luo listan trimmattavista välimerkeistä, poistaa ne kertaalleen
     * parametrina annetun sanan alusta ja lopusta, ja muuntaa sanan kirjaimet
     * pieniksi.
     *
     * @param sana käsiteltävä sana
     * @return siistitty sana
     */
    public String trim(String sana) {
        ArrayList<Character> trimmattavat = teeVälimerkit();
        for (Character c : trimmattavat) {
            sana = trimLopusta(sana, c);
        }
        for (Character c : trimmattavat) {
            sana = trimAlusta(sana, c);
        }
        sana = trimIsot(sana);
        return sana;
    }

    /**
     * Muuntaa sana kirjaimet pieniksi.
     *
     * @param sana käsiteltävä sana
     * @return sana pienissä kirjaimissa
     */
    private String trimIsot(String sana) {
        return sana.toLowerCase();
    }

    /**
     * Poistaa annetun merkin esiintymät parametrina annetun sanan lopusta.
     *
     * @param sana käsiteltävä sana
     * @param x poistettava välimerkki
     * @return siistitty sana
     */
    private String trimLopusta(String sana, char x) {
        if (sana.isEmpty()) {
            return "";
        }

        int i = sana.length() - 1;
        while (i > -1 && sana.charAt(i) == x) {
            i--;
        }

        return sana.substring(0, i + 1);
    }

    /**
     * Poistaa annetun merkin esiintymät parametrina annetun sanan alusta.
     *
     * @param sana siistittävä sana
     * @param x poistettava välimerkki
     * @return siistitty sana
     */
    private String trimAlusta(String sana, char x) {
        if (sana.isEmpty()) {
            return "";
        }

        int i = 0;
        while (i < sana.length() && sana.charAt(i) == x) {
            i++;
        }

        return sana.substring(i, sana.length());
    }

    /** Luo listan poistettavista välimerkeistä.
     *
     * @return lista käsiteltävistä välimerkeistä
     */
    private ArrayList<Character> teeVälimerkit() {
        ArrayList<Character> merkit = new ArrayList();
        merkit.add(')');
        merkit.add('(');
        merkit.add('}');
        merkit.add('{');
        merkit.add(']');
        merkit.add('[');
        merkit.add('\"');
        merkit.add('\'');
        merkit.add('.');
        merkit.add(',');
        merkit.add('?');
        merkit.add('!');
        merkit.add(':');
        merkit.add(';');
        return merkit;
    }
}