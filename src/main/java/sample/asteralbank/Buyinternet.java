package sample.asteralbank;

import com.blackbank.bank.Account;
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
import java.io.IOException;

public class Buyinternet {
   @FXML
   public AnchorPane showprice;

   @FXML
   public Label dataprice;

    @FXML
    private Label welcomeText;

    @FXML
    public Label slidelabel;

    @FXML
    private Button Back;

    @FXML
    private AnchorPane daydata;

    @FXML
    private ImageView imgBack;

    @FXML
    private Label lbltransfer;

    @FXML
    private ListView<?> listTransfer;

    @FXML
    private AnchorPane monthdata;

    @FXML
    public Button switch_btn;

    @FXML
    public Button switch_btn1;

    @FXML
    public Button switch_btn2;

    @FXML
    private AnchorPane weekdata;

    public void switch_forms(ActionEvent event) {
        TranslateTransition slider = new TranslateTransition();
        if (event.getSource() == switch_btn) {

            //registerform.setVisible(false);
            slider.setNode(slidelabel);
            slider.setToX(265);
            slider.setDuration(Duration.millis(500));
            slider.setOnFinished((ActionEvent e) -> {
                slidelabel.setVisible(true);
                daydata.setVisible(true);
                weekdata.setVisible(false);
                monthdata.setVisible(false);


            });
            slider.play();
        } else if (event.getSource() == switch_btn1) {

            //registerform.setVisible(false);
            slider.setNode(slidelabel);
            slider.setToX(132);
            slider.setDuration(Duration.millis(500));
            slider.setOnFinished((ActionEvent e) -> {
                slidelabel.setVisible(true);
                daydata.setVisible(false);
                weekdata.setVisible(true);
                monthdata.setVisible(false);


            });
            slider.play();
        }
        else if (event.getSource() == switch_btn2) {
            //rightform.setVisible(false);
            slider.setNode(slidelabel);
            slider.setToX(0);
            slider.setDuration(Duration.millis(500));
            slider.setOnFinished((ActionEvent e) -> {
                slidelabel.setVisible(true);
               daydata.setVisible(false);
                weekdata.setVisible(false);
                monthdata.setVisible(true);


            });
            slider.play();

    }
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
    }
    @FXML
    void day1(ActionEvent event) {
        showprice.setVisible(true);
        dataprice.setText("10");

    }

    @FXML
    void day2(ActionEvent event) {
        showprice.setVisible(true);
        dataprice.setText("15");

    }

    @FXML
    void day3(ActionEvent event) {
        showprice.setVisible(true);
        dataprice.setText("20");

    }

    @FXML
    void month1(ActionEvent event) {
        showprice.setVisible(true);
        dataprice.setText("50");

    }

    @FXML
    void month2(ActionEvent event) {
        showprice.setVisible(true);
        dataprice.setText("70");

    }

    @FXML
    void month3(ActionEvent event) {
        showprice.setVisible(true);
        dataprice.setText("120");

    }


    @FXML
    void week1(ActionEvent event) {
        showprice.setVisible(true);
        dataprice.setText("20");

    }

    @FXML
    void week2(ActionEvent event) {
        showprice.setVisible(true);
        dataprice.setText("30");

    }

    @FXML
    void week3(ActionEvent event) {
        showprice.setVisible(true);
        dataprice.setText("39");

    }

    @FXML
    void purchase(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Succesfully purchased!");
        alert.showAndWait();
        Double amount = Double.parseDouble(dataprice.getText());
        Account account = (Account) DataRepository.user;
        if (account.getBalance() < amount){
         Alert alert1 = new Alert(Alert.AlertType.ERROR);
         alert1.setTitle("Errrr");
         alert1.setContentText("ERRRRR");
         alert1.showAndWait();
         return;
        }

        account.setBalance(account.getBalance() - amount);
        Stage stage =(Stage) Back.getScene().getWindow();
        stage.close();
        Stage primaryStage=new Stage();
        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("Main.fxml"));
        Scene scene = new Scene(root);
        stage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
        //load main page fxml and return
    }
}