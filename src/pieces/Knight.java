package pieces;

import common.Location;

public class Knight extends Piece {
    public Knight(Location location, PieceColor pieceColor) {
        super(location, pieceColor);
        this.name = "H";
    }

    @Override
    public boolean isValidMove(int xc, int yc, int x, int y) {
        boolean isOk = xc >= 0 && xc <= 7 && yc >= 0 && yc <= 7 && x >= 0 && x <= 7 && y >= 0 && y <= 7;
        if (isOk) {
            //verificam daca pozitia unde vrem sa mutam piesa respecta regula pionuliui
            return Math.abs(xc - x) <= 2 && Math.abs(yc - y) <= 2;
        }
        return false;
    }
}
