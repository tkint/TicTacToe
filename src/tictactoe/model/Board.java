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
        cells = new ArrayList<>();
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
        while (i < cells.size()) {
            if (cells.get(i).getX() == x
                    && cells.get(i).getY() == y) {
                cell = cells.get(i);
            }
            i++;
        }
        return cell;
    }

    private void generate() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells.add(new Cell(j, i));
            }
        }
    }

    public boolean isFull() {
        int i = 0;
        boolean full = true;
        while (i < cells.size() && full) {
            if (cells.get(i).getMark() != null) {
                full = false;
            }
            i++;
        }
        return full;
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
