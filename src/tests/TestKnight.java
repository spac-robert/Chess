package tests;

import common.Location;
import pieces.*;

public class TestKnight {
    private void createKnight() {
        Location location = new Location(5, 10);
        Piece piece = new Knight(location, PieceColor.WHITE);
        assert piece.getPieceColor() == PieceColor.WHITE;
        assert piece.getName() == 'H';
        assert piece.getLocation().getY() == 10;
        assert piece.getLocation().getX() == 5;
    }

    private void testSetters() {
        Location location = new Location(5, 5);
        Piece piece = new Knight(location, PieceColor.WHITE);
        location = new Location(3, 3);
        piece.setLocation(location);
        assert (piece.getLocation().getY() == 3);
        assert (piece.getLocation().getX() == 3);
        piece.setName("Pawn");
        assert (piece.getName() == 'P');
        piece.setPieceColor(PieceColor.BLACK);
        assert (piece.getPieceColor() == PieceColor.BLACK);
    }

    private void testValidMoveKnight() {
        Location location = new Location(2, 3);
        Piece piece = new Knight(location, PieceColor.BLACK);
        assert (piece.isValidMove(2, 3, 1, 1));

        location = new Location(7,2);
        piece = new Knight(location, PieceColor.WHITE);
        assert (piece.isValidMove(0, 0, 2, 1));
    }

    public void runTestKnight() {
        this.createKnight();
        this.testSetters();
        this.testValidMoveKnight();
    }
}
