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
}
