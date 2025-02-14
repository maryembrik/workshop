package Test;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class Mainfx extends Application {
        @Override
        public void start(Stage primaryStage) throws Exception {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);

    }
    public Mainfx(String[] args) {
        launch(args);
    }

}

