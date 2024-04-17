package sample.asteralbank;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class TurnOver {

    @FXML
    private Button Back;

    @FXML
    private ListView<?> ListTurnOver;

    @FXML
    private ImageView imgBack;

    @FXML
    private Label lblTurnOver;

    @FXML
    void Back(ActionEvent event) throws IOException {
        Stage stage =(Stage) Back.getScene().getWindow();
        stage.close();
        MyLog.log("User saw its turnover");
        Stage primaryStage=new Stage();
        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("Main.fxml"));
        Scene scene = new Scene(root, 727, 592);
        stage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

}
