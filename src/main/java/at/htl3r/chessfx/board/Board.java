package at.htl3r.chessfx.board;

import at.htl3r.chessfx.pieces.ChessPiece;
import at.htl3r.chessfx.pieces.ChessPieceType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.HashMap;

public class Board {

    private int boardWidth;
    private int boardHeight;

    private static Tile[][] board;
    private static HashMap<String, ChessPiece> pieces;

    public Board(VBox grid) {
        Board.board = new Tile[8][8];
        this.boardWidth = 800;
        this.boardHeight = 800;

        grid.setMaxSize(this.boardWidth, this.boardHeight);
        grid.setPrefSize(this.boardWidth, this.boardHeight);
        grid.setMinSize(this.boardWidth, this.boardHeight);

        for (int i = 0; i < 8; i++) {
            HBox row = new HBox();
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 == 0) Board.board[i][j] = new Tile(true, j, i);
                else Board.board[i][j] = new Tile(false, j, i);
                row.getChildren().add(Board.board[i][j]);
            }
            grid.getChildren().add(row);
        }
    }

    public void init() {
        // Add Pawns
        for (int i = 0; i < 8; i++) {
            Board.board[1][i].addPiece(new ChessPiece(ChessPieceType.Pawn, true));
            Board.board[6][i].addPiece(new ChessPiece(ChessPieceType.Pawn, false));
        }

        // Add Towers
        Board.board[0][0].addPiece(new ChessPiece(ChessPieceType.Tower, true));
        Board.board[0][7].addPiece(new ChessPiece(ChessPieceType.Tower, true));
        Board.board[7][0].addPiece(new ChessPiece(ChessPieceType.Tower, false));
        Board.board[7][7].addPiece(new ChessPiece(ChessPieceType.Tower, false));

        // Add Knights
        Board.board[0][1].addPiece(new ChessPiece(ChessPieceType.Knight, true));
        Board.board[0][6].addPiece(new ChessPiece(ChessPieceType.Knight, true));
        Board.board[7][1].addPiece(new ChessPiece(ChessPieceType.Knight, false));
        Board.board[7][6].addPiece(new ChessPiece(ChessPieceType.Knight, false));

        // Add Bishops
        Board.board[0][2].addPiece(new ChessPiece(ChessPieceType.Bishop, true));
        Board.board[0][5].addPiece(new ChessPiece(ChessPieceType.Bishop, true));
        Board.board[7][2].addPiece(new ChessPiece(ChessPieceType.Bishop, false));
        Board.board[7][5].addPiece(new ChessPiece(ChessPieceType.Bishop, false));

        // Add Kings
        Board.board[0][4].addPiece(new ChessPiece(ChessPieceType.King, true));
        Board.board[7][4].addPiece(new ChessPiece(ChessPieceType.King, false));

        // Add Queens
        Board.board[0][3].addPiece(new ChessPiece(ChessPieceType.Queen, true));
        Board.board[7][3].addPiece(new ChessPiece(ChessPieceType.Queen, false));

        Tile.removePiece("A1");
    }

    public static Tile[][] getBoard() {
        return board;
    }

    public static void setBoard(Tile[][] board) {
        Board.board = board;
    }

    public static HashMap<String, ChessPiece> getPieces() {
        return pieces;
    }

    public static void setPieces(HashMap<String, ChessPiece> pieces) {
        Board.pieces = pieces;
    }

    public int getBoardHeight() {
        return this.boardHeight;
    }

    public void setBoardHeight(int boardHeight) {
        this.boardHeight = boardHeight;
    }

    public int getBoardWidth() {
        return this.boardWidth;
    }

    public void setBoardWidth(int boardWidth) {
        this.boardWidth = boardWidth;
    }
}
