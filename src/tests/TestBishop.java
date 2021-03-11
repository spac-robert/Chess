package tests;

import common.Location;
import pieces.Bishop;
import pieces.Piece;
import pieces.PieceColor;

import java.util.Locale;

public class TestBishop {

    private void createBishop() {
        Location location = new Location(4, 5);
        Piece piece = new Bishop(location, PieceColor.WHITE);
        assert piece.getPieceColor() == PieceColor.WHITE;
        assert piece.getName() == 'B';
    }

    private void testSetters() {
        Location location = new Location(4, 5);
        Piece piece = new Bishop(location, PieceColor.WHITE);
        piece.setName("Ana");
        assert piece.getName() == 'A';
        piece.setLocation(new Location(10, 20));
        location = new Location(10,20);
        assert piece.getLocation().equals(new Location(10, 20));
    }

    private void testValidMoves() {
        Location location = new Location(4, 5);
        Piece piece = new Bishop(location, PieceColor.BLACK);
        assert piece.isValidMove(4, 5, 5, 6);
    }

    public void runTestBishop() {
        this.createBishop();
        this.testValidMoves();
        this.testSetters();
    }
}
