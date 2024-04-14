package sample.asteralbank;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Manager {

    @FXML
    private Button Exit;

    @FXML
    private ListView<?> ListAdmin;

    @FXML
    private ListView<?> ListLastTransfers;

    @FXML
    private ListView<?> ListUsersData;

    @FXML
    private Button Settings;

    @FXML
    private Tab TabAdmin;

    @FXML
    private Tab TabLastTransfers;

    @FXML
    private TabPane TabPane;

    @FXML
    private Tab TabUsersData;

    @FXML
    private ImageView imgExit;

    @FXML
    private ImageView imgSettings;

    @FXML
    void Exit(ActionEvent event) throws IOException {
        Stage stage =(Stage) Exit.getScene().getWindow();
        stage.close();
        Stage primaryStage=new Stage();
        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("Signin.fxml"));
        Scene scene = new Scene(root, 389, 588);
        stage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    @FXML
    void Settings(ActionEvent event) {

    }

}
