package minikong;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import minikong.domain.TekstinTiedot;
import minikong.komennot.HaeSana;
import minikong.komennot.HankiTiedosto;
import minikong.util.Lukija;
import static org.junit.Assert.*;
import org.junit.*;

public class MiniKongTest {

    private File testiT;

    @Before
    public void setUp() {
        testiT = new File("testiT.txt");
    }

    @Test
    public void placeholder() {
        assertNotNull(new Sovellus());
    }
}
