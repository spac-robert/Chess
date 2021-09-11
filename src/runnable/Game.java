package runnable;

import pieces.PieceColor;
import player.Player;
import table.Table;

import java.util.Scanner;

public class Game {

    public static boolean isCharacter(char ch) {
        return (Character.toUpperCase(ch) >= 'A' && Character.toUpperCase(ch) <= 'Z');
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Player's 1 name:");
        Player player1 = getPlayer(scanner, PieceColor.WHITE);
        String line;

        System.out.print("Player's 2 name:");
        Player player2 = getPlayer(scanner, PieceColor.BLACK);
        System.out.println();

        Table table = new Table();
        table.printTable();
        Player player = player1;
        int nr = 1;
        while (true) {
            System.out.print(player.getName() + "'s turn\n");
            line = scanner.nextLine();
            String[] fromTo = line.split("->");
            if ((fromTo[0].charAt(1) - '0') <= 9 && (fromTo[1].charAt(1) - '0') <= 9 &&
                    isCharacter(fromTo[0].charAt(0)) && isCharacter(fromTo[1].charAt(0))) {
                int xc = getX(fromTo, 0, 1);
                int yc = getY(fromTo, 0, 0);
                int x = getX(fromTo, 0, 0);
                int y = getY(fromTo, 1, 0);
                if (table.move(player, xc, yc, x, y)) {
                    nr++;
                    if (nr % 2 == 0) {
                        player = player2;
                        nr = 0;
                    } else
                        player = player1;
                } else {
                    System.out.println("Invalid move! Please try again");
                }
                table.printTable();
            }
        }
    }

    private static int getY(String[] fromTo, int i, int j) {
        return (int) (Character.toUpperCase(fromTo[i].charAt(j)) - 'A');
    }

    private static int getX(String[] fromTo, int i, int j) {
        return 8 - (Character.toUpperCase(fromTo[i].charAt(j)) - '0');
    }

    private static Player getPlayer(Scanner scanner, PieceColor pieceColor) {
        String line = scanner.nextLine();
        Player player1 = new Player(line, pieceColor);
        System.out.println();
        return player1;
    }
}
