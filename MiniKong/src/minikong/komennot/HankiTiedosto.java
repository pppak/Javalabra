package minikong.komennot;

import java.io.File;
import java.util.Scanner;
import minikong.domain.TekstinTiedot;
import minikong.util.Lukija;
import minikong.util.TekstinKasittelija;

public class HankiTiedosto extends Komento {

    //korvataan myöhemmin:GUI
    private File fri = new File("tester.txt");
    
    private Scanner syote;
    private Lukija lukija;

    public HankiTiedosto(TekstinTiedot t, Lukija l) {
        super(t);
        this.syote = new Scanner(System.in);
        this.lukija = l;
    }

    @Override
    public void suorita() {
        //aika vaiheessa
        System.out.println("syötä tiedoston polku: ");
        String tiedosto = syote.nextLine();
        try {
            this.lukija = new Lukija(new File(tiedosto));
        } catch (Exception e) {
            //GUI
            System.out.println("Syötä sopiva tiedosto");
            return;
        }

        TekstinKasittelija parser = new TekstinKasittelija(super.getTeksti(), lukija);
        super.setTeksti(parser.kasittele());

    }
}