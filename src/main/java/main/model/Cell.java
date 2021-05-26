package main.model;

public class Cell {
    /* Ячейка игрового поля
     *
     * Имеет поле value, по которому можно определить, кому принадлежит данная ячейка:
     * 0 - пустая
     * 1 - игроку
     * 2 - компьютеру
     */

    private char value;

    public Cell(char value) {
        this.value = value;
    }

    public void setValue(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }

    public boolean isEmpty() {
        return value == ' ';
    }
}