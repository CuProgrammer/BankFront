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

public class BuyCharge1 {

    @FXML
    private Button Back;

    @FXML
    private Button Btn1;

    @FXML
    private Button Btn10;

    @FXML
    private Button Btn2;

    @FXML
    private Button Btn20;

    @FXML
    private Button Btn5;

    @FXML
    private Button Btn50;

    @FXML
    private Button BtnNext;

    @FXML
    private Button Home;

    @FXML
    private ImageView imgBack;

    @FXML
    private ImageView imgHome;

    @FXML
    private Label lblBuyCharge;

    @FXML
    private Label lblCash;

    @FXML
    private Label lblChargeAmount;

    @FXML
    private Label lblChargeAndTax;

    @FXML
    private Label lblEror;

    @FXML
    void Back(ActionEvent event) throws IOException {
        Stage stage =(Stage) Back.getScene().getWindow();
        stage.close();
        Stage primaryStage=new Stage();
        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("BuyCharge.fxml"));
        Scene scene = new Scene(root, 409, 581);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    static double amount;
    @FXML
    void BtnNext(ActionEvent event) throws IOException {
        String cashString = lblCash.getText();
        amount = Double.parseDouble(cashString.substring(0, cashString.length()-1));
        DataRepository.userManager.increaseBalance(DataRepository.user.getUsername(), -amount);
        Stage stage =(Stage) BtnNext.getScene().getWindow();
        stage.close();
        Stage primaryStage=new Stage();
        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("BuyCharge2.fxml"));
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
    @FXML
    void Btn1(ActionEvent event) {
        lblCash.setText("1$");
    }

    @FXML
    void Btn10(ActionEvent event) {
        lblCash.setText("10$");
    }

    @FXML
    void Btn2(ActionEvent event) {
        lblCash.setText("2$");
    }

    @FXML
    void Btn20(ActionEvent event) {
        lblCash.setText("20$");
    }

    @FXML
    void Btn5(ActionEvent event) {
        lblCash.setText("5$");
    }

    @FXML
    void Btn50(ActionEvent event) {
        lblCash.setText("50$");
    }

}
