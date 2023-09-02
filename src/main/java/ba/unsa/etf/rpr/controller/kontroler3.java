package ba.unsa.etf.rpr.controller;

import ba.unsa.etf.rpr.dao.TabelaDaoSQLImpl;
import ba.unsa.etf.rpr.dao.UcesnikDaoSQLImpl;
import ba.unsa.etf.rpr.domain.Tabela;
import ba.unsa.etf.rpr.domain.Ucesnik;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

public class kontroler3 implements Initializable {
    public Label igrac3;
    public Label igrac1;
    public Label igrac5;
    public Label igrac7;
    public Label igrac2;
    public Label igrac4;
    public Label igrac6;
    public Label igrac8;
    public ListView tabela;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        UcesnikDaoSQLImpl ucesnikDaoSQL = new UcesnikDaoSQLImpl();
        List<Ucesnik> lista = ucesnikDaoSQL.getAll();

        Collections.sort(lista);

        TabelaDaoSQLImpl tabelaDaoSQLImpl = new TabelaDaoSQLImpl();
        Tabela tabela1 = tabelaDaoSQLImpl.getById(0);

        igrac1.setText(tabela1.getMjesto1());
        igrac2.setText(tabela1.getMjesto2());
        igrac3.setText(tabela1.getMjesto3());
        igrac4.setText(tabela1.getMjesto4());
        igrac5.setText(tabela1.getMjesto5());
        igrac6.setText(tabela1.getMjesto6());
        igrac7.setText(tabela1.getMjesto7());
        igrac8.setText(tabela1.getMjesto8());

        tabela.getItems().addAll(lista);
    }

    public void azurirajTabelu(ActionEvent actionEvent) {





        UcesnikDaoSQLImpl ucesnikDaoSQL = new UcesnikDaoSQLImpl();
        List<Ucesnik> lista = ucesnikDaoSQL.getAll();

        Collections.sort(lista);

        Tabela tabela1 = new Tabela();
        tabela1.setMjesto1(lista.get(0).getIme_i_Prezime());
        tabela1.setMjesto2(lista.get(1).getIme_i_Prezime());
        tabela1.setMjesto3(lista.get(2).getIme_i_Prezime());
        tabela1.setMjesto4(lista.get(3).getIme_i_Prezime());
        tabela1.setMjesto5(lista.get(4).getIme_i_Prezime());
        tabela1.setMjesto6(lista.get(5).getIme_i_Prezime());
        tabela1.setMjesto7(lista.get(6).getIme_i_Prezime());
        tabela1.setMjesto8(lista.get(7).getIme_i_Prezime());

        TabelaDaoSQLImpl tabelaDaoSQL = new TabelaDaoSQLImpl();
        tabelaDaoSQL.update(tabela1);

        tabela.getItems().addAll(lista);



    }
}
