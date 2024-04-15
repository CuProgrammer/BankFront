package sample.asteralbank;

import com.blackbank.bank.Gender;
import com.blackbank.bank.Person;
import com.blackbank.bank.UserManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Signin.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 386,588);
        stage.getIcons().add(new Image(HelloController.class.getResourceAsStream("Icon.jpg")));
        stage.setResizable(false);
        stage.setTitle("Astral");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}