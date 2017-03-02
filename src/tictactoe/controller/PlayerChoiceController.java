/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tictactoe.app.GameInstance;

/**
 * FXML Controller class
 *
 * @author Thomas
 */
public class PlayerChoiceController implements Initializable {

    @FXML
    public TextField playerOne;

    @FXML
    public TextField playerTwo;
    
    private Stage stage;
    private Scene scene;
    private Scene previousScene;
    
    private GameInstance gameInstance = GameInstance.getInstance();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        playerOne.setText(gameInstance.getGame().getPlayerOne().getName());
        playerTwo.setText(gameInstance.getGame().getPlayerTwo().getName());
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

    public Scene getPreviousScene() {
        return previousScene;
    }

    public void setPreviousScene(Scene previousScene) {
        this.previousScene = previousScene;
    }

    public void play() {
        try {
            gameInstance.getGame().setPlayersName(playerOne.getText(), playerTwo.getText());
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/tictactoe/view/Game.fxml"));

            Parent parent = (Parent) loader.load();

            Scene scene = new Scene(parent);

            GameController controller = loader.getController();
            controller.setStage(stage);
            controller.setScene(scene);

            stage.setScene(scene);
        } catch (IOException ex) {
            System.out.println(ex);
        }
        
    }

    public void back() {
        stage.setScene(previousScene);
    }
}
