package pieces;

import common.Location;

import java.util.Objects;

public abstract class Piece implements Movable {
    protected Location location;
    protected String name;
    protected PieceColor pieceColor;

    public Piece(Location location, PieceColor pieceColor) {
        this.location = location;
        this.pieceColor = pieceColor;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Character getName() {
        return name.charAt(0);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPieceColor(PieceColor pieceColor) {
        this.pieceColor = pieceColor;
    }

    public PieceColor getPieceColor() {
        return pieceColor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piece piece = (Piece) o;
        return Objects.equals(location, piece.location) && Objects.equals(name, piece.name) && pieceColor == piece.pieceColor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(location, name, pieceColor);
    }
}
