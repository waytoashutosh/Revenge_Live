package Begin;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.opencv.core.Core;

import java.io.IOException;

public class login_signup_Controller {
    static{ System.loadLibrary(Core.NATIVE_LIBRARY_NAME); }
    public Button log_in;
    public Button sign_up;
    public Button test_video;

    public void log_in_listener(ActionEvent actionEvent) {
        Stage stage = (Stage) log_in.getScene().getWindow();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("log_in_scene.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new Scene(root,700,500));

    }

    public void sign_up_listener(ActionEvent actionEvent) {


    }

    public void test_video_listener(ActionEvent actionEvent) {
        Stage stage = (Stage) test_video.getScene().getWindow();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("testing_video_scene.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new Scene(root,700,500));
    }

}
