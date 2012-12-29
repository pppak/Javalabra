package minikong.domain;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class SanaTest {

    private Sana s;

    @Before
    public void setUp() {
        s = new Sana("sana");
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
        Sana s2 = new Sana("apua");
        s2.sanaEsiintyy();
        assertEquals(s.compareTo(s2), 1);
        s.sanaEsiintyy();
        assertEquals(s.compareTo(s2), 0);
    }    
}