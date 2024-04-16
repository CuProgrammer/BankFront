package sample.asteralbank;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class BuyCharge {

    @FXML
    private Button Back;

    @FXML
    private Button BtnCharge;

    @FXML
    private TextField TxtPhoneNumber;

    @FXML
    private ImageView imgBack;

    @FXML
    private Label lblBuyCharge;

    @FXML
    private Label lblEror;

    @FXML
    private Label lblPlease;

    @FXML
    private Label lblpluse;

    @FXML
    void Back(ActionEvent event) throws IOException {
        Stage stage =(Stage) Back.getScene().getWindow();
        stage.close();
        Stage primaryStage=new Stage();
        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("Main.fxml"));
        Scene scene = new Scene(root, 727, 592);
        stage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    @FXML
    void Charge(ActionEvent event) throws IOException {

        if(TxtPhoneNumber.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("please enter the phone number");
            alert.showAndWait();
        }
        else{
        Stage stage =(Stage) BtnCharge.getScene().getWindow();
        stage.close();
        Stage primaryStage=new Stage();
        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("BuyCharge1.fxml"));
        Scene scene = new Scene(root, 409, 581);
        stage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();}


    }

}
