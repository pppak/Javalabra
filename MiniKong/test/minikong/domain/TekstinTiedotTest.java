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
        assertFalse(tt.sanaListattu(""));
    }

    @Test
    public void sanamaaraOKJaKasvaa() {
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
        assertEquals("simpukka", testeri.getSananNaapurit("soossi").getSuurin(true).getSana());
    }
    
    @Test 
    public void sananNaapuriLisataanOikealle(){
        testeri.lisaaUusiSana("geh");
        testeri.lisaaNaapuri("geh", "naapuri", false);
        assertEquals("naapuri", testeri.getSananNaapurit("geh").getSuurin(false).getSana());
    }
    
    @Test
    public void joOlemassaOlevalleVoiLisataNaapureita(){
        testeri.lisaaNaapuri("lattialla", "ei", false);
        testeri.lisaaNaapuri("lattialla", "ei", false);
        assertEquals("ei", testeri.getSananNaapurit("lattialla").getSuurin(false).getSana());
    }
}