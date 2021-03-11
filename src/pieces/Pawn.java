package pieces;

import common.Location;

public class Pawn extends Piece {

    public Pawn(Location location, PieceColor pieceColor) {
        super(location,pieceColor);
        this.name = "Pawn";
    }

    public PieceColor getPieceColor() {
        return pieceColor;
    }

    @Override
    public boolean isValidMove(int xc, int yc, int x, int y) {
        boolean isOk = xc >= 0 && xc <= 7 && yc >= 0 && yc <= 7 && x >= 0 && x <= 7 && y >= 0 && y <= 7;
        boolean itsTrue = (Math.abs(xc - x) == 1 && yc == y) || (Math.abs(xc - x) == 1 && Math.abs(yc - y) == 1);
        //verificam daca pozitia unde vrem sa mutam piesa respecta regula pionuliui
        if (this.pieceColor == PieceColor.WHITE) {
            if (isOk) {
                if (xc >= x) {
                    return itsTrue;
                }
                return false;
            }
        } else {
            if (isOk) {
                if (xc <= x) {
                    return itsTrue;
                }
                return false;
            }
        }
        return false;
    }
}
