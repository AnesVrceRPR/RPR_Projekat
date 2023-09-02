package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Ucesnik;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UcesnikDaoSQLImpl implements UcesnikDao {

    private Connection connection;

    public UcesnikDaoSQLImpl(){
        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://sql.freedb.tech:3306/freedb_RPRbaza1","freedb_avrce1", "sUf2N#3?An58!@h");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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
                ucesnik.setIme_i_Prezime(rs.getString("Ime_i_Prezime"));
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

    @Override
    public Ucesnik add(Ucesnik ucesnik) {
        String insert = "INSERT INTO Ucesnik(Ime_i_Prezime) VALUES(?)";
        try{
            PreparedStatement stmt = this.connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, ucesnik.getIme_i_Prezime());

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

    @Override
    public Ucesnik update(Ucesnik ucesnik) {
        String update = "UPDATE Ucesnik SET Ime_i_Prezime = ? WHERE id = ?";
        try{
            PreparedStatement stmt = this.connection.prepareStatement(update, Statement.RETURN_GENERATED_KEYS);
            stmt.setObject(1, ucesnik.getIme_i_Prezime());
            stmt.setObject(2, ucesnik.getId());
            stmt.executeUpdate();
            return ucesnik;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

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
                ucesnik.setIme_i_Prezime(rs.getString("Ime_i_Prezime"));
                ucesnik.setRejting(rs.getInt("Rejting"));
                ucesnik.setBroj_Osvojenih_Bodova(rs.getInt("Broj_Osvojenih_Bodova"));
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