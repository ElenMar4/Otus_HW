package otus_java_basic.Marchenko.Testing.Test;

import otus_java_basic.Marchenko.Testing.App.Game.Dice;
import otus_java_basic.Marchenko.Testing.App.Game.GameWinnerPrinter;
import otus_java_basic.Marchenko.Testing.App.Game.Player;

public class TestResultOneWinner implements GameWinnerPrinter {
    private Player player_1;
    private Player player_2;
    private int player_1Result;
    private int player_2Result;
    private Dice diceImplDifferent;

    public TestResultOneWinner(Player player_1, Player player_2, int player_1Result, int player_2Result, Dice diceImplDifferent) {
        this.player_1 = player_1;
        this.player_2 = player_2;
        this.player_1Result = player_1Result;
        this.player_2Result = player_2Result;
        this.diceImplDifferent = diceImplDifferent;
    }

    @Override
    public void printWinner(Player realWinner) {
        if ((realWinner.equals(player_1))&(player_1Result == 6)&(player_1Result != player_2Result)&(!player_1.equals(player_2))){
            System.out.println("Good");
        } else throw new TestFailed();
    }
}
