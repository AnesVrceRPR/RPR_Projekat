package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.Exception.unosNijeIspravan;
import ba.unsa.etf.rpr.dao.UcesnikDaoSQLImpl;
import ba.unsa.etf.rpr.domain.Ucesnik;
import com.mysql.cj.protocol.a.UtilCalendarValueEncoder;

import java.util.List;

public class UcesnikManager {
    public Ucesnik add(Ucesnik ucesnik)
    {
        if(ucesnik.getRejting() <0 ) throw new unosNijeIspravan("Rejting ne može biti manji od 0");
        UcesnikDaoSQLImpl ucesnikDaoSQL = new UcesnikDaoSQLImpl();
        return ucesnikDaoSQL.add(ucesnik);
    }

    public Ucesnik update(Ucesnik ucesnik)
    {
        if(ucesnik.getRejting() <0 ) throw new unosNijeIspravan("Rejting ne može biti manji od 0");
        UcesnikDaoSQLImpl ucesnikDaoSQL = new UcesnikDaoSQLImpl();
        return ucesnikDaoSQL.update(ucesnik);
    }

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
