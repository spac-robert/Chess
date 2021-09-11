package tests;

import common.Location;
import org.junit.Test;
import pieces.King;
import pieces.Piece;
import pieces.PieceColor;

public class TestKing {
    @Test
    public void createKing() {
        Location location = new Location(5, 10);
        Piece piece = new King(location, PieceColor.WHITE);
        assert piece.getPieceColor() == PieceColor.WHITE;
        assert piece.getName() == 'K';
        assert piece.getLocation().getY() == 10;
        assert piece.getLocation().getX() == 5;
    }
    @Test
    public void testSetters() {
        Location location = new Location(5, 10);
        Piece piece = new King(location, PieceColor.WHITE);
        location = new Location(-2, -1);
        piece.setLocation(location);
        assert (piece.getLocation().getY() == -1);
        assert (piece.getLocation().getX() == -2);
        piece.setName("Pawn");
        assert (piece.getName() == 'P');
        piece.setPieceColor(PieceColor.BLACK);
        assert (piece.getPieceColor() == PieceColor.BLACK);
    }
    @Test
    public void testValidMoveKing() {
        Location location = new Location(2, 3);
        Piece piece = new King(location, PieceColor.BLACK);
        assert (piece.isValidMove(1, 2, 2, 2));

        location = new Location(7,2);
        piece = new King(location, PieceColor.WHITE);
        assert (piece.isValidMove(7, 2, 6, 2));
    }

}
