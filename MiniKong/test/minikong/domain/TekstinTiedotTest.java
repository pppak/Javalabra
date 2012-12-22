package minikong.domain;

import java.io.File;
import java.io.FileNotFoundException;
import minikong.util.Lukija;
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
        TekstinKasittelija tk = new TekstinKasittelija(testeri, new Lukija());
        try {
            tk = new TekstinKasittelija(testeri, new Lukija(t));
        } catch (FileNotFoundException ex) {
        }
        this.testeri = tk.kasittele();
    }
    
    @Test
    public void sanatTyhjassa(){
        TekstinTiedot t = new TekstinTiedot();
        assertEquals(t.getSanamaara(), 0);
    }
    
    @Test
    public void sanamaara(){
        assertEquals(this.testeri.getSanamaara(), 12);
        this.testeri.plusSanamaara();
        assertEquals(this.testeri.getSanamaara(), 13);
    }
    
    @Test 
    public void sanaLoytyy(){
        assertTrue(testeri.sanaListattu("vihreä"));
    }
    
    @Test
    public void sanaaEiLoydy() {
        assertFalse(testeri.sanaListattu("heppa"));
    }
    
    @Test 
    public void sananLisaaminen() {
        testeri.lisaaUusiSana("soossi");
        assertTrue(testeri.sanaListattu("soossi"));
        SananNaapurit testiN = new SananNaapurit("soossi");
        assertEquals(testeri.getSana("soossi").getSana(), testiN.getSana());
        assertEquals(testeri.getSana("soossi").getEsiintymisMaara(), testiN.getEsiintymisMaara());
    }
    
    @Test
    public void sananNaapurinLisaaminen() {
        testeri.lisaaUusiSana("soossi");
        testeri.lisaaNaapuri("soossi", "simpukka", true);
        assertEquals(testeri.getSana("soossi").getSuurin(true), "simpukka");
    }
    
}