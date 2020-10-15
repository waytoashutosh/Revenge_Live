package Begin;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LogInScene_Controller {

    public PasswordField password_id;
    public TextField user_id;
    public Button log_in_id;
    public Button back_id;

    private String entered_pass;
    private String user_name;

    public void password_listener(ActionEvent actionEvent) {
        entered_pass=password_id.getText();

    }

    public void user_id_listener(ActionEvent actionEvent) {
        user_name = user_id.getText();


    }

    public void log_in_listener(ActionEvent actionEvent) {
        //we nee to check if the user name exists in the database
        //if the username exists then match password
        //if matches then login to dashboard
    }

    public void back_listener(ActionEvent actionEvent) {
        Stage stage = (Stage) back_id.getScene().getWindow();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("login.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new Scene(root));
    }
}
