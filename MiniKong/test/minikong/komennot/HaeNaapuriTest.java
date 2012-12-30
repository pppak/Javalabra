package minikong.komennot;

import minikong.domain.TekstinTiedot;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class HaeNaapuriTest {

    HaeNaapuri hn;

    @Before
    public void setUp() {
        TekstinTiedot tt = new TekstinTiedot();
        tt.lisaaUusiSana("Brody");
        tt.lisaaNaapuri("Brody", "Quest", false);
        tt.lisaaNaapuri("Brody", "Adrian", true);
        hn = new HaeNaapuri(tt);
    }

    @Test
    public void konstruktori() {
        assertNotNull(hn.getTeksti());
    }

    @Test
    public void tekstinVoiAsettaa() {
        TekstinTiedot tt2 = new TekstinTiedot();
        hn.setTeksti(tt2);
        assertEquals(tt2, hn.getTeksti());
    }

    @Test
    public void oikeaNaapuriLoytyy() {
        assertEquals("Quest (1)", hn.getOikea("Brody"));
    }

    @Test
    public void vasenNaapuriLoytyy() {
        assertEquals("Adrian (1)", hn.getVasen("Brody"));
    }

    @Test
    public void oikeaOlematonEiLoydy() {
        TekstinTiedot tt2 = new TekstinTiedot();
        tt2.lisaaUusiSana("coo");
        hn.setTeksti(tt2);
        assertEquals("Naapureita ei löydy.", hn.getOikea("coo"));
    }

    @Test
    public void vasenOlematonEiLoydy() {
        TekstinTiedot tt2 = new TekstinTiedot();
        tt2.lisaaUusiSana("coo");
        hn.setTeksti(tt2);
        assertEquals("Naapureita ei löydy.", hn.getVasen("coo"));
    }
}