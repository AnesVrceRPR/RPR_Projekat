package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.business.UcesnikManager;
import ba.unsa.etf.rpr.controller.Kontroler3;
import ba.unsa.etf.rpr.domain.Ucesnik;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UcesnikManagerTest {

    @Test
    public void rejtingManjiOd0Test1() {
        Ucesnik ucesnik = new Ucesnik();
        ucesnik.setImeIPrezime("anes");
        ucesnik.setRejting(-2);
        ucesnik.setBrojOsvojenihBodova(2.);

        UcesnikManager ucesnikManager = new UcesnikManager();
        Exception e = assertThrows(RuntimeException.class, () -> ucesnikManager.add(ucesnik));
        assertTrue(e.getMessage().contains("Rejting ne može biti manji od 0"));
    }

    @Test
    public void rejtingManjiOd0Test2() {
        Ucesnik ucesnik = new Ucesnik();
        ucesnik.setImeIPrezime("anes");
        ucesnik.setRejting(-2);
        ucesnik.setBrojOsvojenihBodova(2.);

        UcesnikManager ucesnikManager = new UcesnikManager();
        Exception e = assertThrows(RuntimeException.class, () -> ucesnikManager.update(ucesnik));
        assertTrue(e.getMessage().contains("Rejting ne može biti manji od 0"));
    }

    @Test
    public void ProvjeriUnosRezultata()
    {
        Kontroler3 kontroler3 = new Kontroler3();

        Exception e = assertThrows(RuntimeException.class, () -> kontroler3.provjeriRezultate("f"));
        assertTrue(e.getMessage().contains("Potrebno je unijeti 0 ili 1"));
    }

}
