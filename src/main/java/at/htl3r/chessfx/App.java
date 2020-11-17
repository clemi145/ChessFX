package at.htl3r.chessfx;

import at.htl3r.chessfx.board.Board;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        VBox grid = new VBox();
        Board gameBoard = new Board(grid);
        gameBoard.init();

        Scene primaryScene = new Scene(grid);
        primaryStage.setTitle("ChessFX");
        primaryStage.setScene(primaryScene);
        primaryStage.show();
    }
}
