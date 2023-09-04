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
    public Tabela add(Tabela tabela) {
        String insert = "INSERT INTO Tabela(Mjesto1,Mjesto2,Mjesto3,Mjesto4,Mjesto5,Mjesto6,Mjesto7,Mjesto8) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        try{
            PreparedStatement stmt = this.connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, tabela.getMjesto1());
            stmt.setString(2, tabela.getMjesto2());
            stmt.setString(3, tabela.getMjesto3());
            stmt.setString(4, tabela.getMjesto4());
            stmt.setString(5, tabela.getMjesto5());
            stmt.setString(6, tabela.getMjesto6());
            stmt.setString(7, tabela.getMjesto7());
            stmt.setString(8, tabela.getMjesto8());

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            rs.next(); // we know that there is one key
            tabela.setId(rs.getInt(1)); //set id to return it back

            return tabela;
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }


}
