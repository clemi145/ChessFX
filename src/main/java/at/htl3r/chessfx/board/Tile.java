package at.htl3r.chessfx.board;

import at.htl3r.chessfx.pieces.ChessPiece;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class Tile extends Pane {

    private boolean color;
    private String position;

    public Tile(boolean color, String position) {
        this.color = color;
        this.setMaxSize(100, 100);
        this.setPrefSize(100, 100);
        this.setMinSize(100, 100);

        String backgroundColor;
        if (color) backgroundColor = "-fx-background-color: black";
        else backgroundColor = "-fx-background-color: white";
        this.setStyle(backgroundColor);
    }

    public Tile(boolean color, int x, int y) {
        this.color = color;
        this.position = Tile.toPosition(x, y);
        this.setMaxSize(100, 100);
        this.setPrefSize(100, 100);
        this.setMinSize(100, 100);

        String backgroundColor;
        if (color) backgroundColor = "-fx-background-color: black";
        else backgroundColor = "-fx-background-color: white";
        this.setStyle(backgroundColor);
    }

    public static int[] parsePosition(String position) {
        return new int[]{position.charAt(0) - 64, Character.getNumericValue(position.charAt(1))};
    }

    public static String toPosition(int x, int y) {
        return Character.toString(Integer.toString(x).charAt(0) + 64).concat(Integer.toString(y));
    }

    public void addPiece(ChessPiece piece) {
        piece.setPosition(this.position);
        BorderPane tile = new BorderPane(piece.getIcon());
        tile.setMaxSize(100, 100);
        tile.setPrefSize(100, 100);
        tile.setMinSize(100, 100);
        this.getChildren().add(tile);
    }

    public static void removePiece(String position) {
        this.getChildren().re
        Board.getPieces().remove(position);
    }
}
