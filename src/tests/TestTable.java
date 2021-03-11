package tests;

import pieces.PieceColor;
import player.Player;
import table.Square;
import table.Table;

public class TestTable {
    private void createTable() {
        Table table = new Table();
        //Pawns
        Square[][] squares = table.getTable();
        for (int i = 0; i < 8; i++) {
            assert squares[1][i].getPiece().getName() == 'P' && squares[1][i].getPiece().getPieceColor() == PieceColor.BLACK;
            assert squares[6][i].getPiece().getName() == 'P' && squares[6][i].getPiece().getPieceColor() == PieceColor.WHITE;
        }
        //Rooks
        assert squares[0][0].getPiece().getName() == 'R' && squares[0][1].getPiece().getPieceColor() == PieceColor.BLACK;
        assert squares[0][7].getPiece().getName() == 'R' && squares[0][7].getPiece().getPieceColor() == PieceColor.BLACK;
        assert squares[7][0].getPiece().getName() == 'R' && squares[7][1].getPiece().getPieceColor() == PieceColor.WHITE;
        assert squares[7][7].getPiece().getName() == 'R' && squares[7][7].getPiece().getPieceColor() == PieceColor.WHITE;

        //Knights
        assert squares[0][1].getPiece().getName() == 'H' && squares[0][1].getPiece().getPieceColor() == PieceColor.BLACK;
        assert squares[0][6].getPiece().getName() == 'H' && squares[0][7].getPiece().getPieceColor() == PieceColor.BLACK;
        assert squares[7][1].getPiece().getName() == 'H' && squares[7][1].getPiece().getPieceColor() == PieceColor.WHITE;
        assert squares[7][6].getPiece().getName() == 'H' && squares[7][6].getPiece().getPieceColor() == PieceColor.WHITE;

        //Bishops
        assert squares[0][2].getPiece().getName() == 'B' && squares[0][2].getPiece().getPieceColor() == PieceColor.BLACK;
        assert squares[0][5].getPiece().getName() == 'B' && squares[0][5].getPiece().getPieceColor() == PieceColor.BLACK;
        assert squares[7][2].getPiece().getName() == 'B' && squares[7][2].getPiece().getPieceColor() == PieceColor.WHITE;
        assert squares[7][5].getPiece().getName() == 'B' && squares[7][5].getPiece().getPieceColor() == PieceColor.WHITE;

        //Queens
        assert squares[0][3].getPiece().getName() == 'Q' && squares[0][3].getPiece().getPieceColor() == PieceColor.BLACK;
        assert squares[7][3].getPiece().getName() == 'Q' && squares[7][3].getPiece().getPieceColor() == PieceColor.WHITE;

        //Kings
        assert squares[0][4].getPiece().getName() == 'K' && squares[0][4].getPiece().getPieceColor() == PieceColor.BLACK;
        assert squares[7][4].getPiece().getName() == 'K' && squares[7][4].getPiece().getPieceColor() == PieceColor.WHITE;
    }

    private void testValidationPieces() {
        Table table = new Table();
        Player player = new Player("A", PieceColor.WHITE);
        assert table.move(player, 6, 0, 5, 0);
        player = new Player("B", PieceColor.BLACK);
        assert table.move(player, 1, 0, 2, 0);


    }

    public void runTestTable() {
        this.createTable();
        this.testValidationPieces();
    }
}
