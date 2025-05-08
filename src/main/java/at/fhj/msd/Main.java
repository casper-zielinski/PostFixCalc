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
              Parent root = FXMLLoader.load(getClass().getResource("/MainScene.fxml")); // Load the FXML file
              Scene scene = new Scene(root);    // Create a new scene with the loaded root node
              scene.getStylesheets().add(getClass().getResource("/styles/style.css").toExternalForm()); // Add the CSS stylesheet to the scene



              primaryStage.setTitle("Post Fix Calculator");
              primaryStage.setScene(scene);
              primaryStage.show(); // Show the primary stage
              } 
              catch (IOException ex) {
                  System.out.println("IOException Error, File either not found/corrupted etc.");
              }
    }
    
      public static void main(String[] args) {
            launch(args);
      }

}
