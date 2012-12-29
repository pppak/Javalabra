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
    public void oikeaLisataan() {
        n.lisaaOikea("banaani");
        assertEquals("banaani", n.getSuurin(false).getSana());
    }
    
    @Test
    public void vasenLisataan() {
        n.lisaaVasen("omena");
        assertEquals("omena", n.getSuurin(true).getSana());
    }
    
    @Test
    public void palauttaaSuurimmanOikea() {
        n.lisaaOikea("kissa");
        n.lisaaOikea("kommari");
        n.lisaaOikea("kissa");
        assertEquals("kissa", n.getSuurin(false).getSana());
    }
    
    @Test
    public void palauttaaSuurimmanVasen() {
        n.lisaaVasen("koira");
        n.lisaaVasen("kapitalisti");
        n.lisaaVasen("koira");
        assertEquals("koira", n.getSuurin(true).getSana());
    }
}