package ba.unsa.etf.rpr.controller;

import ba.unsa.etf.rpr.dao.TabelaDaoSQLImpl;
import ba.unsa.etf.rpr.dao.UcesnikDaoSQLImpl;
import ba.unsa.etf.rpr.domain.Tabela;
import ba.unsa.etf.rpr.domain.Ucesnik;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

public class kontroler2 implements Initializable {
    public ListView ListaImena;

    public Button PotvrdiDodavanje;
    public TextField label1;
    public TextField label2;
    public Button potvrdiBrisanje;
    public TextField label3;
    public Button Nastavi;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        UcesnikDaoSQLImpl ucesnikDaoSQL = new UcesnikDaoSQLImpl();
        ListaImena.getItems().addAll(ucesnikDaoSQL.getAll());
    }

    public void dodajIgraca(ActionEvent actionEvent) {
        Ucesnik ucesnik = new Ucesnik();
        ucesnik.setIme_i_Prezime(label1.getText());
        ucesnik.setRejting(Integer.parseInt(label2.getText()));
        ucesnik.setBroj_Osvojenih_Bodova(0.);

        UcesnikDaoSQLImpl ucesnikDaoSQL = new UcesnikDaoSQLImpl();
        ucesnikDaoSQL.add(ucesnik);

        ListaImena.getItems().add(ucesnik);
    }

    public void obrisiIgraca(ActionEvent actionEvent) {
        UcesnikDaoSQLImpl ucesnikDaoSQL = new UcesnikDaoSQLImpl();
        List<Ucesnik> lista = ucesnikDaoSQL.getAll();

        int id = 0;
        Ucesnik obrisani = new Ucesnik();

        for(Ucesnik ucesnik : lista)
        {
            if(ucesnik.getIme_i_Prezime().equals(label3.getText()))
            {
                obrisani = ucesnik;
                id = ucesnik.getId();
            }
        }

        ucesnikDaoSQL.delete(id);

        ListaImena.getItems().remove(obrisani);
    }

    public void OtvoriNoviProzor(ActionEvent actionEvent) throws IOException {
        UcesnikDaoSQLImpl ucesnikDaoSQL = new UcesnikDaoSQLImpl();
        List<Ucesnik> lista = ucesnikDaoSQL.getAll();

        Collections.sort(lista);

        Tabela tabela = new Tabela();
        tabela.setMjesto1(lista.get(0).getIme_i_Prezime());
        tabela.setMjesto2(lista.get(1).getIme_i_Prezime());
        tabela.setMjesto3(lista.get(2).getIme_i_Prezime());
        tabela.setMjesto4(lista.get(3).getIme_i_Prezime());
        tabela.setMjesto5(lista.get(4).getIme_i_Prezime());
        tabela.setMjesto6(lista.get(5).getIme_i_Prezime());
        tabela.setMjesto7(lista.get(6).getIme_i_Prezime());
        tabela.setMjesto8(lista.get(7).getIme_i_Prezime());

        TabelaDaoSQLImpl tabelaDaoSQL = new TabelaDaoSQLImpl();
        tabelaDaoSQL.update(tabela);

        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Prozor3.fxml"));
        stage.setTitle("Dobrodošli");
        stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stage.show();

    }
}
