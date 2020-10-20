package Begin;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LogInScene_Controller {
    Connection con = null;
    PreparedStatement pst = null;

    public PasswordField password_id;
    public TextField user_id;
    public Button log_in_id;
    public Button back_id;

    public String entered_pass="",forconfirmation="";
    public String user_name="";

    public void log_in_listener(ActionEvent actionEvent) {
        try{
            entered_pass=password_id.getText();
            user_name = user_id.getText();

            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/revenge_live","root","");
            String query = "SELECT * FROM user_info WHERE userid='"+user_name+"'";
            pst=con.prepareStatement(query);
            ResultSet res = pst.executeQuery();

            if(res.next()){
                forconfirmation=res.getString("password");
                if(forconfirmation.equals(entered_pass)){
                    Stage stage = (Stage) log_in_id.getScene().getWindow();
                    Parent root = null;
                    try {
                        root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
                        stage.setTitle("Welcome to DashBoard!");
                        stage.setScene(new Scene(root,700,500));
                        //JOptionPane.showMessageDialog(null, "WELCOME BACK"+res.getString("fname"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "INCORRECT PASSWORD.");
                }
            }
            else {
                JOptionPane.showMessageDialog(null, "USER DOESN'T EXISTS.");
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void back_listener(ActionEvent actionEvent) {
        Stage stage = (Stage) back_id.getScene().getWindow();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("log_in_sign_up.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new Scene(root,700,500));
    }
}
