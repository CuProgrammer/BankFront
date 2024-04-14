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

    @FXML
    void BtnNext(ActionEvent event) throws IOException {
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

}
