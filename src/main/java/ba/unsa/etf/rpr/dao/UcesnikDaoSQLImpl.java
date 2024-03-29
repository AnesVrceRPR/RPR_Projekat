package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Ucesnik;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Implementacija Dao
 */


public class UcesnikDaoSQLImpl implements UcesnikDao {

    private Connection connection;

    /**
     * Uspostavljanje konekcije
     */

    public UcesnikDaoSQLImpl(){
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
     * metoda vraća ušesnika sa odgovarajućim id
     * @param id - id od željenog učesnika
     * @return Ucesnik
     */


    @Override
    public Ucesnik getById(int id) {
        String query = "SELECT * FROM Ucesnik WHERE id = ?";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) { // result set is iterator.
                Ucesnik ucesnik = new Ucesnik();
                ucesnik.setId(rs.getInt("id"));
                ucesnik.setImeIPrezime(rs.getString("Ime_i_Prezime"));
                ucesnik.setRejting(rs.getInt("Rejting"));
                rs.close();
                return ucesnik;
            } else {
                return null; // if there is no elements in the result set return null
            }
        } catch (SQLException e) {
            e.printStackTrace(); // poor error handling
        }
        return null;
    }

    /**
     * metoda dodaje ucesnika u bazu
     * @param ucesnik- ucesnik koji se želi dodati u bazu
     * @return Ucesnik
     */

    @Override
    public Ucesnik add(Ucesnik ucesnik) {
        String insert = "INSERT INTO Ucesnik(Ime_i_Prezime, Rejting, Broj_Osvojenih_Bodova) VALUES(?, ?, ?)";
        try{
            PreparedStatement stmt = this.connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, ucesnik.getImeIPrezime());
            stmt.setInt(2, ucesnik.getRejting());
            stmt.setDouble(3, ucesnik.getBrojOsvojenihBodova());

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            rs.next(); // we know that there is one key
            ucesnik.setId(rs.getInt(1)); //set id to return it back

            return ucesnik;
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * metoda update-uje ucesnika u bazi ucesnikom dodijeljenog parametrom
     * @param ucesnik - ucesnik koji se želi update-ovati
     * @return Ucesnik
     */

    @Override
    public Ucesnik update(Ucesnik ucesnik) {
        String update = "UPDATE Ucesnik SET Ime_i_Prezime = ?, Rejting = ?, Broj_Osvojenih_Bodova = ? WHERE id = ?";
        try{
            PreparedStatement stmt = this.connection.prepareStatement(update, Statement.RETURN_GENERATED_KEYS);
            stmt.setObject(1, ucesnik.getImeIPrezime());
            stmt.setObject(2, ucesnik.getRejting());
            stmt.setObject(3, ucesnik.getBrojOsvojenihBodova());
            stmt.setObject(4, ucesnik.getId());
            stmt.executeUpdate();
            return ucesnik;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * metoda briše odgovarajućeg ucesnika iz baze
     * @param id - id od ucesnika koji se želi obrisati
     */

    public void delete(int id) {
        String delete = "DELETE FROM Ucesnik WHERE id = ?";
        try{
            PreparedStatement stmt = this.connection.prepareStatement(delete, Statement.RETURN_GENERATED_KEYS);
            stmt.setObject(1, id);
            stmt.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * metoda vraća sve ucesnike iz baze
     * @return List<Ucesnik> </>-Lista svih ucesnika iz baze
     */

    @Override
    public List<Ucesnik> getAll() {
        String query = "SELECT * FROM Ucesnik";
        List<Ucesnik> ucesnici = new ArrayList<Ucesnik>();
        try{
            PreparedStatement stmt = this.connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){ // result set is iterator.
                Ucesnik ucesnik = new Ucesnik();
                ucesnik.setId(rs.getInt("id"));
                ucesnik.setImeIPrezime(rs.getString("Ime_i_Prezime"));
                ucesnik.setRejting(rs.getInt("Rejting"));
                ucesnik.setBrojOsvojenihBodova(rs.getDouble("Broj_Osvojenih_Bodova"));
                ucesnici.add(ucesnik);
            }
            rs.close();
        }
        catch (SQLException e){
            e.printStackTrace(); // poor error handling
        }
        return ucesnici;
    }

}