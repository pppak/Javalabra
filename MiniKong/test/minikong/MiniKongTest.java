package minikong;

import java.io.File;
import minikong.domain.SananEsiintyma;
import static org.junit.Assert.*;
import org.junit.*;

public class MiniKongTest {
    
    @Before
    public void setUp() {
        File testiT = new File("testiT.txt");
    }
    
    @Test
    public void sananEsiintymisMaaraOikein(){
        SananEsiintyma s = new SananEsiintyma("sana");
        assertEquals(s.getEsiintymisMaara(), 1);
        s.sanaEsiintyy();
        assertEquals(s.getEsiintymisMaara(), 2);
    }
   
}
