package ba.unsa.etf.rpr.controller;

import ba.unsa.etf.rpr.Exception.unosNijeIspravan;
import ba.unsa.etf.rpr.business.TabelaMenager;
import ba.unsa.etf.rpr.dao.OdigranaKolaDaoSQLImpl;
import ba.unsa.etf.rpr.dao.TabelaDaoSQLImpl;
import ba.unsa.etf.rpr.dao.UcesnikDaoSQLImpl;
import ba.unsa.etf.rpr.domain.OdigranaKola;
import ba.unsa.etf.rpr.domain.Tabela;
import ba.unsa.etf.rpr.domain.Ucesnik;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

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
    public TextField igr2;
    public TextField igr4;
    public TextField igr6;
    public TextField igr8;
    public Button potvrda;
    public TextField igr1;
    public TextField igr3;
    public TextField igr5;
    public TextField igr7;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        UcesnikDaoSQLImpl ucesnikDaoSQL = new UcesnikDaoSQLImpl();
        List<Ucesnik> lista = ucesnikDaoSQL.getAll();

        Collections.sort(lista);

        TabelaMenager tabelaMenager = new TabelaMenager();
        Tabela tabela1 = tabelaMenager.getById(0);

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

    public Ucesnik PronadjiIgraca(String ime)
    {
        UcesnikDaoSQLImpl ucesnikDaoSQLImpl = new UcesnikDaoSQLImpl();
        List<Ucesnik> lista = ucesnikDaoSQLImpl.getAll();

        for(Ucesnik ucesnik : lista)
        {
            if(ucesnik.getImeIPrezime().equals(ime))
            {
                return ucesnik;
            }
        }

        return new Ucesnik();
    }

    public void provjeriRezultate()
    {
        try{
            Double.parseDouble(igr1.getText());
            Double.parseDouble(igr2.getText());
            Double.parseDouble(igr3.getText());
            Double.parseDouble(igr4.getText());
            Double.parseDouble(igr5.getText());
            Double.parseDouble(igr6.getText());
            Double.parseDouble(igr7.getText());
            Double.parseDouble(igr8.getText());

            if(Double.parseDouble(igr1.getText())!= 0 && Double.parseDouble(igr1.getText())!= 1) throw new Exception();
            if(Double.parseDouble(igr2.getText())!= 0 && Double.parseDouble(igr2.getText())!= 1) throw new Exception();
            if(Double.parseDouble(igr3.getText())!= 0 && Double.parseDouble(igr3.getText())!= 1) throw new Exception();
            if(Double.parseDouble(igr4.getText())!= 0 && Double.parseDouble(igr4.getText())!= 1) throw new Exception();
            if(Double.parseDouble(igr5.getText())!= 0 && Double.parseDouble(igr5.getText())!= 1) throw new Exception();
            if(Double.parseDouble(igr6.getText())!= 0 && Double.parseDouble(igr6.getText())!= 1) throw new Exception();
            if(Double.parseDouble(igr7.getText())!= 0 && Double.parseDouble(igr7.getText())!= 1) throw new Exception();
            if(Double.parseDouble(igr8.getText())!= 0 && Double.parseDouble(igr8.getText())!= 1) throw new Exception();
        }catch(Exception e)
        {
            throw new unosNijeIspravan("Potrebno je unijeti 0 ili 1");
        }
    }

    public void azurirajTabelu(ActionEvent actionEvent) {

        UcesnikDaoSQLImpl ucesnikDaoSQLImpl = new UcesnikDaoSQLImpl();
        List<Ucesnik> lista1 = ucesnikDaoSQLImpl.getAll();
        tabela.getItems().removeAll(lista1);

        Ucesnik ucesnik1 = new Ucesnik();
        Ucesnik ucesnik2 = new Ucesnik();
        Ucesnik ucesnik3 = new Ucesnik();
        Ucesnik ucesnik4 = new Ucesnik();
        Ucesnik ucesnik5 = new Ucesnik();
        Ucesnik ucesnik6 = new Ucesnik();
        Ucesnik ucesnik7 = new Ucesnik();
        Ucesnik ucesnik8 = new Ucesnik();

        if(Integer.parseInt(igr1.getText()) == 0 && Integer.parseInt(igr2.getText()) == 0)
        {
            ucesnik1 = PronadjiIgraca(igrac1.getText());
            ucesnik2 = PronadjiIgraca(igrac2.getText());
            ucesnik1.setBrojOsvojenihBodova(PronadjiIgraca(igrac1.getText()).getBrojOsvojenihBodova() + 0.5);
            ucesnik2.setBrojOsvojenihBodova(PronadjiIgraca(igrac2.getText()).getBrojOsvojenihBodova() + 0.5);
        }
        if(Integer.parseInt(igr1.getText()) == 1 && Integer.parseInt(igr2.getText()) == 0)
        {
            ucesnik1 = PronadjiIgraca(igrac1.getText());
            ucesnik1.setBrojOsvojenihBodova(PronadjiIgraca(igrac1.getText()).getBrojOsvojenihBodova() + 1);
            ucesnik1.setRejting(ucesnik1.getRejting() + 8);
        }
        if(Integer.parseInt(igr1.getText()) == 0 && Integer.parseInt(igr2.getText()) == 1)
        {
            ucesnik2 = PronadjiIgraca(igrac2.getText());
            ucesnik2.setBrojOsvojenihBodova(PronadjiIgraca(igrac2.getText()).getBrojOsvojenihBodova() + 1);
            ucesnik2.setRejting(ucesnik2.getRejting() + 8);
        }

        if(Integer.parseInt(igr3.getText()) == 0 && Integer.parseInt(igr4.getText()) == 0)
        {
            ucesnik3 = PronadjiIgraca(igrac3.getText());
            ucesnik3.setBrojOsvojenihBodova(PronadjiIgraca(igrac3.getText()).getBrojOsvojenihBodova() + 0.5);
            ucesnik4 = PronadjiIgraca(igrac4.getText());
            ucesnik4.setBrojOsvojenihBodova(PronadjiIgraca(igrac4.getText()).getBrojOsvojenihBodova() + 0.5);
        }
        if(Integer.parseInt(igr3.getText()) == 1 && Integer.parseInt(igr4.getText()) == 0)
        {
            ucesnik3 = PronadjiIgraca(igrac3.getText());
            ucesnik3.setBrojOsvojenihBodova(PronadjiIgraca(igrac3.getText()).getBrojOsvojenihBodova() + 1);
            ucesnik3.setRejting(ucesnik3.getRejting() + 8);
        }
        if(Integer.parseInt(igr3.getText()) == 0 && Integer.parseInt(igr4.getText()) == 1)
        {
            ucesnik4 = PronadjiIgraca(igrac4.getText());
            ucesnik4.setBrojOsvojenihBodova(PronadjiIgraca(igrac4.getText()).getBrojOsvojenihBodova() + 1);
            ucesnik4.setRejting(ucesnik4.getRejting() + 8);
        }

        if(Integer.parseInt(igr5.getText()) == 0 && Integer.parseInt(igr6.getText()) == 0)
        {
            ucesnik5 = PronadjiIgraca(igrac5.getText());
            ucesnik5.setBrojOsvojenihBodova(PronadjiIgraca(igrac5.getText()).getBrojOsvojenihBodova() + 0.5);
            ucesnik6 = PronadjiIgraca(igrac6.getText());
            ucesnik6.setBrojOsvojenihBodova(PronadjiIgraca(igrac6.getText()).getBrojOsvojenihBodova() + 0.5);
        }
        if(Integer.parseInt(igr5.getText()) == 1 && Integer.parseInt(igr6.getText()) == 0)
        {
            ucesnik5 = PronadjiIgraca(igrac5.getText());
            ucesnik5.setBrojOsvojenihBodova(PronadjiIgraca(igrac5.getText()).getBrojOsvojenihBodova() + 1);
            ucesnik5.setRejting(ucesnik5.getRejting() + 8);
        }
        if(Integer.parseInt(igr5.getText()) == 0 && Integer.parseInt(igr6.getText()) == 1)
        {
            ucesnik6 = PronadjiIgraca(igrac6.getText());
            ucesnik6.setBrojOsvojenihBodova(PronadjiIgraca(igrac6.getText()).getBrojOsvojenihBodova() + 1);
            ucesnik6.setRejting(ucesnik6.getRejting() + 8);
        }

        if(Integer.parseInt(igr7.getText()) == 0 && Integer.parseInt(igr8.getText()) == 0)
        {
            ucesnik7 = PronadjiIgraca(igrac7.getText());
            ucesnik7.setBrojOsvojenihBodova(PronadjiIgraca(igrac7.getText()).getBrojOsvojenihBodova() + 0.5);
            ucesnik8 = PronadjiIgraca(igrac8.getText());
            ucesnik8.setBrojOsvojenihBodova(PronadjiIgraca(igrac8.getText()).getBrojOsvojenihBodova() + 0.5);
        }
        if(Integer.parseInt(igr7.getText()) == 1 && Integer.parseInt(igr8.getText()) == 0)
        {
            ucesnik7 = PronadjiIgraca(igrac7.getText());
            ucesnik7.setBrojOsvojenihBodova(PronadjiIgraca(igrac7.getText()).getBrojOsvojenihBodova() + 1);
            ucesnik7.setRejting(ucesnik7.getRejting() + 8);
        }
        if(Integer.parseInt(igr7.getText()) == 0 && Integer.parseInt(igr8.getText()) == 1)
        {
            ucesnik8 = PronadjiIgraca(igrac8.getText());
            ucesnik8.setBrojOsvojenihBodova(PronadjiIgraca(igrac8.getText()).getBrojOsvojenihBodova() + 1);
            ucesnik8.setRejting(ucesnik8.getRejting() + 8);
        }

        ucesnikDaoSQLImpl.update(ucesnik1);
        ucesnikDaoSQLImpl.update(ucesnik2);
        ucesnikDaoSQLImpl.update(ucesnik3);
        ucesnikDaoSQLImpl.update(ucesnik4);
        ucesnikDaoSQLImpl.update(ucesnik5);
        ucesnikDaoSQLImpl.update(ucesnik6);
        ucesnikDaoSQLImpl.update(ucesnik7);
        ucesnikDaoSQLImpl.update(ucesnik8);

        List<Ucesnik> lista = ucesnikDaoSQLImpl.getAll();

        Collections.sort(lista);

        Tabela tabela1 = new Tabela();
        tabela1.setMjesto1(lista.get(0).getImeIPrezime());
        tabela1.setMjesto2(lista.get(1).getImeIPrezime());
        tabela1.setMjesto3(lista.get(2).getImeIPrezime());
        tabela1.setMjesto4(lista.get(3).getImeIPrezime());
        tabela1.setMjesto5(lista.get(4).getImeIPrezime());
        tabela1.setMjesto6(lista.get(5).getImeIPrezime());
        tabela1.setMjesto7(lista.get(6).getImeIPrezime());
        tabela1.setMjesto8(lista.get(7).getImeIPrezime());

        TabelaDaoSQLImpl tabelaDaoSQL = new TabelaDaoSQLImpl();
        tabelaDaoSQL.update(tabela1);

        tabela.getItems().addAll(lista);

        OdigranaKola kolo1 = new OdigranaKola();
        OdigranaKola kolo2 = new OdigranaKola();
        OdigranaKola kolo3 = new OdigranaKola();
        OdigranaKola kolo4 = new OdigranaKola();

        kolo1.setIgr1(Double.parseDouble(igr1.getText()));
        kolo1.setIgrac1(igrac1.getText());
        kolo1.setIgrac2(igrac2.getText());
        kolo1.setIgr2(Double.parseDouble(igr2.getText()));

        kolo2.setIgr1(Double.parseDouble(igr3.getText()));
        kolo2.setIgrac1(igrac3.getText());
        kolo2.setIgrac2(igrac4.getText());
        kolo2.setIgr2(Double.parseDouble(igr4.getText()));

        kolo3.setIgr1(Double.parseDouble(igr5.getText()));
        kolo3.setIgrac1(igrac5.getText());
        kolo3.setIgrac2(igrac6.getText());
        kolo3.setIgr2(Double.parseDouble(igr6.getText()));

        kolo4.setIgr1(Double.parseDouble(igr7.getText()));
        kolo4.setIgrac1(igrac7.getText());
        kolo4.setIgrac2(igrac8.getText());
        kolo4.setIgr2(Double.parseDouble(igr8.getText()));

        OdigranaKolaDaoSQLImpl odigranaKolaDaoSQL = new OdigranaKolaDaoSQLImpl();
        odigranaKolaDaoSQL.add(kolo1);
        odigranaKolaDaoSQL.add(kolo2);
        odigranaKolaDaoSQL.add(kolo3);
        odigranaKolaDaoSQL.add(kolo4);
    }

    public void SljedeceKolo(ActionEvent actionEvent) {
        TabelaMenager tabelaMenager = new TabelaMenager();
        Tabela tabela1 = tabelaMenager.getById(0);

        igrac1.setText(tabela1.getMjesto1());
        igrac2.setText(tabela1.getMjesto2());
        igrac3.setText(tabela1.getMjesto3());
        igrac4.setText(tabela1.getMjesto4());
        igrac5.setText(tabela1.getMjesto5());
        igrac6.setText(tabela1.getMjesto6());
        igrac7.setText(tabela1.getMjesto7());
        igrac8.setText(tabela1.getMjesto8());
    }

    public void prikaziOdigranaKola(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Prozor4.fxml"));
        stage.setTitle("Odigrana kola");
        stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stage.show();
    }
}
