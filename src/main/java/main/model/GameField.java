package main.model;

public class GameField {

    private final Cell[][] board;

    public GameField() {
        board = new Cell[][] {
                {new Cell(' '), new Cell(' '), new Cell(' ')},
                {new Cell(' '), new Cell(' '), new Cell(' ')},
                {new Cell(' '), new Cell(' '), new Cell(' ')},
       };
    }

    public void place(int row, int column, char value) {
        board[row][column].setValue(value);
    }

    public Cell[][] getBoard() {
        return board;
    }

    public Cell getCell(int row, int column) {
        return board[row][column];
    }

    public boolean hasEmptyCells() {
        for (Cell[] row : board) {
            for (Cell cell : row) {
                if (cell.isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isFree(int row, int column) {
        return board[row][column].isEmpty();
    }
}
