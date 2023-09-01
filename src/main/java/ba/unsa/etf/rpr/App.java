package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.dao.UcesnikDaoSQLImpl;
import ba.unsa.etf.rpr.domain.Ucesnik;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Ucesnik ucesnik = new Ucesnik();
        ucesnik.setIme_i_Prezime("anes");
        ucesnik.setId(3);
        ucesnik.setRejting(1900);
        ucesnik.setBroj_Osvojenih_Bodova(0);

        UcesnikDaoSQLImpl ucesnikDaoSQL = new UcesnikDaoSQLImpl();
        ucesnikDaoSQL.update(ucesnik);

    }
}
