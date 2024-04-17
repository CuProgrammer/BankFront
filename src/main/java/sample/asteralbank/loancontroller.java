package sample.asteralbank;

import java.io.IOException;

import com.blackbank.bank.Loan;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class loancontroller {
    @FXML
    private Button Back;

    @FXML
    private Label amount;

    @FXML
    private AnchorPane dayloan;

    @FXML
    private AnchorPane weekloan;

    @FXML
    private ImageView imgBack;

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
    void day1(ActionEvent event) {
        amount.setText("5000");
        time.setText("دو ساله");
        sood.setText("5%");
        showprice.setVisible(true);
    }

    @FXML
    void day2(ActionEvent event) {
        amount.setText("15000");
        time.setText("دو ساله");
        sood.setText("5%");
        showprice.setVisible(true);

    }

    @FXML
    void purchase(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("اطلاعات وام درخواستی شما به کارشناس مربوطه جهت برسی ارجاع شد !");
        alert.showAndWait();
        MyLog.log("Loan request sent to admin");


        Loan loan = new Loan(DataRepository.user, Double.parseDouble(amount.getText()), false);
        DataRepository.loanManager.add(loan);
        Stage stage=new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Main.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        //load main page fxml and return
    }

    @FXML
    public void switch_forms(ActionEvent event) {

        TranslateTransition slider = new TranslateTransition();
        if (event.getSource() == switch_btn) {
            showprice.setVisible(false);
            //registerform.setVisible(false);
            slider.setNode(slidelabel);
            slider.setToX(192);
            slider.setDuration(Duration.millis(500));
            slider.setOnFinished((ActionEvent e) -> {
                slidelabel.setVisible(true);
                dayloan.setVisible(true);
                weekloan.setVisible(false);
                MyLog.log("User clicked on 1st loan btn");


            });
            slider.play();
        } else if (event.getSource() == switch_btn1) {
            showprice.setVisible(false);
            //registerform.setVisible(false);
            slider.setNode(slidelabel);
            slider.setToX(0);
            slider.setDuration(Duration.millis(500));
            slider.setOnFinished((ActionEvent e) -> {
                slidelabel.setVisible(true);
                dayloan.setVisible(false);
                weekloan.setVisible(true);
                MyLog.log("User clicked on 2nd loan btn");


            });
            slider.play();
        }}

        @FXML
        void week1(ActionEvent event) {
            amount.setText("20000");
            time.setText("پنج ساله");
            sood.setText("20%");
            showprice.setVisible(true);

        }

        @FXML
        void week2(ActionEvent event) {
            amount.setText("50000");
            time.setText("پنج ساله");
            sood.setText("20%");
            showprice.setVisible(true);

        }
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
        MyLog.log("User returned to main page");

    }

}
