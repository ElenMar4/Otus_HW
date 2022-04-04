package otus_java_basic.Marchenko.Testing.Test;

import otus_java_basic.Marchenko.Testing.App.Game.GameWinnerPrinter;
import otus_java_basic.Marchenko.Testing.App.Game.Player;

public class TestGameWinnerConsolePrinter implements GameWinnerPrinter {
    private Player winner;
    public TestGameWinnerConsolePrinter(Player winner){
        this.winner = winner;
    }
    @Override
    public void printWinner(Player realWinner) {
    if (realWinner.equals(winner)){
        System.out.println("good");
    }
        System.out.println("bad");
    }
}
