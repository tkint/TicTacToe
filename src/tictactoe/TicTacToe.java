/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import tictactoe.model.Game;
import tictactoe.model.Player;

/**
 *
 * @author tkint
 */
public class TicTacToe extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //launch(args);
        Game game= new Game("Toto", "Tata");
        System.out.println(game.getBoard().toString());
        game.mark(0, 0);
        System.out.println(game.getBoard().toString());
        game.mark(1, 1);
        System.out.println(game.getBoard().toString());
        game.mark(1, 0);
        System.out.println(game.getBoard().toString());
        game.mark(2, 1);
        System.out.println(game.getBoard().toString());
        game.mark(2, 0);
        System.out.println(game.getBoard().toString());
    }
    
}
