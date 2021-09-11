package tests;

import common.Location;
import org.junit.Test;
import pieces.Pawn;
import pieces.Piece;
import pieces.PieceColor;
import table.Square;

public class TestSquare {
    @Test
    public void createSquare() {
        Square square = new Square();
        assert !square.isOccupied();
        assert square.getPiece() == null;

        Location location= new Location(1,2);
        Piece piece= new Pawn(location, PieceColor.BLACK);
        square = new Square(true,piece);

        assert square.isOccupied();
        assert square.getPiece()==piece;
    }

}
