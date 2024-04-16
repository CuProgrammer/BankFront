package sample.asteralbank;

import java.io.IOException;

import com.blackbank.bank.Account;

import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class transfercontroller {

    @FXML
    private Label Amount;

    @FXML
    public Button Back;

    @FXML
    private TextField Cardid;

    @FXML
    private TextField Amount1;

    @FXML
    private Label Recieverid;

    @FXML
    private Label ReciverName;

    @FXML
    private Label SenderName;

    @FXML
    private Label Senderid;

    @FXML
    private AnchorPane Transferinfo1;

    @FXML
    private AnchorPane Transferinfo2;

    @FXML
    private AnchorPane Transferinfo3;

    @FXML
    private ImageView imgBack;

    @FXML
    private Label lbltransfer;

    @FXML
    private ListView<?> listTransfer;

    @FXML
    private AnchorPane showprice;


    @FXML
    private Label amount;

    @FXML
    private AnchorPane dayloan;

    @FXML
    private AnchorPane weekloan;

    @FXML
    private Label RecieverName2;

    @FXML
    private Label SenderName2;

    @FXML
    private Label Amount2;
    @FXML
    private Label slidelabel;

    @FXML
    private Button purchase;


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
    void Back (ActionEvent event) throws IOException {
        if (Transferinfo3.isVisible()){
            Transferinfo1.setVisible(false);
            Transferinfo2.setVisible(true);
            Transferinfo3.setVisible(false);
            purchase.setText("Process");
        }

        else if(Transferinfo2.isVisible()) {
            //if the balance isnt enough set alert
            //else show the next page
            Transferinfo1.setVisible(true);
            Transferinfo2.setVisible(false);
            Transferinfo3.setVisible(false);
            purchase.setText("Continue");
        }
        else if (Transferinfo1.isVisible()){
            Stage stage=new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Main.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.show();

        }

    }


    double tranferredAmount = 0;
    Account recipient = null;

    @FXML
    void purchase(ActionEvent event) throws IOException {
        purchase.setText("Continue");
        if (Transferinfo1.isVisible()){
            if(Cardid.getText().isEmpty() || Amount1.getText().isEmpty()){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("تمامی فیلد ها را پر کنید!");
                alert.showAndWait();
                return;
            }
            String recipientCardNumber = Cardid.getText();
            
            if (!DataRepository.userManager.exists(recipientCardNumber) || 
                !(DataRepository.userManager.getUser(recipientCardNumber) instanceof Account)) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Card number " + recipientCardNumber + " doesn't exist");
                alert.showAndWait();
                return;
            }

            tranferredAmount = Double.parseDouble(Amount1.getText());
            recipient = (Account) DataRepository.userManager.getUser(recipientCardNumber);
            
            if (recipient.getBalance() < tranferredAmount) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Not enough balance in your account");
                alert.showAndWait();
                return;
            }

            Amount.setText(Amount1.getText());
            Recieverid.setText(Cardid.getText());
            ReciverName.setText(recipient.getPerson().getName());
            Senderid.setText(DataRepository.user.getUsername());
            SenderName.setText(DataRepository.user.getPerson().getName());
            Transferinfo1.setVisible(false);
            Transferinfo2.setVisible(true);
            Transferinfo3.setVisible(false);
            purchase.setText("Process");
            DataRepository.userManager.increaseBalance(recipientCardNumber, tranferredAmount);
            DataRepository.userManager.increaseBalance(DataRepository.user.getUsername(), -tranferredAmount);
        }

        else if(Transferinfo2.isVisible()) {
            //if the balance isnt enough set alert
            //else show the next page

            Transferinfo1.setVisible(false);
            Transferinfo2.setVisible(false);
            Transferinfo3.setVisible(true);
            purchase.setText("Return Home");
            SenderName2.setText(DataRepository.user.getPerson().getName());
            RecieverName2.setText(recipient.getPerson().getName());
            Amount2.setText(tranferredAmount + "");
        }
        else if(Transferinfo3.isVisible()){
            Stage stage=new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Main.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.show();

        }


        //load main page fxml and return
    }

    @FXML
    public void switch_forms(ActionEvent event) {
        TranslateTransition slider = new TranslateTransition();
        if (event.getSource() == switch_btn) {

            //registerform.setVisible(false);
            slider.setNode(slidelabel);
            slider.setToX(187);
            slider.setDuration(Duration.millis(500));
            slider.setOnFinished((ActionEvent e) -> {
                slidelabel.setVisible(true);
                dayloan.setVisible(true);
                weekloan.setVisible(false);


            });
            slider.play();
        } else if (event.getSource() == switch_btn1) {

            //registerform.setVisible(false);
            slider.setNode(slidelabel);
            slider.setToX(3);
            slider.setDuration(Duration.millis(500));
            slider.setOnFinished((ActionEvent e) -> {
                slidelabel.setVisible(true);
                dayloan.setVisible(false);
                weekloan.setVisible(true);


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
        void Resize(MouseEvent event) {

        ScaleTransition st = new ScaleTransition(Duration.millis(400), switch_btn1);
            st.setToX(1.25);
            st.setToY(1.25);
            st.setCycleCount(1);
            st.setAutoReverse(true);

            st.play();
    }

    @FXML
    void Resize2(MouseEvent event) {
        ScaleTransition st = new ScaleTransition(Duration.millis(400), switch_btn1);
        event.getSource();
        st.setToX(1);
        st.setToY(1);
        st.setCycleCount(1);
        st.setAutoReverse(true);

        st.play();
    }


}
