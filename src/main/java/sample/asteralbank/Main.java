package sample.asteralbank;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main {

    @FXML
    private Button Back;

    @FXML
    private Button BtnAccountType;

    @FXML
    private Button BtnBuyaninternet;

    @FXML
    private Button BtnBuyrecharge;

    @FXML
    private Button BtnCart1;

    @FXML
    private Button BtnCart2;

    @FXML
    private Button BtnCommunications;

    @FXML
    private Button BtnInventory;

    @FXML
    private Button BtnMoneytransfer;

    @FXML
    private Button BtnPayingbills;

    @FXML
    private Button BtnTurnover;

    @FXML
    private Button Btncheck;

    @FXML
    private Label lblNum1;

    @FXML
    private Label lblNum11;

    @FXML
    private Label lblNum111;

    @FXML
    private Label lblNum2;

    @FXML
    private Label lblNum3;

    @FXML
    private Label lblNum4;

    @FXML
    void Back(ActionEvent event) throws IOException {
        Stage stage =(Stage) Back.getScene().getWindow();
        stage.close();
        Stage primaryStage=new Stage();
        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("Signin.fxml"));
        Scene scene = new Scene(root, 389, 588);
        stage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    @FXML
    void BtnAccountType(ActionEvent event) {

    }

    @FXML
    void BtnBuyaninternet(ActionEvent event) throws IOException {
        Stage stage =(Stage) BtnBuyaninternet.getScene().getWindow();
        stage.close();
        Stage primaryStage=new Stage();
        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("internet.fxml"));
        Scene scene = new Scene(root, 409, 581);
        stage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    @FXML
    void BtnBuyrecharge(ActionEvent event) throws IOException {
        Stage stage =(Stage) BtnBuyrecharge.getScene().getWindow();
        stage.close();
        Stage primaryStage=new Stage();
        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("BuyCharge.fxml"));
        Scene scene = new Scene(root, 409, 581);
        stage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    @FXML
    void BtnCart1(ActionEvent event) {

    }

    @FXML
    void BtnCart2(ActionEvent event) {

    }

    @FXML
    void BtnCommunications(ActionEvent event) {

    }

    @FXML
    void BtnInventory(ActionEvent event) throws IOException {
        Stage stage =(Stage) BtnMoneytransfer.getScene().getWindow();
        stage.close();
        Stage primaryStage=new Stage();
        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("Loan.fxml"));
        Scene scene = new Scene(root);
        stage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    @FXML
    void BtnMoneytransfer(ActionEvent event) throws IOException {
        Stage stage =(Stage) BtnMoneytransfer.getScene().getWindow();
        stage.close();
        Stage primaryStage=new Stage();
        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("Transfer.fxml"));
        Scene scene = new Scene(root, 409, 581);
        stage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    @FXML
    void BtnPayingbills(ActionEvent event) throws IOException {
        Stage stage =(Stage) BtnPayingbills.getScene().getWindow();
        stage.close();
        Stage primaryStage=new Stage();
        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("PayingBills.fxml"));
        Scene scene = new Scene(root, 409, 581);
        stage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    @FXML
    void BtnTurnover(ActionEvent event) throws IOException {
        Stage stage =(Stage) BtnTurnover.getScene().getWindow();
        stage.close();
        Stage primaryStage=new Stage();
        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("TurnOver.fxml"));
        Scene scene = new Scene(root, 409, 581);
        stage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();


    }

    @FXML
    void Btncheck(ActionEvent event) {

    }

}
