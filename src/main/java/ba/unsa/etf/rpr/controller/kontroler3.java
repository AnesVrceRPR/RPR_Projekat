package ba.unsa.etf.rpr.controller;

import ba.unsa.etf.rpr.dao.TabelaDaoSQLImpl;
import ba.unsa.etf.rpr.dao.UcesnikDaoSQLImpl;
import ba.unsa.etf.rpr.domain.Tabela;
import ba.unsa.etf.rpr.domain.Ucesnik;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.awt.font.ImageGraphicAttribute;
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

    public Ucesnik PronadjiIgraca(String ime)
    {
        UcesnikDaoSQLImpl ucesnikDaoSQLImpl = new UcesnikDaoSQLImpl();
        List<Ucesnik> lista = ucesnikDaoSQLImpl.getAll();

        for(Ucesnik ucesnik : lista)
        {
            if(ucesnik.getIme_i_Prezime().equals(ime))
            {
                return ucesnik;
            }
        }

        return new Ucesnik();
    }

    public void azurirajTabelu(ActionEvent actionEvent) {

        UcesnikDaoSQLImpl ucesnikDaoSQLImpl = new UcesnikDaoSQLImpl();

        Ucesnik ucesnik1 = new Ucesnik();
        Ucesnik ucesnik2 = new Ucesnik();

        if(Integer.parseInt(igr1.getText()) == 0 && Integer.parseInt(igr2.getText()) == 0)
        {
            ucesnik1 = PronadjiIgraca(igrac1.getText());
            ucesnik2 = PronadjiIgraca(igrac2.getText());
            ucesnik1.setBroj_Osvojenih_Bodova(PronadjiIgraca(igrac1.getText()).getBroj_Osvojenih_Bodova() + 0.5);
            ucesnik2.setBroj_Osvojenih_Bodova(PronadjiIgraca(igrac2.getText()).getBroj_Osvojenih_Bodova() + 0.5);

            uce
        }
        if(Integer.parseInt(igr1.getText()) == 1 && Integer.parseInt(igr2.getText()) == 0)
        {
            PronadjiIgraca(igrac1.getText()).setBroj_Osvojenih_Bodova(PronadjiIgraca(igrac1.getText()).getBroj_Osvojenih_Bodova() + 1);
        }
        if(Integer.parseInt(igr1.getText()) == 0 && Integer.parseInt(igr2.getText()) == 1)
        {
            PronadjiIgraca(igrac2.getText()).setBroj_Osvojenih_Bodova(PronadjiIgraca(igrac2.getText()).getBroj_Osvojenih_Bodova() + 1);
        }

        if(Integer.parseInt(igr3.getText()) == 0 && Integer.parseInt(igr4.getText()) == 0)
        {
            PronadjiIgraca(igrac3.getText()).setBroj_Osvojenih_Bodova(PronadjiIgraca(igrac3.getText()).getBroj_Osvojenih_Bodova() + 0.5);
            PronadjiIgraca(igrac4.getText()).setBroj_Osvojenih_Bodova(PronadjiIgraca(igrac4.getText()).getBroj_Osvojenih_Bodova() + 0.5);
        }
        if(Integer.parseInt(igr3.getText()) == 1 && Integer.parseInt(igr4.getText()) == 0)
        {
            PronadjiIgraca(igrac3.getText()).setBroj_Osvojenih_Bodova(PronadjiIgraca(igrac3.getText()).getBroj_Osvojenih_Bodova() + 1);
        }
        if(Integer.parseInt(igr3.getText()) == 0 && Integer.parseInt(igr4.getText()) == 1)
        {
            PronadjiIgraca(igrac4.getText()).setBroj_Osvojenih_Bodova(PronadjiIgraca(igrac4.getText()).getBroj_Osvojenih_Bodova() + 1);
        }

        if(Integer.parseInt(igr5.getText()) == 0 && Integer.parseInt(igr6.getText()) == 0)
        {
            PronadjiIgraca(igrac5.getText()).setBroj_Osvojenih_Bodova(PronadjiIgraca(igrac5.getText()).getBroj_Osvojenih_Bodova() + 0.5);
            PronadjiIgraca(igrac6.getText()).setBroj_Osvojenih_Bodova(PronadjiIgraca(igrac6.getText()).getBroj_Osvojenih_Bodova() + 0.5);
        }
        if(Integer.parseInt(igr5.getText()) == 1 && Integer.parseInt(igr6.getText()) == 0)
        {
            PronadjiIgraca(igrac5.getText()).setBroj_Osvojenih_Bodova(PronadjiIgraca(igrac5.getText()).getBroj_Osvojenih_Bodova() + 1);
        }
        if(Integer.parseInt(igr5.getText()) == 0 && Integer.parseInt(igr6.getText()) == 1)
        {
            PronadjiIgraca(igrac6.getText()).setBroj_Osvojenih_Bodova(PronadjiIgraca(igrac6.getText()).getBroj_Osvojenih_Bodova() + 1);
        }

        if(Integer.parseInt(igr7.getText()) == 0 && Integer.parseInt(igr8.getText()) == 0)
        {
            PronadjiIgraca(igrac7.getText()).setBroj_Osvojenih_Bodova(PronadjiIgraca(igrac7.getText()).getBroj_Osvojenih_Bodova() + 0.5);
            PronadjiIgraca(igrac8.getText()).setBroj_Osvojenih_Bodova(PronadjiIgraca(igrac8.getText()).getBroj_Osvojenih_Bodova() + 0.5);
        }
        if(Integer.parseInt(igr7.getText()) == 1 && Integer.parseInt(igr8.getText()) == 0)
        {
            PronadjiIgraca(igrac7.getText()).setBroj_Osvojenih_Bodova(PronadjiIgraca(igrac7.getText()).getBroj_Osvojenih_Bodova() + 1);
        }
        if(Integer.parseInt(igr7.getText()) == 0 && Integer.parseInt(igr8.getText()) == 1)
        {
            PronadjiIgraca(igrac8.getText()).setBroj_Osvojenih_Bodova(PronadjiIgraca(igrac8.getText()).getBroj_Osvojenih_Bodova() + 1);
        }



        /*ucesnikDaoSQLImpl.update(lista1.get(0));
        ucesnikDaoSQLImpl.update(lista1.get(1));
        ucesnikDaoSQLImpl.update(lista1.get(2));
        ucesnikDaoSQLImpl.update(lista1.get(3));
        ucesnikDaoSQLImpl.update(lista1.get(4));
        ucesnikDaoSQLImpl.update(lista1.get(5));
        ucesnikDaoSQLImpl.update(lista1.get(6));
        ucesnikDaoSQLImpl.update(lista1.get(7));*/

        List<Ucesnik> lista = ucesnikDaoSQLImpl.getAll();
        tabela.getItems().removeAll(lista);

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
