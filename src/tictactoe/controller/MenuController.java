/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Thomas
 */
public class MenuController implements Initializable {

    private Stage stage;
    private Scene scene;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public void startGame() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/tictactoe/view/PlayerChoice.fxml"));

            Parent parent = (Parent) loader.load();

            Scene scene = new Scene(parent);

            PlayerChoiceController controller = loader.getController();
            controller.setStage(stage);
            controller.setScene(scene);
            controller.setPreviousScene(this.scene);

            stage.setScene(scene);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public void quit() {
        System.exit(0);
    }
}
