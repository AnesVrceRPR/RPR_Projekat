package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Tabela;

import java.sql.*;

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
            stmt.setObject(1, tabela.getMjesto1());
            stmt.setObject(1, tabela.getMjesto1());
            stmt.setObject(2, tabela.getId());
            stmt.executeUpdate();
            return tabela;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
