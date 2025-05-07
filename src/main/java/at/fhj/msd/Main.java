package at.fhj.msd;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

@Override
      public void start(Stage primaryStage) {
        
          try {

              Parent root = FXMLLoader.load(getClass().getResource("/MainScene.fxml"));
              Scene scene = new Scene(root);


              primaryStage.setTitle("Post Fix Calculator");
              primaryStage.setScene(scene);
              primaryStage.show();
              } 
              catch (IOException ex) {
                  System.out.println("IOException Error, File either not found/corrupted etc.");
              }


    }
    
      public static void main(String[] args) {
            launch(args);
      }

}
