package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.Exception.unosNijeIspravan;
import ba.unsa.etf.rpr.dao.UcesnikDaoSQLImpl;
import ba.unsa.etf.rpr.domain.Ucesnik;
import com.mysql.cj.protocol.a.UtilCalendarValueEncoder;

/**
 * Business Logic Layer za upravljanje ucesnicima
 */


import java.util.List;

public class UcesnikManager {


    /**
     * metoda dodaje ucesnika u bazu
     * baca izuzetak ako je rejting manji od 0
     * @param ucesnik- ucesnik koji se želi dodati u bazu
     * @return Ucesnik
     */

    public Ucesnik add(Ucesnik ucesnik)
    {
        if(ucesnik.getRejting() <0 ) throw new unosNijeIspravan("Rejting ne može biti manji od 0");
        UcesnikDaoSQLImpl ucesnikDaoSQL = new UcesnikDaoSQLImpl();
        return ucesnikDaoSQL.add(ucesnik);
    }

    /**
     * metoda update-uje ucesnika u bazi ucesnikom dodijeljenog parametrom
     * baca izuzetak ako je rejting manji od 0
     * @param ucesnik - ucesnik koji se želi update-ovati
     * @return Ucesnik
     */

    public Ucesnik update(Ucesnik ucesnik)
    {
        if(ucesnik.getRejting() <0 ) throw new unosNijeIspravan("Rejting ne može biti manji od 0");
        UcesnikDaoSQLImpl ucesnikDaoSQL = new UcesnikDaoSQLImpl();
        return ucesnikDaoSQL.update(ucesnik);
    }

    /**
     * metoda vraća ušesnika sa odgovarajućim id
     * baca izuzetak ako koristnik ne postoji
     * @param id - id od željenog učesnika
     * @return Ucesnik
     */


    public Ucesnik getById(int id)
    {
        UcesnikDaoSQLImpl ucesnikDaoSQL = new UcesnikDaoSQLImpl();
        List<Ucesnik> lista =  ucesnikDaoSQL.getAll();

        boolean brojac = false;

        for(Ucesnik ucesnik : lista)
        {
            if(ucesnik.getId() == id) brojac = true;
        }

        if(brojac == false) throw new unosNijeIspravan("Korisnik ne postoji");

        return ucesnikDaoSQL.getById(id);
    }

    /**
     * metoda briše odgovarajućeg ucesnika iz baze
     * baca izuzetak ako korisnik ne postoji
     * @param id - id od ucesnika koji se želi obrisati
     */

    public void delete(int id)
    {
        UcesnikDaoSQLImpl ucesnikDaoSQL = new UcesnikDaoSQLImpl();
        List<Ucesnik> lista =  ucesnikDaoSQL.getAll();

        boolean brojac = false;

        for(Ucesnik ucesnik : lista)
        {
            if(ucesnik.getId() == id) brojac = true;
        }

        if(brojac == false) throw new unosNijeIspravan("Korisnik ne postoji");

        ucesnikDaoSQL.delete(id);
    }
}
