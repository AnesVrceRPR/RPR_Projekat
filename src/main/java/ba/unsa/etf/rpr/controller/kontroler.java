package ba.unsa.etf.rpr.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

public class kontroler {
    public TextField ime;
    public PasswordField lozinka;

    public void buttonclick(ActionEvent actionEvent) throws IOException {

        if(!ime.getText().equals("anes") || !lozinka.getText().equals("1234"))
        {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/NoviProzor.fxml"));
            stage.setTitle("Novi prozor");
            stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            stage.show();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Greška");
            alert.setHeaderText("Potreban ponovna prijava");
            alert.setContentText("pogrešno korisničko ime ili lozinka");

            alert.showAndWait();
        }




    }
}
