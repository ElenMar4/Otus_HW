package otus_java_basic.Marchenko.Testing.Test;

import otus_java_basic.Marchenko.Testing.App.Game.GameWinnerPrinter;
import otus_java_basic.Marchenko.Testing.App.Game.Player;

public class TestResultPlayersAreSame implements GameWinnerPrinter {

    private Player player_1;
    private Player player_2;

    public TestResultPlayersAreSame(Player player_1, Player player_2) {
        this.player_1 = player_1;
        this.player_2 = player_2;
    }

    @Override
    public void printWinner(Player winner) {
        if (player_1.getName().equals(player_2.getName())) {
            System.err.println("Players must have different names");
            throw new TestFailed();
        } else System.out.println("Good");
    }
}
