package sample.asteralbank;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Signin.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.getIcons().add(new Image(HelloController.class.getResourceAsStream("Icon.jpg")));
        stage.setResizable(false);
        stage.setTitle("Astral");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        MyLog.setPath("MY_LOG.txt");
        launch();
    }
}