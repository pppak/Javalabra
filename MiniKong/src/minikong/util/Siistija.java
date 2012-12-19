package minikong.util;

public class Siistija {
    
    public String trim(String sana) {
        sana = trimPisteet(sana);
        sana = trimLainaus(sana);
        return sana;
    }

    private String trimPisteet(String sana) {
        if (sana.charAt(sana.length() - 1) == '.' || sana.charAt(sana.length() - 1) == ',') {
            sana = sana.substring(0, sana.length() - 1);
        }
        return sana;
    }

    private String trimLainaus(String sana) {
        if (sana.charAt(sana.length() - 1) == '\"' || sana.charAt(sana.length() -1) == '\'') {
            sana = sana.substring(0, sana.length() - 1);
        }
        if (sana.charAt(0) == '\"' || sana.charAt(0) == '\'') {
            sana = sana.substring(1, sana.length());
        }
        return sana;
    }
}