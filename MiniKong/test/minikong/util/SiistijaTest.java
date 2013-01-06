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
        assertEquals("kalju", siisti.trim("kalju."));
    }
    
    @Test
    public void siistiiKolmoispisteet(){
        assertEquals("whyyy", siisti.trim("whyyy..."));
    }
    
    @Test
    public void siistiiPilkut(){
        assertEquals("puli", siisti.trim("puli,"));
    }
    
    @Test
    public void siistiiSitaatit(){
        assertEquals("tikkaat", siisti.trim("\"tikkaat\'"));
    }
    
    @Test
    public void siistiiKaksoipisteet(){
        assertEquals("käyttis", siisti.trim("käyttis:"));
    }
    
    @Test
    public void siistiiPuolipisteet(){
        assertEquals("kuu", siisti.trim("kuu;"));
    }
    
    @Test
    public void siistiiHuutomerkit(){
        assertEquals("juusto", siisti.trim("juusto!"));
    }
    
    @Test
    public void siistiiKysymysmerkit(){
        assertEquals("häirikkö", siisti.trim("häirikkö?????"));
    }
    
    @Test
    public void siistiiSulkeet(){
        assertEquals("muu", siisti.trim("({[muu]})"));
    }

    @Test
    public void siistiIsotKirjaimet(){
        assertEquals("noh", siisti.trim("NOH"));
    }
    
    @Test
    public void eiSiistiSiistia(){
        assertEquals("kaunis", siisti.trim("kaunis"));
    }
    
    @Test
    public void eiKaaduKunSanastaTuleeTyhja(){
        assertEquals("", siisti.trim(".,?!\'\""));
    }
}