package ba.unsa.etf.rpr.controller;

import ba.unsa.etf.rpr.dao.OdigranaKolaDaoSQLImpl;
import ba.unsa.etf.rpr.domain.OdigranaKola;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class kontroler4 implements Initializable {

    public ListView ListaSvihKola;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        OdigranaKolaDaoSQLImpl odigranaKolaDaoSQL = new OdigranaKolaDaoSQLImpl();
        List<OdigranaKola> lista = odigranaKolaDaoSQL.getAll();

        ListaSvihKola.getItems().addAll(lista);
    }
}
