package minikong.domain;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class SananEsiintymaTest {

    private SananEsiintyma s;

    @Before
    public void setUp() {
        s = new SananEsiintyma("sana");
    }

    @Test
    public void sananEsiintymisMaaraOikein() {
        assertEquals(s.getEsiintymisMaara(), 1);
        s.sanaEsiintyy();
        assertEquals(s.getEsiintymisMaara(), 2);
    }

    @Test
    public void sanaTallennetaanOikein() {
        assertEquals(s.getSana(), "sana");
    }
    
    @Test
    public void sanatVertaillaan(){
        SananEsiintyma s2 = new SananEsiintyma("apua");
        s2.sanaEsiintyy();
        assertEquals(s.compareTo(s2), 1);
        s.sanaEsiintyy();
        assertEquals(s.compareTo(s2), 0);
    }
    
}
