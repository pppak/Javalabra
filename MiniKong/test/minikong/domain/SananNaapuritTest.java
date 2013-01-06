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
        assertEquals(0, n.getEsiintymisMaara());
    }
    
    
    @Test
    public void naapuritLisataanJaTulostetaanKunYksiVasen(){
        n.lisaaVasen("kala");
        assertEquals("\nkala (1)", n.tulostaNaapurit(1, true));
    }
    
    @Test
    public void naapuritLisataanJaTulostetaanKunYksiOikea(){
        n.lisaaOikea("kala");
        assertEquals("\nkala (1)", n.tulostaNaapurit(1, false));
    }
    
    @Test
    public void useampiNaapuriTulostuuOikeinVasen(){
        n.lisaaVasen("kala");
        n.lisaaVasen("hauki");
        assertEquals("\nhauki (1)\nkala (1)", n.tulostaNaapurit(2, true));
    }
    
    @Test
    public void useampiNaapuriTulostuuOikeinOikea(){
        n.lisaaOikea("kala");
        n.lisaaOikea("hauki");
        assertEquals("\nhauki (1)\nkala (1)", n.tulostaNaapurit(2, false));
    }
    
    @Test
    public void samanNaapurinLisaaminenNostaaEsiintymismaaraa(){
        n.lisaaOikea("kala");
        n.lisaaOikea("kala");
        assertEquals("\nkala (2)", n.tulostaNaapurit(2, false));
        n.lisaaVasen("hauki");
        n.lisaaVasen("hauki");
        assertEquals("\nhauki (2)", n.tulostaNaapurit(2, true));
    }
    
    @Test
    public void naapuritTulostuvatSuuruusjarjestyksessa(){
        n.lisaaOikea("kala");
        n.lisaaOikea("kala");
        n.lisaaOikea("hauki");
        assertEquals("\nkala (2)\nhauki (1)", n.tulostaNaapurit(2, false));
    }
    
    @Test
    public void naapureitaEiTulostetaEnempääKuinOlemassa(){
        n.lisaaVasen("kala");
        assertEquals("\nkala (1)", n.tulostaNaapurit(5, true));
    }
}