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
        assertEquals("puli", sana);
    }
    
    @Test
    public void siistiiSitaatit(){
        String sana = "\"tikkaat\'";
        sana = siisti.trim(sana);
        assertEquals("tikkaat", sana);
    }
    
    @Test
    public void eiSiistiSiistia(){
        String sana ="kaunis";
        String sana2 = siisti.trim(sana);
        assertEquals(sana, sana2);
    }
    
    @Test
    public void siistiIsotKirjaimet(){
        assertEquals("noh", siisti.trim("NOH"));
    }
}