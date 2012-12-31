package minikong.komennot;

import java.io.File;
import minikong.domain.TekstinTiedot;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class HankiTiedostoTest {
    
    HankiTiedosto ht;
    
    @Before
    public void setUp() {
        File f = new File("testiT.txt");
        TekstinTiedot tt = new TekstinTiedot();
        ht = new HankiTiedosto(tt, f);
    }
    
    @Test
    public void konstruktoriAsettaaTekstin(){
        assertNotNull(ht.getTeksti());
    }
    
    @Test
    public void asetettuTekstiLoytyy(){
        TekstinTiedot tt2 = new TekstinTiedot();
        ht.setTeksti(tt2);
        assertEquals(tt2, ht.getTeksti());
    }
    
    @Test
    public void suoritaLuoSananNaapuritOlion(){
        ht.suorita();
        assertNotNull(ht.getTeksti().getSananNaapurit("vihreä"));
    }
    
    @Test
    public void suoritaLisaaSanoja(){
        ht.suorita();
        assertTrue(ht.getTeksti().sanaListattu("vihreä"));
    }
    
    @Test
    public void suoritaLisaaSanamaaraa(){
        ht.suorita();
        assertFalse(ht.getTeksti().getSanamaara() == 0);
 
    }
}