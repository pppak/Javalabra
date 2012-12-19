package minikong.komennot;

import java.io.File;
import minikong.domain.TekstinTiedot;
import minikong.util.Lukija;
import minikong.util.TekstinKasittelija;

public class HankiTiedosto extends Komento{

    //korvataan myöhemmin:GUI
    private File fri = new File("tester.txt");

    public HankiTiedosto(TekstinTiedot t, Lukija l) {
        super(t, l);
    }
    
    
    @Override
    public void suorita() {
        //aivan vaiheessa
        try {
            super.lukija = new Lukija(fri);
        } catch (Exception e) {
            //GUI
            System.out.println("Syötä sopiva tiedosto");
        }
        
        if (fri.exists()) {
            TekstinKasittelija parser = new TekstinKasittelija(super.getTeksti(), lukija);
            super.setTeksti(parser.kasittele());
        }
    }
    
}