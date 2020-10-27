package AfterLogin;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class dashboard_Controller {
    public Button stream_id;
    public Button watch_id;
    public Button back_id;

    public void stream_listener(ActionEvent actionEvent) {
        Stage stage = (Stage) stream_id.getScene().getWindow();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("live_stream.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new Scene(root,700,500));
    }

    public void watch_listener(ActionEvent actionEvent) {
        Stage stage = (Stage) watch_id.getScene().getWindow();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("live_watch.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new Scene(root,700,500));
    }

    public void back_listener(ActionEvent actionEvent) {
        Stage stage = (Stage) back_id.getScene().getWindow();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/Begin/log_in_sign_up.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new Scene(root,700,500));
    }
}
