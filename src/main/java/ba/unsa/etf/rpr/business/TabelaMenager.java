package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.Exception.unosNijeIspravan;
import ba.unsa.etf.rpr.dao.TabelaDaoSQLImpl;
import ba.unsa.etf.rpr.dao.UcesnikDaoSQLImpl;
import ba.unsa.etf.rpr.domain.Tabela;
import ba.unsa.etf.rpr.domain.Ucesnik;

import java.util.List;

/**
 * Business Logic Layer za upravljanje tabelama
 */

public class TabelaMenager {

    /**
     * metoda vraća tabelu sa odgovarajućim id
     * baca izuzetak ako tabela ne postoji
     * @param id - id od željene tabele
     * @return Tabela
     */

    public Tabela getById(int id)
    {
        TabelaDaoSQLImpl tabelaDaoSQL = new TabelaDaoSQLImpl();
        List<Tabela> tabele = tabelaDaoSQL.getAll();

        boolean brojac = false;

        for(Tabela tabela: tabele)
        {
            if(tabela.getId() == id) brojac = true;
        }

        if(brojac == false) throw new unosNijeIspravan("Tabela ne postoji");

        return tabelaDaoSQL.getById(id);
    }

    /**
     * metoda briše odgovarajuću tabelu iz baze
     * baca izuzetak ako tabela ne postoji
     * @param id - id od tabele koja se želi obrisati
     */

    public void delete(int id)
    {
        TabelaDaoSQLImpl tabelaDaoSQL = new TabelaDaoSQLImpl();
        List<Tabela> tabele = tabelaDaoSQL.getAll();

        boolean brojac = false;

        for(Tabela tabela: tabele)
        {
            if(tabela.getId() == id) brojac = true;
        }

        if(brojac == false) throw new unosNijeIspravan("Tabela ne postoji");

        tabelaDaoSQL.delete(id);
    }

}
