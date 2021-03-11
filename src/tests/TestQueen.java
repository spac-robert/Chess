package tests;

import common.Location;
import pieces.Piece;
import pieces.PieceColor;
import pieces.Queen;

public class TestQueen {
    private void createQueen() {
        Location location = new Location(5, 10);
        Piece piece = new Queen(location, PieceColor.WHITE);
        assert piece.getPieceColor() == PieceColor.WHITE;
        assert piece.getName() == 'Q';
        assert piece.getLocation().getY() == 10;
        assert piece.getLocation().getX() == 5;
    }

    private void testSetters() {
        Location location = new Location(5, 10);
        Piece piece = new Queen(location, PieceColor.WHITE);
        location = new Location(-2, -1);
        piece.setLocation(location);
        assert (piece.getLocation().getY() == -1);
        assert (piece.getLocation().getX() == -2);
        piece.setName("Pawn");
        assert (piece.getName() == 'P');
        piece.setPieceColor(PieceColor.BLACK);
        assert (piece.getPieceColor() == PieceColor.BLACK);
    }

    private void testValidMoveQueen() {

        Location location = new Location(1, 0);
        Piece piece = new Queen(location, PieceColor.BLACK);
        assert (piece.isValidMove(1, 0, 3, 2));

        location = new Location(0, 0);
        piece = new Queen(location, PieceColor.WHITE);
        assert (piece.isValidMove(0, 0, 4, 0));
    }

    public void runTestQueen() {
        this.createQueen();
        this.testSetters();
        this.testValidMoveQueen();
    }
}
