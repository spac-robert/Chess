package table;

import common.Location;
import pieces.*;
import player.Player;

public class Table {
    private final Square[][] square = new Square[8][8];

    public Table() {
        //Pawn
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Square sq = new Square();
                if (i == 1) {
                    Location location = new Location(j, i);
                    Piece piece = new Pawn(location, PieceColor.BLACK);
                    sq = new Square(true, piece);
                } else if (i == 6) {
                    Location location = new Location(j, i);
                    Piece piece = new Pawn(location, PieceColor.WHITE);
                    sq = new Square(true, piece);
                }
                square[i][j] = sq;
            }
        }
        //King
        Location location = new Location(7, 4);
        Piece piece = new King(location, PieceColor.BLACK);
        square[0][4] = new Square(true, piece);
        location = new Location(0, 4);
        piece = new King(location, PieceColor.WHITE);
        square[7][4] = new Square(true, piece);

        //Knight
        location = new Location(7, 1);
        piece = new Knight(location, PieceColor.BLACK);
        square[0][1] = new Square(true, piece);
        location = new Location(0, 1);
        piece = new Knight(location, PieceColor.WHITE);
        square[7][1] = new Square(true, piece);
        location = new Location(7, 6);
        piece = new Knight(location, PieceColor.BLACK);
        square[0][6] = new Square(true, piece);
        location = new Location(0, 6);
        piece = new Knight(location, PieceColor.WHITE);
        square[7][6] = new Square(true, piece);

        //Queen
        location = new Location(7, 3);
        piece = new Queen(location, PieceColor.BLACK);
        square[0][3] = new Square(true, piece);
        location = new Location(0, 3);
        piece = new Queen(location, PieceColor.WHITE);
        square[7][3] = new Square(true, piece);

        //Rook
        location = new Location(7, 0);
        piece = new Rook(location, PieceColor.BLACK);
        square[0][0] = new Square(true, piece);
        location = new Location(0, 0);
        piece = new Rook(location, PieceColor.WHITE);
        square[7][0] = new Square(true, piece);
        location = new Location(7, 7);
        piece = new Rook(location, PieceColor.BLACK);
        square[0][7] = new Square(true, piece);
        location = new Location(0, 7);
        piece = new Rook(location, PieceColor.WHITE);
        square[7][7] = new Square(true, piece);

        //Bishop
        location = new Location(7, 2);
        piece = new Bishop(location, PieceColor.BLACK);
        square[0][2] = new Square(true, piece);
        location = new Location(0, 2);
        piece = new Bishop(location, PieceColor.WHITE);
        square[7][2] = new Square(true, piece);
        location = new Location(7, 5);
        piece = new Bishop(location, PieceColor.BLACK);
        square[0][5] = new Square(true, piece);
        location = new Location(0, 5);
        piece = new Bishop(location, PieceColor.WHITE);
        square[7][5] = new Square(true, piece);

    }

    public void printTable() {
        int number = 8;
        for (int i = 0; i < 8; i++) {
            System.out.print(number - i + " ");
            for (int j = 0; j < 8; j++) {
                if (square[i][j].isOccupied()) {
                    if (square[i][j].getPiece().getPieceColor() == PieceColor.BLACK) {
                        System.out.print("\033[1;30m" + square[i][j].getPiece().getName() + "\033[0m ");
                    } else
                        System.out.print("\033[0;97m" + square[i][j].getPiece().getName() + "\033[0m ");
                } else
                    System.out.print("\033[0;90m" + "- " + "\033[0m");
            }
            System.out.println();
        }
        System.out.print("  ");
        char a = 'A';
        for (int i = 0; i < 8; i++) {
            System.out.print((char) (a + i) + " ");
        }
        System.out.print("\n..................\n");
    }

    public Square[][] getTable() {
        return this.square;
    }

    //validare pentru tura pe tabla, daca pana la locul unde vreau eu sa merg este liber si daca pe locul
    //respectiv se afla o piesa inamica
    public boolean validRook(int xc, int yc, int x, int y) {
        if (yc == y) {
            if (xc > x) {
                for (int i = xc - 1; i > x; i--) {
                    if (square[i][yc].isOccupied())
                        return false;
                }
            } else {
                for (int i = xc + 1; i < x; i++) {
                    if (square[i][yc].isOccupied())
                        return false;
                }
            }
            if (square[x][y].getPiece() != null) {
                return square[x][y].getPiece().getPieceColor() != square[xc][yc].getPiece().getPieceColor();
            } else
                return true;
        } else if (xc == x) {
            if (yc < y) {
                for (int i = yc + 1; i < y; i++) {
                    if (square[x][i].isOccupied())
                        return false;
                }
            } else {
                for (int i = yc - 1; i > y; i--) {
                    if (square[x][i].isOccupied())
                        return false;
                }
            }
            if (square[x][y].getPiece() != null) {
                return square[x][y].getPiece().getPieceColor() != square[xc][yc].getPiece().getPieceColor();
            } else
                return true;
        } else
            return false;
    }

    public boolean move(Player player, int xc, int yc, int x, int y) {

        //preiau piesa curenta
        Piece piece = square[xc][yc].getPiece();
        //verific daca exista piesa curenta pe tabla si daca e piesa jucatorului
        if (piece != null && piece.getPieceColor() == player.getPieceColor()) {

            if (piece.isValidMove(xc, yc, x, y)) {
                if (!square[x][y].isOccupied() || (square[x][y].isOccupied() &&
                        square[x][y].getPiece().getPieceColor() != square[xc][yc].getPiece().getPieceColor())) {
                    //validare rook
                    if (square[xc][yc].getPiece().getName() == 'R') {
                        if (validRook(xc, yc, x, y)) {
                            setSquare(xc, yc, x, y, piece);
                            return true;
                        }
                    } else
                        //validare pion
                        if (square[xc][yc].getPiece().getName() == 'P') {
                            if (validPawn(xc, yc, x, y)) {
                                setSquare(xc, yc, x, y, piece);
                                return true;
                            }
                        //validare Bishop
                        } else if (square[xc][yc].getPiece().getName() == 'B') {
                            if (validBishop(xc, yc, x, y)) {
                                setSquare(xc, yc, x, y, piece);
                                return true;
                            }
                        } else
                            //validare regina
                            if (square[xc][yc].getPiece().getName() == 'Q') {
                            if (validQueen(xc, yc, x, y)) {
                                setSquare(xc, yc, x, y, piece);
                                return true;
                            }
                        } else {
                            setSquare(xc, yc, x, y, piece);
                            return true;
                        }
                }
            }
        }
        return false;
    }

    private boolean validBishop(int xc, int yc, int x, int y) {
        //merg pe diagonala principala sus
        boolean ok = false;
        if (x < xc) {
            int auxY;
            if (y > yc) {
                ok = true;
                auxY = yc + 1;
                for (int i = xc - 1; i > x; i--, auxY++) {
                    if (square[i][auxY].isOccupied()) {
                        return false;
                    }
                }
            } else if (y < yc) {
                ok = true;
                //merg pe diagonala secundara in sus
                auxY = yc - 1;
                for (int i = xc - 1; i > x; i--, auxY--) {
                    if (square[i][auxY].isOccupied()) {
                        return false;
                    }
                }
            }
        } else if (x > xc) {

            int auxY;
            if (y > yc) {
                ok = true;
                //merg pe diagonala principala in jos
                auxY = yc + 1;
                for (int i = x - 1; i > xc; i--, auxY++) {
                    if (square[i][auxY].isOccupied()) {
                        return false;
                    }
                }
            } else if (y < yc) {
                ok = true;
                //merg pe diagonala secundara in jos
                auxY = yc - 1;
                for (int i = xc + 1; i < xc; i++, auxY--) {
                    if (square[i][auxY].isOccupied()) {
                        return false;
                    }
                }
            }
        }
        if (ok) {
            return !square[x][y].isOccupied() ||
                    (square[x][y].isOccupied() && square[x][y].getPiece().getPieceColor() !=
                            square[xc][yc].getPiece().getPieceColor());
        } else
            return false;
    }

    private boolean validQueen(int xc, int yc, int x, int y) {
        //verificam daca putem sa ajungem la coordonatele alese x,y utilizand miscarile piesei Bishop sau piesei Rook
        return validBishop(xc, yc, x, y) || validRook(xc, yc, x, y);
    }

    private boolean validPawn(int xc, int yc, int x, int y) {
        if (y == yc) {
            return !square[x][y].isOccupied();
        } else {
            return square[x][y].isOccupied() && square[x][y].getPiece().getPieceColor() != square[xc][yc].getPiece().getPieceColor();
        }
    }

    private void setSquare(int xc, int yc, int x, int y, Piece piece) {
        //setam patratelul curent ca fiind gol
        square[xc][yc] = new Square();
        Location location = new Location(x, y);
        piece.setLocation(location);
        //setam patratelul ales ca fiind ocupat de piesa noastra
        square[x][y] = new Square(true, piece);
    }
}
