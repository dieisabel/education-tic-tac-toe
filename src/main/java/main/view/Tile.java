package main.view;

import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import main.model.Cell;

public class Tile extends StackPane {

    public int row;
    public int column;

    public Tile(Cell cell) {
        Rectangle border = new Rectangle(200, 200);
        border.setFill(null);
        border.setStroke(Color.BLACK);

        Text text = new Text();
        text.setText(Character.toString(cell.getValue()));
        text.setFont(Font.font(72));

        setAlignment(Pos.CENTER);
        getChildren().addAll(border, text);
    }
}
