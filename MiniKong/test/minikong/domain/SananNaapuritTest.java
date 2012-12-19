package minikong.domain;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class SananNaapuritTest {

    private SananNaapurit n;

    @Before
    public void setUp() {
        n = new SananNaapurit("sana");
    }

    @Test
    public void sanaItseOikein() {
        assertEquals(n.getSana(), "sana");
    }
   
    @Test
    public void pisteitaEiLisata() {
        n.lisaaOikea("cat.");
        assertEquals(n.getSuurin(false), "cat");
    }
    
    @Test
    public void pilkkujaEiLisata() {
        n.lisaaVasen("aneurysm,");
        assertEquals(n.getSuurin(true), "aneurysm");
    }

    @Test
    public void eiSitaatteja(){
        n.lisaaOikea("\"koala\"");
        assertEquals(n.getSuurin(false), "koala");
        n.lisaaVasen("\'poliisi\'");
        assertEquals(n.getSuurin(true), "poliisi");
    }
    
    @Test
    public void oikeaLisataan() {
        n.lisaaOikea("banaani");
        assertEquals(n.getSuurin(false), "banaani");
    }
    
    @Test
    public void vasenLisataan() {
        n.lisaaVasen("omena");
        assertEquals(n.getSuurin(true), "omena");
    }
    
    @Test
    public void palauttaaSuurimmanOikea() {
        n.lisaaOikea("kissa");
        n.lisaaOikea("kommari");
        n.lisaaOikea("kissa");
        assertEquals(n.getSuurin(false), "kissa");
    }
    
    @Test
    public void palauttaaSuurimmanVasen() {
        n.lisaaVasen("koira");
        n.lisaaVasen("kapitalisti");
        n.lisaaVasen("koira");
        assertEquals(n.getSuurin(true), "koira");
    }
    
}