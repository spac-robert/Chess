package tests;

import common.Location;
import pieces.Pawn;
import pieces.Piece;
import pieces.PieceColor;

public class TestPawn {

    private void createPawn() {
        Location location = new Location(5, 10);
        Piece piece = new Pawn(location, PieceColor.WHITE);
        assert piece.getPieceColor() == PieceColor.WHITE;
        assert piece.getName() == 'P';
        assert piece.getLocation().getY() == 10;
        assert piece.getLocation().getX() == 5;
    }

    private void testSetters() {
        Location location = new Location(5, 10);
        Piece piece = new Pawn(location, PieceColor.WHITE);
        location = new Location(-2, -1);
        piece.setLocation(location);
        assert (piece.getLocation().getY() == -1);
        assert (piece.getLocation().getX() == -2);
        piece.setName("King");
        assert (piece.getName() == 'K');
        piece.setPieceColor(PieceColor.BLACK);
        assert (piece.getPieceColor() == PieceColor.BLACK);
    }

    private void testValidMovePawn() {
        Location location = new Location(2, 3);
        Piece piece = new Pawn(location, PieceColor.BLACK);
        assert (piece.isValidMove(1, 2, 2, 2));

        location = new Location(7,2);
        piece = new Pawn(location, PieceColor.WHITE);
        assert (piece.isValidMove(7, 2, 6, 2));
    }

    public void runTestPawn() {

        this.createPawn();
        this.testSetters();
        this.testValidMovePawn();
    }
}
