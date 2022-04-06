package otus_java_basic.Marchenko.Testing.Test;

import otus_java_basic.Marchenko.Testing.App.Game.Dice;
import otus_java_basic.Marchenko.Testing.App.Game.GameWinnerPrinter;
import otus_java_basic.Marchenko.Testing.App.Game.Player;

public class TestResultDraw implements GameWinnerPrinter {

    private Player player_1;
    private Player player_2;
    private Dice diceSame;

    public TestResultDraw(Player player_1, Player player_2, Dice diceSame) {
        this.player_1 = player_1;
        this.player_2 = player_2;
        this.diceSame = diceSame;
    }

    @Override
    public void printWinner(Player realWinner) {
        if ((realWinner.equals(player_2)) & (diceSame.roll() == diceSame.roll()) & (!player_2.equals(player_1))) {
            System.err.println("Winner error. Here is a draw.");
            throw new TestFailed();
        } else System.out.println("good");
    }
}
