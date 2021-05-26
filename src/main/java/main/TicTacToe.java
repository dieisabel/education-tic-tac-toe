package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.controller.Controller;
import main.view.GameView;

import java.io.IOException;
import java.util.Objects;

public class TicTacToe extends Application {

    Stage window;

    private final Controller controller = new Controller();
    private final GameView gameView = new GameView();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        window = primaryStage;
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main.fxml")));
        window.setTitle("Tic-Tac-Toe");
        window.setScene(new Scene(root, 600, 600));
        window.show();
        window.setOnCloseRequest(event -> {
            event.consume();
            closeProgram();
        });
        window.show();
    }

    private void closeProgram() {
        if (gameView.showExitConfirmationAlert()) {
            window.close();
        }
    }
}
