package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Ucesnik;

import java.sql.*;

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


}