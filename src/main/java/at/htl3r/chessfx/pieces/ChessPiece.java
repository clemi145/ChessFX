package at.htl3r.chessfx.pieces;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;

public class ChessPiece extends ImageView {
    private ChessPieceType type;
    private boolean color;
    private String position;

    private ImageView icon;

    public ChessPiece(ChessPieceType type, boolean color) {
        this.type = type;
        this.color = color;

        String path;
        if (this.color) path = "black_";
        else path = "white_";

        switch (this.type) {
            case Pawn -> path = path.concat("pawn.png");
            case Bishop -> path = path.concat("bishop.png");
            case Knight -> path = path.concat("knight.png");
            case Tower -> path = path.concat("tower.png");
            case Queen -> path = path.concat("queen.png");
            case King -> path = path.concat("king.png");
            default -> path = "not_found.png";
        }

        this.icon = new ImageView(new Image(path));
        this.icon.setFitWidth(80);
        this.icon.setFitHeight(80);
        this.icon.setSmooth(true);
    }

    public void move(String position) {
        this.position = position;
    }

    public ChessPieceType getType() {
        return type;
    }

    public void setType(ChessPieceType type) {
        this.type = type;
    }

    public boolean getColor() {
        return color;
    }

    public void setColor(boolean color) {
        this.color = color;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public ImageView getIcon() {
        return icon;
    }

    public void setIcon(ImageView icon) {
        this.icon = icon;
    }
}
