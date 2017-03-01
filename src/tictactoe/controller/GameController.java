/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import tictactoe.app.GameInstance;

/**
 * FXML Controller class
 *
 * @author Thomas
 */
public class GameController implements Initializable {

    private Stage stage;
    private Scene scene;
    
    private GameInstance gameInstance = GameInstance.getInstance();

    @FXML
    public VBox playerOne;

    @FXML
    public VBox playerTwo;

    @FXML
    public Label playerOneName;

    @FXML
    public Label playerTwoName;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fillPlayerOnePanel();
        fillPlayerTwoPanel();
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
    
    private void fillPlayerOnePanel() {
        playerOneName.setText(gameInstance.getGame().getPlayerOne().getName());
    }
    
    private void fillPlayerTwoPanel() {
        playerTwoName.setText(gameInstance.getGame().getPlayerTwo().getName());
    }
}
