/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.app;

import tictactoe.model.Game;

/**
 *
 * @author Thomas
 */
public class GameInstance {
    
    private static GameInstance instance = null;
    
    private Game game;

    private GameInstance() {
        game = new Game();
    }
    
    public static GameInstance getInstance() {
        if (instance == null) {
            instance = new GameInstance();
        }
        return instance;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
