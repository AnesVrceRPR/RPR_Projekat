package ba.unsa.etf.rpr.controller;

import ba.unsa.etf.rpr.dao.OdigranaKolaDaoSQLImpl;
import ba.unsa.etf.rpr.dao.TabelaDaoSQLImpl;
import ba.unsa.etf.rpr.dao.UcesnikDaoSQLImpl;
import ba.unsa.etf.rpr.domain.OdigranaKola;
import ba.unsa.etf.rpr.domain.Tabela;
import ba.unsa.etf.rpr.domain.Ucesnik;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

public class Kontroler4 implements Initializable {

    public ListView ListaSvihKola;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        OdigranaKolaDaoSQLImpl odigranaKolaDaoSQL = new OdigranaKolaDaoSQLImpl();
        List<OdigranaKola> lista = odigranaKolaDaoSQL.getAll();

        ListaSvihKola.getItems().addAll(lista);

    }
}
