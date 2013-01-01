package minikong;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import minikong.domain.TekstinTiedot;
import minikong.komennot.HaeNaapuri;
import minikong.komennot.HankiTiedosto;
import minikong.util.Lukija;
import static org.junit.Assert.*;
import org.junit.*;

public class MiniKongTest {

    private Sovellus s;
    
    @Before
    public void setUp() {
        this.s = new Sovellus();
    }

    @Test
    public void mainKaynnistyy() {
        assertNotNull(s);
    }
}