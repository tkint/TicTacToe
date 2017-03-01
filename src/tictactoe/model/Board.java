/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.model;

import java.util.ArrayList;

/**
 *
 * @author tkint
 */
public class Board {

    private ArrayList<Cell> cells;

    public Board() {
        generate();
    }

    public ArrayList<Cell> getCells() {
        return cells;
    }

    public void setCells(ArrayList<Cell> cells) {
        this.cells = cells;
    }

    public Cell getCell(int x, int y) {
        Cell cell = null;
        int i = 0;
        while (i < this.cells.size()) {
            if (this.cells.get(i).getX() == x && this.cells.get(i).getY() == y) {
                cell = this.cells.get(i);
            }
            i++;
        }
        return cell;
    }

    private void generate() {
        this.cells = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.cells.add(new Cell(j, i));
            }
        }
    }

    @Override
    public String toString() {
        String str = "";
        for (Cell cell : cells) {
            str += "|";
            if (cell.getMark() == null) {
                str += " ";
            } else if (cell.getMark()) {
                str += "X";
            } else {
                str += "O";
            }
            str += "|";
            if (cell.getX() == 2) {
                str += "\n";
            }
        }
        return str;
    }
}
