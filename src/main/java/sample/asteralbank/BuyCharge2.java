package sample.asteralbank;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class BuyCharge2 {

    @FXML
    private Button Back;

    @FXML
    private Button Home;

    @FXML
    private ImageView imgBack;

    @FXML
    private ImageView imgHome;

    @FXML
    private ImageView imgTick50;

    @FXML
    private Label lblBuyCharge;

    @FXML
    private Label lblCash;

    @FXML
    private Label lblDate;

    @FXML
    private Label lblIRNumber;

    @FXML
    private Label lblIssueTracking;

    @FXML
    private Label lblIssueTrackingNumber;

    @FXML
    private Label lblPaymentFromTheAccount;

    @FXML
    private Label lblPhoneNumber;

    @FXML
    private Label lblReferenceNo;

    @FXML
    private Label lblReferenceNoNumber;

    @FXML
    private Label lblSuccessfulPayment;

    @FXML
    private Label lblTime;

    @FXML
    void Back(ActionEvent event) throws IOException {
        Stage stage =(Stage) Back.getScene().getWindow();
        stage.close();
        Stage primaryStage=new Stage();
        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("BuyCharge1.fxml"));
        Scene scene = new Scene(root, 409, 581);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    @FXML
    void Home(ActionEvent event) throws IOException {
        Stage stage =(Stage) Home.getScene().getWindow();
        stage.close();
        Stage primaryStage=new Stage();
        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("Main.fxml"));
        Scene scene = new Scene(root, 719,592);
        stage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();


    }

}
