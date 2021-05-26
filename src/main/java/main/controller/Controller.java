package main.controller;

import javafx.fxml.FXML;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import main.model.GameField;
import main.view.GameView;
import main.view.Tile;

import java.util.Random;

public class Controller {

    @FXML
    private AnchorPane pane;

    GameField gameField;
    GameView gameView;
    Checks checks;
    boolean playerTurn = true;

    public void initialize() {
        gameField = new GameField();
        gameView = new GameView();
        gameView.drawGrid(pane, gameField, this);
        checks = new Checks(gameField.getBoard());
    }

    public void process(MouseEvent event) {
        Tile tile = (Tile) event.getSource();
        if (event.getButton() == MouseButton.PRIMARY) {
            if (playerTurn) {
                if (playerMove(tile)) {
                    playerTurn = false;
                }
            } else {
                computerMove();
                playerTurn = true;
            }
        }
        if (!gameField.hasEmptyCells()) {
            gameView.showEndGameAlert("Withdraw");
        }
        gameView.drawGrid(pane, gameField, this);
    }

    private boolean playerMove(Tile tile) {
        if (gameField.isFree(tile.row, tile.column) && gameField.hasEmptyCells()) {
            gameField.place(tile.row, tile.column, 'X');
            return true;
        }
        if (checks.winCondition().orElse(' ') == 'X') {
            gameView.showEndGameAlert("You win!");
        }
        return false;
    }

    private void computerMove() {
        if (!gameField.hasEmptyCells()) {
            return;
        }
        Random random = new Random();
        while (true) {
            int row = random.nextInt(3);
            int column = random.nextInt(3);
            if (gameField.isFree(row, column)) {
                gameField.place(row, column, 'O');
                break;
            }
        }
        if (checks.winCondition().orElse(' ') == 'O') {
            gameView.showEndGameAlert("Computer wins! You lose!");
        }
    }
}
