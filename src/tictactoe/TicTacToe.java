/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import tictactoe.controller.MenuController;
import tictactoe.model.Game;
import tictactoe.model.Player;

/**
 *
 * @author tkint
 */
public class TicTacToe extends Application {
    
    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/tictactoe/view/Menu.fxml"));
            
            Parent parent = (Parent)loader.load();
            
            Scene scene = new Scene(parent);
            
            MenuController controller = loader.getController();
            controller.setStage(stage);
            controller.setScene(scene);
            
            stage.setTitle("TicTacToe");
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
