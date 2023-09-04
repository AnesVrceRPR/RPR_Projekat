package ba.unsa.etf.rpr.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class OdigranaKolaDaoSQLImpl implements OdigranaKolaDao {

    private Connection connection;

    public OdigranaKolaDaoSQLImpl(){
        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://sql.freedb.tech:3306/freedb_RPRbaza1","freedb_avrce1", "sUf2N#3?An58!@h");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }





}
