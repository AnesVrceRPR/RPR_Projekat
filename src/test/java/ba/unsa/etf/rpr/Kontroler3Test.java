package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.controller.Kontroler3;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Kontroler3Test {

    @Test
    public void ProvjeriUnosRezultataTest1()
    {
        Kontroler3 kontroler3 = new Kontroler3();

        Exception e = assertThrows(RuntimeException.class, () -> kontroler3.provjeriRezultate("f"));
        assertTrue(e.getMessage().contains("Potrebno je unijeti 0 ili 1"));
    }

    @Test
    public void ProvjeriUnosRezultataTest2()
    {
        Kontroler3 kontroler3 = new Kontroler3();

        Exception e = assertThrows(RuntimeException.class, () -> kontroler3.provjeriRezultate("4"));
        assertTrue(e.getMessage().contains("Potrebno je unijeti 0 ili 1"));
    }

}
