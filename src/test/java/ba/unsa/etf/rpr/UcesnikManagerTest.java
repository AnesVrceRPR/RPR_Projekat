package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.business.UcesnikManager;
import ba.unsa.etf.rpr.controller.Kontroler3;
import ba.unsa.etf.rpr.dao.UcesnikDaoSQLImpl;
import ba.unsa.etf.rpr.domain.Ucesnik;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
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
        ucesnik = new Ucesnik();
        ucesnik.setId(1);
        ucesnik.setRejting(2666);
        ucesnik.setBrojOsvojenihBodova(3.);

        ucesnikDaoSQLMock = Mockito.mock(UcesnikDaoSQLImpl.class);
        ucesnici = new ArrayList<>();
        ucesnici.addAll(Arrays.asList(new Ucesnik(2, "isam", 1000, 2.), new Ucesnik(3, "isam", 1000, 2.)));
    }

    @Test
    void provjeraDelete(){
        try {
            Mockito.doCallRealMethod().when(ucesnikManager).delete(1);
        }catch(Exception e)
        {
            assertTrue(e.getMessage().contains("Rejting ne može biti manji od 0"));
        }
    }





   /* @Test
    void rejtingManjiOd0Test1() {
        Ucesnik ucesnik1 = new Ucesnik();
        ucesnik1.setImeIPrezime("anes");
        ucesnik1.setRejting(-2);
        ucesnik1.setBrojOsvojenihBodova(2.);

        UcesnikManager ucesnikManager = new UcesnikManager();
        Exception e = assertThrows(RuntimeException.class, () -> ucesnikManager.add(ucesnik1));
        assertTrue(e.getMessage().contains("Rejting ne može biti manji od 0"));
    }

    @Test
    public void rejtingManjiOd0Test2() {
        Ucesnik ucesnik1 = new Ucesnik();
        ucesnik1.setImeIPrezime("anes");
        ucesnik1.setRejting(-2);
        ucesnik1.setBrojOsvojenihBodova(2.);

        UcesnikManager ucesnikManager = new UcesnikManager();
        Exception e = assertThrows(RuntimeException.class, () -> ucesnikManager.update(ucesnik1));
        assertTrue(e.getMessage().contains("Rejting ne može biti manji od 0"));
    }
*/
}
