/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.model;

/**
 *
 * @author tkint
 */
public class Score {

    private int parties;
    private int wins;
    private int looses;
    private int exAequo;

    public Score() {
        this.parties = 0;
        this.wins = 0;
        this.looses = 0;
        this.exAequo = 0;
    }

    public int getParties() {
        return parties;
    }

    public void setParties(int parties) {
        this.parties = parties;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLooses() {
        return looses;
    }

    public void setLooses(int looses) {
        this.looses = looses;
    }

    public int getExAequo() {
        return exAequo;
    }

    public void setExAequo(int exAequo) {
        this.exAequo = exAequo;
    }

    public void addWin() {
        this.wins++;
    }

    public void addLoose() {
        this.looses++;
    }

    public void addExAequo() {
        this.exAequo++;
    }
}
