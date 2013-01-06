package minikong.domain;

import java.io.File;
import minikong.util.TekstinKasittelija;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TekstinTiedotTest {

    private TekstinTiedot testeri;
    private File t = new File("testiT.txt");

    public TekstinTiedotTest() {
        this.testeri = new TekstinTiedot();
    }

    @Before
    public void setUp() {
        TekstinKasittelija tk = new TekstinKasittelija(testeri, t);
        this.testeri = tk.kasittele();
    }

    @Test
    public void sanatTyhjassa() {
        TekstinTiedot tt = new TekstinTiedot();
        assertEquals(0, tt.getSanamaara());
    }
    
    @Test
    public void naapurilistaAlussaTyhjä() {
        TekstinTiedot tt = new TekstinTiedot();
        assertEquals(null, tt.getSananNaapurit("a"));
    }

    @Test
    public void sanamaaraLasketaanJaKasvaa() {
        assertEquals(12, this.testeri.getSanamaara());
        this.testeri.plusSanamaara();
        assertEquals(13, this.testeri.getSanamaara());
    }

    @Test
    public void sanaLoytyy() {
        assertTrue(testeri.sanaListattu("vihreä"));
    }

    @Test
    public void sanaaEiLoydy() {
        assertFalse(testeri.sanaListattu("heppa"));
    }

    @Test
    public void sananLisaaminenStringJaEsiintymismrOikein() {
        testeri.lisaaUusiSana("soossi");
        assertTrue(testeri.sanaListattu("soossi"));
        SananNaapurit testiN = new SananNaapurit("soossi");
        assertEquals(testiN.getSana(), testeri.getSananNaapurit("soossi").getSana());
        assertEquals(testiN.getEsiintymisMaara(), testeri.getSananNaapurit("soossi").getEsiintymisMaara());
    }

    @Test
    public void sananNaapurinLisaaminenVasemmalle() {
        testeri.lisaaUusiSana("soossi");
        testeri.lisaaNaapuri("soossi", "simpukka", true);
        assertEquals("\nsimpukka (1)", testeri.getSananNaapurit("soossi").tulostaNaapurit(1, true));
    }
    
    @Test 
    public void sananNaapuriLisataanOikealle(){
        testeri.lisaaUusiSana("geh");
        testeri.lisaaNaapuri("geh", "naapuri", false);
        assertEquals("\nnaapuri (1)", testeri.getSananNaapurit("geh").tulostaNaapurit(1, false));
    }
    
    @Test
    public void joOlemassaOlevalleVoiLisataNaapureita(){
        testeri.lisaaNaapuri("lattialla", "ei", false);
        testeri.lisaaNaapuri("lattialla", "ei", false);
        assertEquals("\nei (2)", testeri.getSananNaapurit("lattialla").tulostaNaapurit(1, false));
    }
    
    @Test
    public void tekstinVoiNollata(){
        testeri.uusiTeksti();
        assertEquals(0, testeri.getSanamaara());
        assertEquals(null, testeri.getSananNaapurit("vihreä"));
    }
    
    @Test
    public void sanamaaranTulostusmuotoOikein(){
        assertEquals("Tekstin sanamäärä: 12. Uniikkeja sanoja löytyy 9.\n" ,testeri.sanamaaraTulostus());
    }
    
    @Test 
    public void kaikkiTekstinSanatTulostuvat(){
        assertEquals("banaani (1)\nkatolla (1)\nkoira (1)\nlattialla (1)\nmusta (1)\n"
                + "on (3)\nseinällä (1)\ntv (1)\nvihreä (2)\n", testeri.kaikkiSanatTekstissäTulostus());
    }
}