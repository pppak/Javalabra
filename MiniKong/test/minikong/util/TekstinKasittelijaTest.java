package minikong.util;

import java.io.File;
import minikong.domain.TekstinTiedot;
import static org.junit.Assert.*;
import org.junit.Test;

public class TekstinKasittelijaTest {
    
    public TekstinKasittelijaTest() {
    }
    
    @Test
    public void tekstinKasittely(){
        File testiTeksti = new File("testiT.txt");
        Lukija lukija = new Lukija(testiTeksti);
        TekstinTiedot tt = new TekstinTiedot();
        TekstinKasittelija tk = new TekstinKasittelija(tt, lukija);
        tk.kasittele();
        assertNotNull(tt);
        assertTrue(tt.sanaListattu("vihreä"));
    }
}