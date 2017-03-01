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
    private int equalities;

    public Score() {
        parties = 0;
        wins = 0;
        looses = 0;
        equalities = 0;
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

    public int getEqualities() {
        return equalities;
    }

    public void setEqualities(int equalities) {
        this.equalities = equalities;
    }

    public void addWin() {
        wins++;
    }

    public void addLoose() {
        looses++;
    }

    public void addEqualities() {
        equalities++;
    }
}
