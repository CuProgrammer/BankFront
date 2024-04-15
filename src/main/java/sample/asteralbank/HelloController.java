package sample.asteralbank;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class HelloController {

    @FXML
    private Label Account;

    @FXML
    private Label lblEror;

    @FXML
    private Label Astral;

    @FXML
    private PasswordField Password;

    @FXML
    private TextField TxtUserName;

    @FXML
    private Button btnSignUp;

    @FXML
    private Button btnSignin;

    @FXML
    void Password(ActionEvent event) {

    }

    @FXML
    void SignUp(ActionEvent event) throws IOException {
        Stage stage =(Stage) btnSignUp.getScene().getWindow();
        stage.close();
        Stage primaryStage=new Stage();
        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("SignUp.fxml"));
        Scene scene = new Scene(root, 419, 629);
        stage.getIcons().add(new Image(HelloController.class.getResourceAsStream("logo.png")));
        stage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();


    }

    @FXML
    void Signin(ActionEvent event) throws IOException {

        String username = TxtUserName.getText();
        String password = Password.getText();
        DataRepository.user = DataRepository.userManager.login(username, password);
        if (DataRepository.user == null) {
            lblEror.setText("Wrong username or password");
            return;
        }

        Stage stage =(Stage) btnSignin.getScene().getWindow();
        stage.close();
        Stage primaryStage=new Stage();
        AnchorPane root = null;
        if (DataRepository.userManager.getUserType(username).equals("admin"))
            root = (AnchorPane) FXMLLoader.load(getClass().getResource("Manager.fxml"));
        else if (DataRepository.userManager.getUserType(username).equals("account"))
            root = (AnchorPane) FXMLLoader.load(getClass().getResource("Main.fxml"));
        Scene scene = new Scene(root, 658 ,473);
        stage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

}
