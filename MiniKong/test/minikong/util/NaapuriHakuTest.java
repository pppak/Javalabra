package minikong.util;

import minikong.domain.TekstinTiedot;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class NaapuriHakuTest {
    
   NaapuriHaku nh;
   TekstinTiedot tt;
   
    @Before
    public void setUp() {
           tt = new TekstinTiedot();
           TekstinKasittelija tk = new TekstinKasittelija(tt, "hullut tykkää puurosta");
           tk.kasittele();
           nh = new NaapuriHaku(tt, 1, "tykkää");
    }
    
    @Test
    public void tulostusToimii(){
        assertEquals("Haettu sana: tykkää\nSana esiintyy tekstissä 1 kertaa\nYleisimmät naapurisanat "
                + "vasemmalla: \nhullut (1)\nYleisimmät naapurisanat oikealla: "
                + "\npuurosta (1)\n***\n", nh.tee());
    }

    @Test
    public void tyhjäTekstiEiPalautaOmiaan(){
        nh = new NaapuriHaku(new TekstinTiedot(), 2, "testi");
        assertEquals("Valitse ensin teksti josta sanaa etsitään! \n", nh.tee());
    }

    @Test
    public void tyhjäEiLöydy(){
        nh = new NaapuriHaku(tt, 1, "");
        assertEquals("Sanaa '' ei löydy tekstistä.\n", nh.tee());
    }
    
    @Test
    public void olematonTulostaaOikein(){
        nh = new NaapuriHaku(tt, 1, "pullo");
        assertEquals("Sanaa 'pullo' ei löydy tekstistä.\n" , nh.tee());
    }   
}