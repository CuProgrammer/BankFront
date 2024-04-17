package sample.asteralbank;

import com.blackbank.bank.Account;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.w3c.dom.events.Event;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Main implements Initializable {

    @FXML
    private Button Back;

    @FXML
    public Label lblLastName;

    @FXML
    private Label lblInventory;
    @FXML
    public Label lblName;

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
    private Button BtnAboutUs;

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
    public Label lblNum1;

    @FXML
    private Label lblNum11;

    @FXML
    private Label lblNum111;

    @FXML
    public Label lblNum2;

    @FXML
    public Label lblNum3;

    @FXML
    public Label lblNum4;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lblName.setText(DataRepository.user.getPerson().getName().split(" ")[0]);
        lblLastName.setText(DataRepository.user.getPerson().getName().split(" ")[1]);
        lblInventory.setText(((Account) DataRepository.user).getBalance() + "");
        String cardNumber = DataRepository.user.getUsername();

        lblNum1.setText(cardNumber.substring(0, 4));
        lblNum2.setText(cardNumber.substring(4, 8));
        lblNum3.setText(cardNumber.substring(8, 12));
        lblNum4.setText(cardNumber.substring(12, 16));
    }

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
        MyLog.setUser(DataRepository.user);
        MyLog.log("Logged out");
        MyLog.setUser(null);
        DataRepository.user = null;
    }

    @FXML
    void BtnAccountType(ActionEvent event) throws IOException {
        Stage stage =(Stage) BtnAccountType.getScene().getWindow();
        stage.close();
        Stage primaryStage=new Stage();
        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("AccountType.fxml"));
        Scene scene = new Scene(root);
        stage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
        MyLog.setUser(DataRepository.user);
        MyLog.log("Account type button clicked");

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
        MyLog.setUser(DataRepository.user);
        MyLog.log("buy internet button clicked");

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
        MyLog.setUser(DataRepository.user);
        MyLog.log("buy charge button clicked");
        MyLog.log("User clicked on Buying charge btn");


    }

    @FXML
    public void BtnCart1(ActionEvent event) {

    }

    @FXML
    void BtnCart2(ActionEvent event) {

    }

    @FXML
    void BtnAboutUs(ActionEvent event) throws IOException {
        Stage stage =(Stage) BtnAccountType.getScene().getWindow();
        stage.close();
        Stage primaryStage=new Stage();
        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("AboutUs.fxml"));
        Scene scene = new Scene(root);
        stage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
        MyLog.log("User clicked on About us btn");

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
        MyLog.setUser(DataRepository.user);
        MyLog.log("inventory button clicked");
        MyLog.log("User clicked on Loan btn");


    }

    @FXML
    void BtnMoneytransfer(ActionEvent event) throws IOException {
        Stage stage =(Stage) BtnMoneytransfer.getScene().getWindow();
        stage.close();
        Stage primaryStage=new Stage();
        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("transfer.fxml"));
        Scene scene = new Scene(root);
        stage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
        MyLog.setUser(DataRepository.user);
        MyLog.log("transfer button clicked");
        MyLog.log("User clicked on Money Transfer btn");
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
        MyLog.log("User clicked on Paying bills btn");

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
        MyLog.log("User clicked on Turn over btn");


    }

    @FXML
    void Btncheck(ActionEvent event) throws IOException {
        Stage stage =(Stage) Btncheck.getScene().getWindow();
        stage.close();
        Stage primaryStage=new Stage();
        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("check.fxml"));
        Scene scene = new Scene(root);
        stage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
        MyLog.log("User clicked on check btn");

    }


     @FXML
     void Resize1(javafx.scene.input.MouseEvent mouseEvent ) {
        ScaleTransition st = new ScaleTransition(Duration.millis(200));
        Event even;
        if (mouseEvent.getSource()==BtnAccountType){
            st.setNode(BtnAccountType);
            st.setToX(1.1);
            st.setToY(1.1);
            st.setCycleCount(1);
            st.setAutoReverse(true);
            st.play();
        }
        else if (mouseEvent.getSource()==BtnMoneytransfer){
            st.setNode(BtnMoneytransfer);
            st.setToX(1.1);
            st.setToY(1.1);
            st.setCycleCount(1);
            st.setAutoReverse(true);
            st.play();
        }
        else if (mouseEvent.getSource()==Btncheck){
            st.setNode(Btncheck);
            st.setToX(1.1);
            st.setToY(1.1);
            st.setCycleCount(1);
            st.setAutoReverse(true);
            st.play();
        }
        else if (mouseEvent.getSource()==BtnBuyaninternet){
            st.setNode(BtnBuyaninternet);
            st.setToX(1.1);
            st.setToY(1.1);
            st.setCycleCount(1);
            st.setAutoReverse(true);
            st.play();
        }
        else if (mouseEvent.getSource()==BtnBuyrecharge){
            st.setNode(BtnBuyrecharge);
            st.setToX(1.1);
            st.setToY(1.1);
            st.setCycleCount(1);
            st.setAutoReverse(true);
            st.play();
        }
        else if (mouseEvent.getSource()==BtnAboutUs){
            st.setNode(BtnAboutUs);
            st.setToX(1.1);
            st.setToY(1.1);
            st.setCycleCount(1);
            st.setAutoReverse(true);
            st.play();}
        else if (mouseEvent.getSource()==BtnTurnover){
            st.setNode(BtnTurnover);
            st.setToX(1.1);
            st.setToY(1.1);
            st.setCycleCount(1);
            st.setAutoReverse(true);
            st.play();
        }
        else if (mouseEvent.getSource()==BtnInventory){
            st.setNode(BtnInventory);
            st.setToX(1.1);
            st.setToY(1.1);
            st.setCycleCount(1);
            st.setAutoReverse(true);
            st.play();
        }
        else if (mouseEvent.getSource()==BtnPayingbills){
            st.setNode(BtnPayingbills);
            st.setToX(1.1);
            st.setToY(1.1);
            st.setCycleCount(1);
            st.setAutoReverse(true);
            st.play();
        }
    }

    public void Resize2(javafx.scene.input.MouseEvent mouseEvent) {
        ScaleTransition st = new ScaleTransition(Duration.millis(200));
        Event even;
        if (mouseEvent.getSource()==BtnAccountType){
            st.setNode(BtnAccountType);
            st.setToX(1);
            st.setToY(1);
            st.setCycleCount(1);
            st.setAutoReverse(true);
            st.play();
        }
        else if (mouseEvent.getSource()==BtnMoneytransfer){
            st.setNode(BtnMoneytransfer);
            st.setToX(1);
            st.setToY(1);
            st.setCycleCount(1);
            st.setAutoReverse(true);
            st.play();
        }
        else if (mouseEvent.getSource()==Btncheck){
            st.setNode(Btncheck);
            st.setToX(1);
            st.setToY(1);
            st.setCycleCount(1);
            st.setAutoReverse(true);
            st.play();
        }
        else if (mouseEvent.getSource()==BtnBuyaninternet){
            st.setNode(BtnBuyaninternet);
            st.setToX(1);
            st.setToY(1);
            st.setCycleCount(1);
            st.setAutoReverse(true);
            st.play();
        }
        else if (mouseEvent.getSource()==BtnBuyrecharge){
            st.setNode(BtnBuyrecharge);
            st.setToX(1);
            st.setToY(1);
            st.setCycleCount(1);
            st.setAutoReverse(true);
            st.play();
        }
        else if (mouseEvent.getSource()==BtnAboutUs){
            st.setNode(BtnAboutUs);
            st.setToX(1);
            st.setToY(1);
            st.setCycleCount(1);
            st.setAutoReverse(true);
            st.play();}
        else if (mouseEvent.getSource()==BtnTurnover){
            st.setNode(BtnTurnover);
            st.setToX(1);
            st.setToY(1);
            st.setCycleCount(1);
            st.setAutoReverse(true);
            st.play();
        }
        else if (mouseEvent.getSource()==BtnInventory){
            st.setNode(BtnInventory);
            st.setToX(1);
            st.setToY(1);
            st.setCycleCount(1);
            st.setAutoReverse(true);
            st.play();
        }
        else if (mouseEvent.getSource()==BtnPayingbills){
            st.setNode(BtnPayingbills);
            st.setToX(1);
            st.setToY(1);
            st.setCycleCount(1);
            st.setAutoReverse(true);
            st.play();
        }
    }

    @FXML
    public void Resize3(MouseEvent mouseEvent) {
        ScaleTransition st = new ScaleTransition(Duration.millis(100));
        if(mouseEvent.getSource()==BtnCart1){
            st.setNode(BtnCart1);
            st.setToX(1.05);
            st.setToY(1.05);
            st.play();
        }
        else if (mouseEvent.getSource()==BtnCart2){
            st.setNode(BtnCart2);
            st.setToX(1.05);
            st.setToY(1.05);
            st.play();
        }
    }

    @FXML
    public void Resize4(MouseEvent mouseEvent) {
        ScaleTransition st = new ScaleTransition(Duration.millis(100));
        if(mouseEvent.getSource()==BtnCart1){
            st.setNode(BtnCart1);
            st.setToX(1);
            st.setToY(1);
            st.play();
        }
        else if (mouseEvent.getSource()==BtnCart2){
            st.setNode(BtnCart2);
            st.setToX(1);
            st.setToY(1);
            st.play();
        }
    }
}
