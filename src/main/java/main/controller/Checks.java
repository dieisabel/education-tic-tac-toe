package main.controller;

import main.model.Cell;

import java.util.Optional;

public class Checks {

    Cell[][] board;

    public Checks(Cell[][] board) {
        this.board = board;

    }

    public Optional<Character> winCondition() {
        Optional<Character> winner = Optional.empty();
        if (checkRows('X') || checkColumns('X') || checkDiagonals('X')) {
            winner = Optional.of('X');
        }
        if (checkRows('O') || checkColumns('O') || checkDiagonals('O')) {
            winner = Optional.of('O');
        }
        return winner;
    }

    private boolean checkRows(char value) {
        /* Проход по рядам */
        int counter = 0;
        for (Cell[] row : board) {
            counter = 0;
            for (Cell cell : row) {
                if (cell.getValue() == value) {
                    counter++;
                } else {
                    break;
                }
            }
            if (counter == board.length) {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumns(char value) {
        /* Проход по столбикам */
        int counter = 0;
        for (int i = 0; i < board.length; i++) {
            counter = 0;
            for (int j = 0; j < board.length; j++) {
                int element = board[j][i].getValue();
                if (element == value) {
                    counter++;
                } else {
                    break;
                }
            }
            if (counter == board.length) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonals(char value) {
        /* Проход по диагоналям */
        int counter;

        // Главная диагональ
        counter = 0;
        for (int i = 0; i < board.length; i++) {
            int element = board[i][i].getValue();
            if (element == value) {
                counter++;
            } else {
                break;
            }
        }
        if (counter == board.length) {
            return true;
        }

        // Побочная диагональ
        counter = 0;
        for (int i = 0; i < board.length; i++) {
            int element = board[i][board.length - 1 - i].getValue();
            if (element == value) {
                counter++;
            } else {
                break;
            }
        }
        if (counter == board.length) {
            return true;
        }
        return false;
    }
}
