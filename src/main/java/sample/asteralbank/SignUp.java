package sample.asteralbank;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import com.blackbank.bank.Gender;
import com.blackbank.bank.Person;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SignUp implements Initializable  {

    @FXML
    private MenuItem MenulitemLoan;

    @FXML
    private MenuItem MenulitemSaving;

    @FXML
    private MenuItem MenultemFemale;

    @FXML
    private MenuItem MenultemMale;

    @FXML
    private SplitMenuButton splitGender;

    @FXML
    private Button Back;

    @FXML
    private Label lblEror;

    @FXML
    private TextField TxtBirthdayDay;

    @FXML
    private TextField TxtBirthdayMonth;

    @FXML
    private TextField TxtBirthdayYear;

    @FXML
    private TextField TxtEmail;

    @FXML
    private TextField TxtGender;

    @FXML
    public TextField TxtFirstName;

    @FXML
    private TextField TxtLastName;

    @FXML
    private TextField TxtNIN;

    @FXML
    private PasswordField TxtPassword;

    @FXML
    private TextField TxtPhoneNumber;

    @FXML
    private TextField TxtPostCode;

    @FXML
    public TextField TxtUserName;

    @FXML
    private Button btnSignUp;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    @FXML
    void Back(ActionEvent event) throws IOException {
        Stage stage =(Stage) Back.getScene().getWindow();
        stage.close();
        Stage primaryStage=new Stage();
        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("Signin.fxml"));
        Scene scene = new Scene(root, 386, 588);
        stage.getIcons().add(new Image(HelloController.class.getResourceAsStream("Icon.jpg")));
        stage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    @FXML
    void MenulitemLoan(ActionEvent event) {

    }

    @FXML
    void MenulitemSaving(ActionEvent event) {

    }


    Gender gender;
    @FXML
    void MenultemFemale(ActionEvent event) {
        gender = Gender.FEMALE;
    }

    @FXML
    void MenultemMale(ActionEvent event) {
        gender = Gender.MALE;
    }
    @FXML
    void splitGender(ActionEvent event) {
    }

    @FXML
    void SignUp(ActionEvent event) throws IOException {
        String name = TxtFirstName.getText() + " " + TxtLastName.getText();
        Gender gender = this.gender; //Gender.valueOf(TxtGender.getText());
        LocalDate birthDate = LocalDate.of(Integer.parseInt(TxtBirthdayYear.getText()),
                                            Integer.parseInt(TxtBirthdayMonth.getText()),
                                            Integer.parseInt(TxtBirthdayDay.getText()));
        Person person = new Person(name, gender, birthDate);
        String password = TxtPassword.getText();
        String cardNumber = DataRepository.userManager.addAccount(password, person, 100);
        DataRepository.userManager.activateUser(cardNumber);
        DataRepository.user = DataRepository.userManager.login(cardNumber, password);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText("Your card number is " + cardNumber);
        alert.showAndWait();
        Stage stage =(Stage) btnSignUp.getScene().getWindow();
        stage.close();
        Stage primaryStage=new Stage();
        stage.getIcons().add(new Image(HelloController.class.getResourceAsStream("Icon.jpg")));
        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("Main.fxml"));
        Scene scene = new Scene(root, 727, 592);
        stage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();


    }

    void setUserInformation() {
        String cardNumber = DataRepository.user.getUsername();

    }

}
