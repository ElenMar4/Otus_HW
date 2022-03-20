package Testing.Test;

import Testing.App.Game.*;

public class MainTest {


    public static void main(String[] args) {

//         Кости принимают значения от 0 до 6?"
        diceImplTest();
//
//        Сравнение значений костей игроков
        playGameTest1();
//
//        Если значения костей одинаковы
        playGameTest2();
//
//        Если победитель = null
        gameWinnerConsolePrinterTest();
    }

    public static void diceImplTest() { // Решение: в методе diceImplTest.roll() использовать Random().nextInt(7);
//        for (int i = 0; i < 2; i++) {
        DiceImpl diceImplTest = new DiceImpl();
        int count = diceImplTest.roll();
        if ((count > 0) && (count <= 6)) {
            System.out.println("Кости принимают значения в заданном интервале (0, 6].");
        }
        System.err.println("Кости принимают значения, выходящие за границы интервала (0, 6]." + " Кости выдали: " + count);
    }
//    }

    public static void playGameTest1() {
        Player player1 = new Player("Вася");
        Player player2 = new Player("Игорь");
        MainTest gameTest = new MainTest();
        gameTest.playGame(player1, player2, 1, 6);
    }

    public static void playGameTest2() { //Решение: Добавить условие "Ничья!"
        Player player1 = new Player("Вася");
        Player player2 = new Player("Игорь");
        MainTest gameTest = new MainTest();
        gameTest.playGame(player1, player2, 2, 2);
    }

    public void playGame(Player player1, Player player2, int player1Result, int player2Result) {
        if (player1Result == player2Result) {
            System.err.println("При одинаковых значениях костей, неверно определяется результат игры.");
        } else {
            Player winner = (player1Result > player2Result) ? player1 : player2;
            if (winner.equals(player2)) {
                System.out.println("Поиск победителя при разных значениях костей выполнен верно.");
            } else System.err.println("Поиск победителя при разных значениях костей выполнен неверно.");
        }
    }

    public static void gameWinnerConsolePrinterTest() { //Метод не выбрасывает ошибку при  Null
        GameWinnerConsolePrinter winnerPrinterTest = new GameWinnerConsolePrinter();
        Player winnerTest = new Player(null);
        MainTest gameTest = new MainTest();
        gameTest.printWinner(winnerTest);
    }

    public void printWinner(Player winner) {
        if (winner.getName() == null) System.err.println("Игрок-победитель не может быть Null.");
        else System.out.printf("Победитель: %s%n", winner.getName());
    }
}
