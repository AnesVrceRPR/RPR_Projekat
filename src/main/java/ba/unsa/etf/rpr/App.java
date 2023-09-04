package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.dao.UcesnikDaoSQLImpl;
import ba.unsa.etf.rpr.domain.Ucesnik;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String izraz = new String(args[0]);
        Integer rejting = Integer.parseInt(args[1]);

        Ucesnik ucesnik = new Ucesnik();
        ucesnik.setBrojOsvojenihBodova(0.);
        ucesnik.setImeIPrezime(izraz);
        ucesnik.setRejting(rejting);

        UcesnikDaoSQLImpl ucesnikDaoSQL = new UcesnikDaoSQLImpl();
        ucesnikDaoSQL.add(ucesnik);
    }
}
