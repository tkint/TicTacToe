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
    private int victories;
    private int defeats;
    private int equalities;

    public Score() {
        parties = 0;
        victories = 0;
        defeats = 0;
        equalities = 0;
    }

    public int getParties() {
        return parties;
    }

    public void setParties(int parties) {
        this.parties = parties;
    }

    public int getVictories() {
        return victories;
    }

    public void setVictories(int victories) {
        this.victories = victories;
    }

    public int getDefeats() {
        return defeats;
    }

    public void setDefeats(int defeats) {
        this.defeats = defeats;
    }

    public int getEqualities() {
        return equalities;
    }

    public void setEqualities(int equalities) {
        this.equalities = equalities;
    }

    public void addVictory() {
        victories++;
    }

    public void addDefeat() {
        defeats++;
    }

    public void addEqualities() {
        equalities++;
    }
}
