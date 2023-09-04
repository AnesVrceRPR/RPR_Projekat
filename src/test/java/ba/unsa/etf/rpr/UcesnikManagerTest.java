package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.business.UcesnikManager;
import ba.unsa.etf.rpr.controller.Kontroler3;
import ba.unsa.etf.rpr.dao.UcesnikDaoSQLImpl;
import ba.unsa.etf.rpr.domain.Ucesnik;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UcesnikManagerTest {

    private UcesnikManager ucesnikManager;
    private Ucesnik ucesnik;
    private UcesnikDaoSQLImpl ucesnikDaoSQLMock;
    private List<Ucesnik> ucesnici;

    @BeforeEach
    public void InicijalizacijaObjekata()
    {
        ucesnikManager = Mockito.mock(UcesnikManager.class);


    }

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

}
