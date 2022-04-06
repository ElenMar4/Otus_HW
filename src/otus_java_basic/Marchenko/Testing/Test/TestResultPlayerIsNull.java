package otus_java_basic.Marchenko.Testing.Test;

import otus_java_basic.Marchenko.Testing.App.Game.GameWinnerPrinter;
import otus_java_basic.Marchenko.Testing.App.Game.Player;

public class TestResultPlayerIsNull implements GameWinnerPrinter {
    private Player player_1;
    private Player player_2;

    public TestResultPlayerIsNull(Player player_1, Player player_2) {
        this.player_1 = player_1;
        this.player_2 = player_2;
    }

    @Override
    public void printWinner(Player realWinner) {
        if ((player_1.getName() == null) || (player_2.getName() == null)) {
            System.err.println("Player cannot be null");
            throw new TestFailed();
        } else System.out.println("Good");
    }
}
