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
    public void sanaAsettuuOikein() {
        assertEquals("sana", s.getSana());
        assertEquals(0, s.getEsiintymisMaara());
    }

    @Test
    public void sananEsiintymisMaaraKasvaa() {
        s.sanaEsiintyy();
        assertEquals(1, s.getEsiintymisMaara());
    }
    
    @Test
    public void sanatVertaillaan(){
        Sana s2 = new Sana("apua");
        s2.sanaEsiintyy();
        assertEquals(1, s.compareTo(s2));
        s.sanaEsiintyy();
        assertEquals(0, s.compareTo(s2));
    }    
}