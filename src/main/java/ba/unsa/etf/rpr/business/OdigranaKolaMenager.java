package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.Exception.unosNijeIspravan;
import ba.unsa.etf.rpr.dao.OdigranaKolaDao;
import ba.unsa.etf.rpr.dao.OdigranaKolaDaoSQLImpl;
import ba.unsa.etf.rpr.dao.TabelaDaoSQLImpl;
import ba.unsa.etf.rpr.domain.OdigranaKola;
import ba.unsa.etf.rpr.domain.Tabela;

import java.util.List;

/**
 * Business Logic Layer za upravljanje odigranim kolima
 */

public class OdigranaKolaMenager {

    /**
     * metoda vraća odigrano kolo iz baze sa odgovarajućim id
     * baca izuzetak ako kolo ne postoji
     * @param id - id od željenog kola
     * @return OdigranaKola
     */
    public OdigranaKola getById(int id)
    {
        OdigranaKolaDaoSQLImpl odigranaKolaDaoSQL = new OdigranaKolaDaoSQLImpl();
        List<OdigranaKola> odigranaKolas = odigranaKolaDaoSQL.getAll();

        boolean brojac = false;

        for(OdigranaKola odigranaKola: odigranaKolas)
        {
            if(odigranaKola.getId() == id) brojac = true;
        }

        if(brojac == false) throw new unosNijeIspravan("Tabela ne postoji");

        return odigranaKolaDaoSQL.getById(id);
    }

    /**
     * metoda briše odgovarajuće odigrano kolo iz baze
     * baca izuzetak ako kolo ne postoji
     * @param id - id od kola koje se želi obrisati
     */
    public void delete(int id)
    {
        OdigranaKolaDaoSQLImpl odigranaKolaDaoSQL = new OdigranaKolaDaoSQLImpl();
        List<OdigranaKola> odigranaKolas = odigranaKolaDaoSQL.getAll();

        boolean brojac = false;

        for(OdigranaKola odigranaKola: odigranaKolas)
        {
            if(odigranaKola.getId() == id) brojac = true;
        }

        if(brojac == false) throw new unosNijeIspravan("Tabela ne postoji");

        odigranaKolaDaoSQL.delete(id);
    }

}
