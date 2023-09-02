package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Tabela;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TabelaDaoSQLImpl implements TabelaDao {
    private Connection connection;

    public TabelaDaoSQLImpl(){
        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://sql.freedb.tech:3306/freedb_RPRbaza1","freedb_avrce1", "sUf2N#3?An58!@h");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Tabela getById(int id) {
        String query = "SELECT * FROM Tabela WHERE id = ?";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) { // result set is iterator.
                Tabela tabela = new Tabela();
                tabela.setId(rs.getInt("id"));
                tabela.setMjesto1(rs.getString("Mjesto1"));
                tabela.setMjesto2(rs.getString("Mjesto2"));
                tabela.setMjesto3(rs.getString("Mjesto3"));
                tabela.setMjesto4(rs.getString("Mjesto4"));
                tabela.setMjesto1(rs.getString("Mjesto5"));
                tabela.setMjesto1(rs.getString("Mjesto6"));
                tabela.setMjesto1(rs.getString("Mjesto7"));
                tabela.setMjesto1(rs.getString("Mjesto8"));
                rs.close();
                return tabela;
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
            stmt.setString(1, tabela.getMjesto2());
            stmt.setString(1, tabela.getMjesto3());
            stmt.setString(1, tabela.getMjesto4());
            stmt.setString(1, tabela.getMjesto5());
            stmt.setString(1, tabela.getMjesto6());
            stmt.setString(1, tabela.getMjesto7());
            stmt.setString(1, tabela.getMjesto8());

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

    @Override
    public Tabela update(Tabela tabela) {
        String update = "UPDATE Tabela SET Mjesto1 = ?, Mjesto2 = ?, Mjesto3 = ?, Mjesto4 = ?, Mjesto5 = ?, Mjesto6 = ?, Mjesto7 = ?, Mjesto1 = 8 WHERE id = ?";
        try{
            PreparedStatement stmt = this.connection.prepareStatement(update, Statement.RETURN_GENERATED_KEYS);
            stmt.setObject(1, tabela.getMjesto1());
            stmt.setObject(2, tabela.getMjesto2());
            stmt.setObject(3, tabela.getMjesto3());
            stmt.setObject(4, tabela.getMjesto4());
            stmt.setObject(5, tabela.getMjesto5());
            stmt.setObject(6, tabela.getMjesto6());
            stmt.setObject(7, tabela.getMjesto7());
            stmt.setObject(8, tabela.getMjesto8());
            stmt.setObject(9, tabela.getId());
            stmt.executeUpdate();
            return tabela;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void delete(int id) {
        String delete = "DELETE FROM Tabela WHERE id = ?";
        try{
            PreparedStatement stmt = this.connection.prepareStatement(delete, Statement.RETURN_GENERATED_KEYS);
            stmt.setObject(1, id);
            stmt.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Tabela> getAll() {
        String query = "SELECT * FROM Tabela";
        List<Tabela> tabele = new ArrayList<Tabela>();
        try{
            PreparedStatement stmt = this.connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){ // result set is iterator.
                Tabela tabela = new Tabela();
                tabela.setId(rs.getInt("id"));
                tabela.setMjesto1(rs.getString("Mjesto1"));
                tabela.setMjesto1(rs.getString("Mjesto1"));
                tabele.add(tabela);
            }
            rs.close();
        }
        catch (SQLException e){
            e.printStackTrace(); // poor error handling
        }
        return tabele;
    }
}
