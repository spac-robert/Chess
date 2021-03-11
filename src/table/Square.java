package table;

import pieces.Piece;

public class Square {
    private boolean isOccupied;
    private Piece piece;

    public Square() {
        this.isOccupied = false;
    }

    public Square(boolean isOccupied, Piece piece) {
        this.isOccupied = isOccupied;
        this.piece = piece;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public Piece getPiece() {
        return piece;
    }
}
