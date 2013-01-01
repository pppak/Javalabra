package minikong;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SovellusTest {
    
    
    @Before
    public void setUp() {
    }
    
    @Test
    public void sovellus(){
        Sovellus s = new Sovellus();
        s.suorita();
    }
}