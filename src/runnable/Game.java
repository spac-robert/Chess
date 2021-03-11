package runnable;

import pieces.PieceColor;
import player.Player;
import table.Table;
import tests.TestDriver;

import java.util.Scanner;

public class Game {

    public static boolean isCharacter(char ch) {
        return (Character.toUpperCase(ch) >= 'A' && Character.toUpperCase(ch) <= 'Z');
    }

    public static void main(String[] args) {

        TestDriver tests = new TestDriver();
        tests.runTests();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Player's 1 name:");
        String line = scanner.nextLine();
        Player player1 = new Player(line, PieceColor.WHITE);
        System.out.println();

        System.out.print("Player's 2 name:");
        line = scanner.nextLine();
        Player player2 = new Player(line, PieceColor.BLACK);
        System.out.println();

        Table table = new Table();
        table.printTable();
        Player player = player1;
        int nr = 1;
        while (true) {
            System.out.print(player.getName()+ "'s turn\n");
            line = scanner.nextLine();
            String[] fromTo = line.split("->");
            if ((fromTo[0].charAt(1) - '0') <= 9 && (fromTo[1].charAt(1) - '0') <= 9 &&
                    isCharacter(fromTo[0].charAt(0)) && isCharacter(fromTo[1].charAt(0))) {
                int xc = 8 - (Character.toUpperCase(fromTo[0].charAt(1)) - '0');
                int yc = (int) (Character.toUpperCase(fromTo[0].charAt(0)) - 'A');
                int x = 8 - (Character.toUpperCase(fromTo[1].charAt(1)) - '0');
                int y = (int) (Character.toUpperCase(fromTo[1].charAt(0)) - 'A');
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
}
