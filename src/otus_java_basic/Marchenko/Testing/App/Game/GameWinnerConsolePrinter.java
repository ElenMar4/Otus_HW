package otus_java_basic.Marchenko.Testing.App.Game;

public class GameWinnerConsolePrinter implements GameWinnerPrinter{
    @Override
    public void printWinner(Player winner) {
        System.out.printf("Победитель: %s%n", winner.getName());
    }
}
