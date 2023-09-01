package ba.unsa.etf.rpr.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class kontroler {
    public TextField ime;
    public PasswordField lozinka;

    public void buttonclick(ActionEvent actionEvent){
        System.out.println("vase ime je " + ime.getText());

    }
}
