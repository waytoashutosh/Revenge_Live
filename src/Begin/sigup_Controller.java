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

public class sigup_Controller {
    Connection con = null;
    PreparedStatement pst = null;

    public PasswordField passPF,confirmpassPF;
    public TextField fnameTF,lnameTF,useridTF,contactTF,emailTF;
    public Button signupBT;

    public boolean isValid(String s)
    {
        return true;
    }
    private String conPass,pass,temp;
    public void signup_listener(ActionEvent actionEvent) {
        try{
            String query = "INSERT INTO `user_info`(`fname`, `lname`, `userid`, `password`, `isonline`, `email`, `phonenum`) VALUES (?,?,?,?,?,?,?)";
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/revenge_live","root","");
            pst=con.prepareStatement(query);

            pass=passPF.getText();
            conPass=confirmpassPF.getText();
            if(pass.equals(conPass)) {
                if(fnameTF.getText().equals("") || lnameTF.getText().equals("") ||
                        useridTF.getText().equals("") || pass.equals("") ||
                        emailTF.getText().equals("") || contactTF.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "PLEASE FILL ALL THE CREDENTIALS");
                }
                else
                {
                    pst.setString(1, fnameTF.getText());
                    pst.setString(2, lnameTF.getText());
                    pst.setString(3, useridTF.getText());
                    pst.setString(4, pass);
                    pst.setString(5, "1");
                    pst.setString(6, emailTF.getText());
                    pst.setString(7, contactTF.getText());

                    System.out.println("PST executed");
                    pst.executeUpdate();
                    Parent root = null;
                    try {
                        Stage stage = (Stage) signupBT.getScene().getWindow();
                        root = FXMLLoader.load(getClass().getResource("../AfterLogin/dashboard.fxml"));
                        stage.setTitle("Welcome to DashBoard!");
                        stage.setScene(new Scene(root,700,500));
                        JOptionPane.showMessageDialog(null, "REGISTER SUCCESSFULLY");
                        //JOptionPane.showMessageDialog(null, "WELCOME "+res.getString("fname"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
            else
            {
                JOptionPane.showMessageDialog(null, "CONFIRM PASSWORD IS DIFFERENT....");
            }

        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
}