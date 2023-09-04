package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.OdigranaKola;
import ba.unsa.etf.rpr.domain.Tabela;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Implementacija Dao
 */

public class OdigranaKolaDaoSQLImpl implements OdigranaKolaDao {

    private Connection connection;

    /**
     * Uspostavljanje konekcije
     */

    public OdigranaKolaDaoSQLImpl(){
        try {
            Properties p = new Properties();
            p.load(ClassLoader.getSystemResource("application.properties").openStream());
            String url = p.getProperty("db.connection_string");
            String username = p.getProperty("db.username");
            String password = p.getProperty("db.password");
            this.connection = DriverManager.getConnection(url,username,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * metoda vraća odigrano kolo sa odgovarajućim id
     * @param id - id od željenog kola
     * @return OdigranaKola
     */

    @Override
    public OdigranaKola getById(int id) {
        String query = "SELECT * FROM OdigranaKola WHERE id = ?";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) { // result set is iterator.
                OdigranaKola odigranaKola = new OdigranaKola();
                odigranaKola.setId(rs.getInt("id"));
                odigranaKola.setIgr1(rs.getDouble("Bodovi1"));
                odigranaKola.setIgrac1(rs.getString("Igrac1"));
                odigranaKola.setIgrac2(rs.getString("Igrac2"));
                odigranaKola.setIgr2(rs.getDouble("Bodovi2"));
                rs.close();
                return odigranaKola;
            } else {
                return null; // if there is no elements in the result set return null
            }
        } catch (SQLException e) {
            e.printStackTrace(); // poor error handling
        }
        return null;
    }

    /**
     * metoda dodaje odigrano kolo u tabelu
     * @param odigranaKola - kolo koje se želi dodati u tabelu
     * @return OdigranaKola
     */

    @Override
    public OdigranaKola add(OdigranaKola odigranaKola) {
        String insert = "INSERT INTO OdigranaKola(Bodovi1,Igrac1,Igrac2,Bodovi2) VALUES(?, ?, ?, ?)";
        try{
            PreparedStatement stmt = this.connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);

            stmt.setDouble(1, odigranaKola.getIgr1());
            stmt.setString(2, odigranaKola.getIgrac1());
            stmt.setString(3, odigranaKola.getIgrac2());
            stmt.setDouble(4, odigranaKola.getIgr2());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            rs.next(); // we know that there is one key
            odigranaKola.setId(rs.getInt(1)); //set id to return it back

            return odigranaKola;
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * metoda update-uje kolo u tabeli kolom dodijeljenim parametrom
     * @param odigranaKola - odigrano kolo koje se želi update-ovati
     * @return OdigranaKola
     */

    @Override
    public OdigranaKola update(OdigranaKola odigranaKola) {
        String update = "UPDATE OdigranaKola SET Bodovi1 = ?, Igrac1 = ?, Igrac2 = ?, Bodovi2 = ? WHERE id = ?";
        try{
            PreparedStatement stmt = this.connection.prepareStatement(update, Statement.RETURN_GENERATED_KEYS);
            stmt.setObject(1, odigranaKola.getIgr1());
            stmt.setObject(2, odigranaKola.getIgrac1());
            stmt.setObject(3, odigranaKola.getIgrac2());
            stmt.setObject(4, odigranaKola.getIgr2());
            stmt.setObject(5, odigranaKola.getId());
            stmt.executeUpdate();
            return odigranaKola;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * metoda briše odgovarajuće odigrano kolo iz tabele
     * @param id - id od kola koje se želi obrisati
     */

    public void delete(int id) {
        String delete = "DELETE FROM OdigranaKola WHERE id = ?";
        try{
            PreparedStatement stmt = this.connection.prepareStatement(delete, Statement.RETURN_GENERATED_KEYS);
            stmt.setObject(1, id);
            stmt.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * metoda vraća sva odigrana kola iz tabele
     * @return OdigranaKola-Lista svih odigranih kola
     */

    @Override
    public List<OdigranaKola> getAll() {
        String query = "SELECT * FROM OdigranaKola";
        List<OdigranaKola> odigranaKolas = new ArrayList<OdigranaKola>();
        try{
            PreparedStatement stmt = this.connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){ // result set is iterator.
                OdigranaKola odigranaKola = new OdigranaKola();
                odigranaKola.setId(rs.getInt("id"));

                odigranaKola.setIgr1(rs.getDouble("Bodovi1"));
                odigranaKola.setIgrac1(rs.getString("Igrac1"));
                odigranaKola.setIgrac2(rs.getString("Igrac2"));
                odigranaKola.setIgr2(rs.getDouble("Bodovi2"));
                odigranaKolas.add(odigranaKola);
            }
            rs.close();
        }
        catch (SQLException e){
            e.printStackTrace(); // poor error handling
        }
        return odigranaKolas;
    }
}
