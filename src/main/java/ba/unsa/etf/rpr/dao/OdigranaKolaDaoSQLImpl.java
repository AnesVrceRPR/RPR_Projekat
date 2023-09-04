package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.OdigranaKola;
import ba.unsa.etf.rpr.domain.Tabela;

import java.sql.*;

public class OdigranaKolaDaoSQLImpl implements OdigranaKolaDao {

    private Connection connection;

    public OdigranaKolaDaoSQLImpl(){
        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://sql.freedb.tech:3306/freedb_RPRbaza1","freedb_avrce1", "sUf2N#3?An58!@h");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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
                odigranaKola.setIgr1(rs.getDouble("Bodovi2"));
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

    @Override
    public OdigranaKola add(OdigranaKola odigranaKola) {
        String insert = "INSERT INTO OdigranaKola(Bodovi1,Igrac1,Igrac2,Bodovi2) VALUES(?, ?, ?, ?)";
        try{
            PreparedStatement stmt = this.connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);

            stmt.setDouble(1, odigranaKola.getIgr1());
            stmt.setString(2, odigranaKola.getIgrac1());ž
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


}
