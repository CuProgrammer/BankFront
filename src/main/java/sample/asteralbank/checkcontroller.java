package sample.asteralbank;

import com.blackbank.bank.Cheque;
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
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.HashMap;

class PersianNumberer {

    private static final HashMap<String, Double> persianNumbers = new HashMap<>();

    static {
        persianNumbers.put("صفر", 0.0);
        persianNumbers.put("یک", 1.0);
        persianNumbers.put("دو", 2.0);
        persianNumbers.put("سه", 3.0);
        persianNumbers.put("چهار", 4.0);
        persianNumbers.put("پنج", 5.0);
        persianNumbers.put("شش", 6.0);
        persianNumbers.put("هفت", 7.0);
        persianNumbers.put("هشت", 8.0);
        persianNumbers.put("نه", 9.0);
        persianNumbers.put("ده", 10.0);
        persianNumbers.put("یازده",11.0);
        persianNumbers.put("دوازده",12.0);
        persianNumbers.put("سیزده",13.0);
        persianNumbers.put("چهارده",14.0);
        persianNumbers.put("پانزده",15.0);
        persianNumbers.put("شانزده",16.0);
        persianNumbers.put("هفده",17.0);
        persianNumbers.put("هچده",18.0);
        persianNumbers.put("نوزده",19.0);
        persianNumbers.put("بیست",20.0);
        persianNumbers.put("سی",30.0);
        persianNumbers.put("چهل",40.0);
        persianNumbers.put("پنجاه",50.0);
        persianNumbers.put("شصت",60.0);
        persianNumbers.put("هفتاد",70.0);
        persianNumbers.put("هشتاد", 80.0);
        persianNumbers.put("نود", 90.0);
        persianNumbers.put("صد", 100.0);
        persianNumbers.put("دویست", 200.0);
        persianNumbers.put("سیصد", 300.0);
        persianNumbers.put("چهارصد", 400.0);
        persianNumbers.put("پانصد", 500.0);
        persianNumbers.put("ششصد", 600.0);
        persianNumbers.put("هفتصد", 700.0);
        persianNumbers.put("هشتصد", 800.0);
        persianNumbers.put("نهصد", 900.0);
        persianNumbers.put("هزار", 1000.0);
        persianNumbers.put("میلیون", 1000000.0);
        persianNumbers.put("میلیارد", 1000000000.0);
    }

    public static double convertPersianToDouble(String persianNumber) {
        String[] parts = persianNumber.split(" ");
        double result = 0.0;
        double currentNumber = 0.0;

        for (String part : parts) {
            System.out.println(part);
            if (part.equals("و"))
                continue;
            if (persianNumbers.get(part) == null)
                System.out.println("Couldn't get " + part);
            double value = persianNumbers.get(part);
            if (value >= 1000) {
                result += currentNumber * value;
                currentNumber = 0.0;
            } else {
                currentNumber += value;
            }
        }

        return result + currentNumber;
    }
}

public class checkcontroller {
    @FXML
    private Button Back;
    @FXML
    public Label checkToNum2;
    @FXML
    private Label checkdata2;
    @FXML
    public Label checkamount2;
    @FXML
    public Label checkid2;
    @FXML
    private Label checkToNum;

    @FXML
    private TextField checkToNum1;

    @FXML
    private Label checkamount;

    @FXML
    private TextField checkamountDigit;

    @FXML
    private TextField checkamountNum;

    @FXML
    private Label checkdata;

    @FXML
    private AnchorPane checkdata1;

    @FXML
    private Label checkid;

    @FXML
    private TextField checkid1;

    @FXML
    private Label dataprice;

    @FXML
    private TextField day;

    @FXML
    private ImageView imgBack;

    @FXML
    private Label lbltransfer;

    @FXML
    private ListView<?> listTransfer;

    @FXML
    private TextField month;

    @FXML
    private AnchorPane showcheck;

    @FXML
    private TextField year;

    @FXML
    private Label amount;

    @FXML
    private AnchorPane dayloan;

    @FXML
    private AnchorPane weekloan;

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
    void Back(ActionEvent event) throws IOException {
        Stage stage =(Stage) Back.getScene().getWindow();
        stage.close();
        Stage primaryStage=new Stage();
        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("Main.fxml"));
        Scene scene = new Scene(root, 719, 592);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

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
        if(checkid2.isVisible()){
            alert.setContentText("اطلاعات چک با موفقیت در سامانه ثبت و تایید شد!");
            alert.showAndWait();
            Cheque cheque = new Cheque(Double.parseDouble(checkamountNum.getText()),
                    DataRepository.user,
                    DataRepository.userManager.getUser(checkToNum1.getText()),
                    LocalDate.of(Integer.parseInt(year.getText()),
                            Integer.parseInt(month.getText()),
                            Integer.parseInt(day.getText())));
            DataRepository.chequeManager.add(cheque);

            Stage stage=new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Main.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("");
            stage.setScene(scene);
            stage.show();}
        else{
            Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setContentText("تمامی فیلد های خالی را تکمیل کنید!");
            alert1.showAndWait();
        }

}

    @FXML
    void showcheck(ActionEvent event) throws InterruptedException {

        for(Field field: getClass().getDeclaredFields()){
            if(TextField.class.isAssignableFrom(field.getType())){

                try {
                    boolean full = !((TextField) field.get(this)).getText().isEmpty();
                    if (!full) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Bruh");
                        alert.setContentText("please fill " + ((TextField) field.get(this)).getId());
                        alert.showAndWait();
                        return;
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        String text = checkamountDigit.getText();
        double number = PersianNumberer.convertPersianToDouble(text);
        String amount = checkamountNum.getText();
        if (number == Double.parseDouble(amount)){
            checkdata.setText(year.getText() + "/" + month.getText() + "/" + day.getText());
            checkToNum.setText(checkToNum1.getText());
            checkamount.setText(checkamountNum.getText());
            checkid.setText(checkid1.getText());
            checkid.setVisible(true);
            checkid2.setVisible(true);
            checkamount.setVisible(true);
            checkamount2.setVisible(true);
            checkdata.setVisible(true);
            checkdata2.setVisible(true);
            checkToNum.setVisible(true);
            checkToNum2.setVisible(true);}
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("مقدار حروفی و رقمی مبلغ وارد شده یکسان نمیباشد!");
            alert.showAndWait();
        }




    }
}
