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
    public void sanaItseAsetetaanOikein() {
        assertEquals("sana", n.getSana());
    }
    
    @Test
    public void oikeaLisataan() {
        n.lisaaOikea("banaani");
        assertEquals("banaani", n.getSuurimmat(false).getSana());
    }
    
    @Test
    public void kunOikealleLisaaSamaEsiintymismaaraKasvaa(){
        n.lisaaOikea("null");
        n.lisaaOikea("null");
        assertEquals(2, n.getSuurimmat(false).getEsiintymisMaara());
    }
    
    @Test
    public void vasenLisataan() {
        n.lisaaVasen("omena");
        assertEquals("omena", n.getSuurimmat(true).getSana());
    }
    
    @Test
    public void vasemmalleSamaNostaaEsiintymismaaraa(){
        n.lisaaVasen("nill");
        n.lisaaVasen("nill");
        assertEquals(2, n.getSuurimmat(true).getEsiintymisMaara());
    }
    
    @Test
    public void palauttaaSuurimmanOikea() {
        n.lisaaOikea("kissa");
        n.lisaaOikea("kommari");
        n.lisaaOikea("kissa");
        assertEquals("kissa", n.getSuurimmat(false).getSana());
    }
    
    @Test
    public void palauttaaSuurimmanVasen() {
        n.lisaaVasen("koira");
        n.lisaaVasen("kapitalisti");
        n.lisaaVasen("koira");
        assertEquals("koira", n.getSuurimmat(true).getSana());
    }
}