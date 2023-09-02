package ba.unsa.etf.rpr.controller;

import ba.unsa.etf.rpr.dao.UcesnikDaoSQLImpl;
import ba.unsa.etf.rpr.domain.Ucesnik;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class NoviKontroler implements Initializable {
    public ListView ListaImena;

    public Button PotvrdiDodavanje;
    public TextField label1;
    public TextField label2;
    public Button potvrdiBrisanje;
    public TextField label3;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        UcesnikDaoSQLImpl ucesnikDaoSQL = new UcesnikDaoSQLImpl();
        ListaImena.getItems().addAll(ucesnikDaoSQL.getAll());
    }

    public void dodajIgraca(ActionEvent actionEvent) {
        Ucesnik ucesnik = new Ucesnik();
        ucesnik.setIme_i_Prezime(label1.getText());
        ucesnik.setRejting(Integer.parseInt(label2.getText()));

        UcesnikDaoSQLImpl ucesnikDaoSQL = new UcesnikDaoSQLImpl();
        ucesnikDaoSQL.add(ucesnik);

        ListaImena.getItems().add(ucesnik);
    }


}
