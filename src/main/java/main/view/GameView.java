package main.view;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import main.controller.Controller;
import main.model.GameField;

import java.util.Optional;

public class GameView {

    public void showEndGameAlert(String text) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("End game");
        alert.setContentText(text);
        alert.showAndWait();
    }

    public boolean showExitConfirmationAlert() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Are you sure you want to exit?");
        Optional<ButtonType> answer = alert.showAndWait();
        return answer.filter(buttonType -> buttonType == ButtonType.OK).isPresent();
    }

    public void drawGrid(AnchorPane pane, GameField gameField, Controller controller) {
        pane.getChildren().clear();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Tile tile = new Tile(gameField.getCell(i, j));
                tile.row = i;
                tile.column = j;
                tile.setTranslateX(j * 200);
                tile.setTranslateY(i * 200);
                tile.setOnMouseClicked(controller::process);
                pane.getChildren().add(tile);
            }
        }
    }
}
