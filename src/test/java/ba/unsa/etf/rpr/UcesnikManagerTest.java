package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.business.UcesnikManager;
import ba.unsa.etf.rpr.domain.Ucesnik;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UcesnikManagerTest {

    @Test
    public void rejtingManjiOd0()
    {
        Ucesnik ucesnik = new Ucesnik();
        ucesnik.setImeIPrezime("anes");
        ucesnik.setRejting(-2);
        ucesnik.setBrojOsvojenihBodova(2.);

        UcesnikManager ucesnikManager = new UcesnikManager();
        Exception e = assertThrows(RuntimeException.class, ()-> ucesnikManager.add(ucesnik));
        assertTrue(e.getMessage().contains("Rejting ne može biti manji od 0"));
    }

}
