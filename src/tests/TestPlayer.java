package tests;

import pieces.PieceColor;
import player.Player;

public class TestPlayer {
    private void createPlayer() {
        Player player = new Player("Petruta", PieceColor.BLACK);
        assert player.getPieceColor() == PieceColor.BLACK;
        assert player.getName().equals("Petruta");
    }

    public void runTestPlayer() {
        this.createPlayer();
    }

}
