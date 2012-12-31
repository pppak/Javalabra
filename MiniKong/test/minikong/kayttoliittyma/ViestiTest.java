package minikong.kayttoliittyma;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ViestiTest {
    
    Viesti viesti;
    
    @Before
    public void setUp() {
        viesti = new Viesti("testi", "testitesti", 100, 100);
    }
    
    
}
