package minikong.util;

import java.util.ArrayList;

public class Siistija {

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

    private String trimIsot(String sana) {
        return sana.toLowerCase();
    }

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

    private ArrayList<Character> teeVälimerkit() {
        ArrayList<Character> merkit = new ArrayList();
        merkit.add('\"');
        merkit.add('\'');
        merkit.add(')');
        merkit.add('(');
        merkit.add('}');
        merkit.add('{');
        merkit.add(']');
        merkit.add('[');
        merkit.add('.');
        merkit.add(',');
        merkit.add('?');
        merkit.add('!');
        merkit.add(':');
        merkit.add(';');
        return merkit;
    }
}