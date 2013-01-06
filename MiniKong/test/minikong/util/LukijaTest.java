package minikong.util;

import java.io.File;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class LukijaTest {
    
    Lukija l;
    
    @Before
    public void setUp() {
        File f;
        f = new File("testiT.txt");
        l = new Lukija(f);
    }
    
    @Test
    public void konstruktoriFilella(){
        assertNotNull(l);
    }
    
    @Test
    public void konstruktoriStringilla(){
        l = new Lukija("pah");
        assertNotNull(l);
    }
    
    @Test
    public void seuraavaAntaaTrue(){
        assertTrue(l.onkoSeuraava());
    }
    
    @Test
    public void seuraavaAntaaFalse(){
        for (int i = 0; i < 12; i++) {
            l.seuraavaSana();
        }
        assertFalse(l.onkoSeuraava());
    }
    
    @Test
    public void seuraavaAntaaSanan(){
        assertNotNull(l.seuraavaSana());
    }   
}