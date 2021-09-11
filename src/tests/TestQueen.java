package tests;

import common.Location;
import org.junit.Test;
import pieces.Piece;
import pieces.PieceColor;
import pieces.Queen;

public class TestQueen {
    @Test
    public void createQueen() {
        Location location = new Location(5, 10);
        Piece piece = new Queen(location, PieceColor.WHITE);
        assert piece.getPieceColor() == PieceColor.WHITE;
        assert piece.getName() == 'Q';
        assert piece.getLocation().getY() == 10;
        assert piece.getLocation().getX() == 5;
    }
    @Test
    public void testSetters() {
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
    @Test
    public void testValidMoveQueen() {

        Location location = new Location(1, 0);
        Piece piece = new Queen(location, PieceColor.BLACK);
        assert (piece.isValidMove(1, 0, 3, 2));

        location = new Location(0, 0);
        piece = new Queen(location, PieceColor.WHITE);
        assert (piece.isValidMove(0, 0, 4, 0));
    }

}
