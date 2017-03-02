/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import tictactoe.app.GameInstance;
import tictactoe.model.CellButton;
import tictactoe.model.Game;
import tictactoe.model.Player;

/**
 * FXML Controller class
 *
 * @author Thomas
 */
public class GameController implements Initializable {

    @FXML
    public VBox playerOne;

    @FXML
    public VBox playerTwo;

    @FXML
    public GridPane grid;

    private Stage stage;
    private Scene scene;

    private GameInstance gameInstance = GameInstance.getInstance();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fillPlayerOnePanel();
        fillPlayerTwoPanel();
        initializeGrid();
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
        Player player = gameInstance.getGame().getPlayerOne();

        Label name = new Label(player.getName());
        name.setId("playerOneName");

        Label victories = new Label(String.valueOf(player.getScore().getVictories()));
        victories.setId("playerOneVictories");

        Label defeats = new Label(String.valueOf(player.getScore().getDefeats()));
        defeats.setId("playerOneDefeats");

        Label equalities = new Label(String.valueOf(player.getScore().getEqualities()));
        equalities.setId("playerOneEqualities");

        playerOne.getChildren().addAll(name, victories, defeats, equalities);
    }

    private void fillPlayerTwoPanel() {
        Player player = gameInstance.getGame().getPlayerTwo();

        Label name = new Label(player.getName());
        name.setId("playerTwoName");

        Label victories = new Label(String.valueOf(player.getScore().getVictories()));
        victories.setId("playerTwoVictories");

        Label defeats = new Label(String.valueOf(player.getScore().getDefeats()));
        defeats.setId("playerTwoDefeats");

        Label equalities = new Label(String.valueOf(player.getScore().getEqualities()));
        equalities.setId("playerTwoEqualities");

        playerTwo.getChildren().addAll(name, victories, defeats, equalities);
    }

    private void updatePlayerOnePanel() {
        Player player = gameInstance.getGame().getPlayerOne();
        
        Label victories = (Label) scene.lookup("#playerOneVictories");
        victories.setText(String.valueOf(player.getScore().getVictories()));

        Label defeats = (Label) scene.lookup("#playerOneDefeats");
        defeats.setText(String.valueOf(player.getScore().getDefeats()));

        Label equalities = (Label) scene.lookup("#playerOneEqualities");
        equalities.setText(String.valueOf(player.getScore().getEqualities()));
    }
    
    private void updatePlayerTwoPanel() {
        Player player = gameInstance.getGame().getPlayerTwo();
        
        Label victories = (Label) scene.lookup("#playerTwoVictories");
        victories.setText(String.valueOf(player.getScore().getVictories()));

        Label defeats = (Label) scene.lookup("#playerTwoDefeats");
        defeats.setText(String.valueOf(player.getScore().getDefeats()));

        Label equalities = (Label) scene.lookup("#playerTwoEqualities");
        equalities.setText(String.valueOf(player.getScore().getEqualities()));
    }

    private void initializeGrid() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                CellButton cellButton = createButton(i, j);
                grid.add(cellButton, i, j);
            }
        }
    }

    private CellButton createButton(int x, int y) {
        CellButton cellButton = new CellButton(x, y);

        cellButton.setMinWidth(133);
        cellButton.setMinHeight(133);

        cellButton.setOnAction((event) -> {
            Game game = gameInstance.getGame();
            if (game.getMark(x, y) == null) {
                String str = " ";
                game.mark(x, y);
                if (game.getMark(x, y)) {
                    str = "X";
                } else {
                    str = "O";
                }
                cellButton.setText(str);

                int state;
                if ((state = game.checkVictory()) != 0) {
                    newParty(state);
                }
            }
        });

        return cellButton;
    }

    private void newParty(int state) {
        initializeGrid();
        gameInstance.getGame().newParty();
        updatePlayerOnePanel();
        updatePlayerTwoPanel();
        
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Partie terminée");
        
        String str = "Nouvelle partie";
        if (state == 1) {
            str = "Le joueur 1 gagne!";
        } else if (state == 2) {
            str = "Le joueur 2 gagne!";
        } else if (state == 3) {
            str = "Egalité!";
        }
        alert.setContentText(str);
        alert.show();
    }
}
