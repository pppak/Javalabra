package minikong.util;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class SiistijaTest {
    
    private Siistija siisti;
    
    @Before
    public void setUp() {
        this.siisti = new Siistija();
    }
    
    @Test
    public void siistiiPisteet(){
        String sana = "kalju.";
        sana = this.siisti.trim(sana);
        assertEquals(sana, "kalju");
    }
    
    @Test
    public void siistiiPilkut(){
        String sana = "puli,";
        sana = siisti.trim(sana);
        assertEquals(sana, "puli");
    }
    
    @Test
    public void siistiiSitaatit(){
        String sana = "\"tikkaat\'";
        sana = siisti.trim(sana);
        assertEquals(sana, "tikkaat");
    }
    
}