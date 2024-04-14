package sample.asteralbank;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class PayingBills {

    @FXML
    private Button Back;

    @FXML
    private Button Btnsabt;

    @FXML
    private TextField TxtPhoneNum;

    @FXML
    private TextField TxtShenaseGabz;

    @FXML
    private TextField TxtShenasePardakht;

    @FXML
    private Label amount;

    @FXML
    private Button BtnSabtShomareTelephone;

    @FXML
    private AnchorPane dayloan;

    @FXML
    private ImageView imgBack;

    @FXML
    private Label lblShenase;

    @FXML
    private Label lbltransfer;

    @FXML
    private ListView<?> listTransfer;

    @FXML
    private AnchorPane showprice;

    @FXML
    private Label slidelabel;

    @FXML
    private Label sood;

    @FXML
    private Button switch_btn;

    @FXML
    private Button switch_btn1;

    @FXML
    private Label time;

    @FXML
    private AnchorPane weekloan;

    @FXML
    void Back(ActionEvent event) throws IOException {
        Stage stage =(Stage) Back.getScene().getWindow();
        stage.close();
        Stage primaryStage=new Stage();
        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("Main.fxml"));
        Scene scene = new Scene(root);
        stage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    void BtnSabtShomareTelephone(ActionEvent event) {
        showprice.setVisible(true);

    }

    @FXML
    void purchase(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("پرداخت قبض موفقیت آمیز بود");
        alert.showAndWait();
        Stage stage=new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Main.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void switch_forms(ActionEvent event) {

        TranslateTransition slider = new TranslateTransition();

            if (event.getSource() == switch_btn) {
                showprice.setVisible(false);
                //registerform.setVisible(false);
                slider.setNode(slidelabel);
                slider.setToX(203);
                slider.setDuration(Duration.millis(500));
                slider.setOnFinished((ActionEvent e) -> {
                    slidelabel.setVisible(true);
                    dayloan.setVisible(true);
                    weekloan.setVisible(false);


                });
                slider.play();
            } else if (event.getSource() == switch_btn1) {
                showprice.setVisible(false);
                //registerform.setVisible(false);
                slider.setNode(slidelabel);
                slider.setToX(8);
                slider.setDuration(Duration.millis(500));
                slider.setOnFinished((ActionEvent e) -> {
                    slidelabel.setVisible(true);
                    dayloan.setVisible(false);
                    weekloan.setVisible(true);




                });
                slider.play();
            }
    }

    @FXML
    void week2(ActionEvent event) {

    }

}


