package tests;

import org.junit.Test;
import pieces.PieceColor;
import player.Player;

public class TestPlayer {
    @Test
    public void createPlayer() {
        Player player = new Player("Petruta", PieceColor.BLACK);
        assert player.getPieceColor() == PieceColor.BLACK;
        assert player.getName().equals("Petruta");
    }


}
