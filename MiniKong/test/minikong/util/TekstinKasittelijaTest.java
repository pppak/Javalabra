package minikong.util;

import java.io.File;
import minikong.domain.TekstinTiedot;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TekstinKasittelijaTest {

    TekstinTiedot tt;
    TekstinKasittelija tk;
    
    @Before
    public void setUp(){
        File testiTeksti = new File("testiT.txt");
        tt = new TekstinTiedot();
        tk = new TekstinKasittelija(tt, testiTeksti);
    }
    
    @Test
    public void kaksiKonstruktoria(){
        assertNotNull(tk);
        assertNotNull(new TekstinKasittelija(tt, "ffff"));
    }
    
    @Test
    public void konstruktoriEiKoskeTekstiin(){
        assertNull(tt.getSananNaapurit("sana"));
        assertEquals(0, tt.getSanamaara());
        assertFalse(tt.sanaListattu(""));
    }
    
    @Test
    public void kasittelijaEiLisaaOlemattomia(){
        tk.kasittele();
        assertFalse(tt.sanaListattu(""));
    }
    
    @Test
    public void kasittelijaLisaaSanat(){
        tk.kasittele();
        assertTrue(tt.sanaListattu("vihreä"));
    }
    
    @Test
    public void kasittelijaLisaaNaapurin(){
        tk.kasittele();
        assertNotNull(tt.getSananNaapurit("on"));
    }
    
    @Test
    public void kasittelijaEiLisaaOlematontaNaapuria(){
        tk.kasittele();
        assertNull(tt.getSananNaapurit(""));
    }
    
    @Test
    public void kasittelijaLaskeeSanamaaran(){
        assertEquals(0, tt.getSanamaara());
        tk.kasittele();
        assertEquals(12, tt.getSanamaara());
    }
}