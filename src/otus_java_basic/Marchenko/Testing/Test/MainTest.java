package otus_java_basic.Marchenko.Testing.Test;

import otus_java_basic.Marchenko.Testing.App.Game.*;

public class MainTest {


    public static void main(String[] args) {

//         Кости принимают значения от 0 до 6?"
//            diceImplTest();

//        Сравнение значений костей игроков
//        playGameTest1();

//        Если значения костей одинаковы
//        playGameTest2();

//        Если победитель = null
//        gameWinnerConsolePrinterTest();
    }

    public static void diceImplTest() { // Решение: в методе diceImplTest.roll() использовать Random().nextInt(7);
//        for (int i = 0; i < 2; i++) {
        DiceImpl diceImplTest = new DiceImpl();
        int count = diceImplTest.roll();
        if ((count > 0) && (count <= 6)) {
            System.out.println("Good");
        } else {
            System.err.println("Value is out of range (0, 6]." + " Value: " + count);
            throw new TestFailed();
        }
    }


    public static void playGameTest1() {
        Player player_1 = new Player("Вася");
        Player player_2 = new Player("Игорь");
        Dice dice = new TestDiceImplSame();
        TestResultDraw draw = new TestResultDraw(player_1, player_2, dice);
        Game gameDraw = new Game(dice, draw);
        gameDraw.playGame(player_1, player_2);
    }


//    public static void playGameTest2() { //Решение: Добавить условие "Ничья!"
//        Player player1 = new Player("Вася");
//        Player player2 = new Player("Игорь");
//        MainTest gameTest = new MainTest();
//        gameTest.playGame(player1, player2, 2, 2);
//    }
//
//    public void playGame(Player player1, Player player2, int player1Result, int player2Result) {
//        if (player1Result == player2Result) {
//            System.err.println("При одинаковых значениях костей, неверно определяется результат игры.");
//        } else {
//            Player winner = (player1Result > player2Result) ? player1 : player2;
//            if (winner.equals(player2)) {
//                System.out.println("Поиск победителя при разных значениях костей выполнен верно.");
//            } else System.err.println("Поиск победителя при разных значениях костей выполнен неверно.");
//        }
//    }
//
//    public static void gameWinnerConsolePrinterTest() { //Метод не выбрасывает ошибку при  Null
//        GameWinnerConsolePrinter winnerPrinterTest = new GameWinnerConsolePrinter();
//        Player winnerTest = new Player(null);
//        MainTest gameTest = new MainTest();
//        gameTest.printWinner(winnerTest);
//    }
//
//    public void printWinner(Player winner) {
//        if (winner.getName() == null) System.err.println("Игрок-победитель не может быть Null.");
//        else System.out.printf("Победитель: %s%n", winner.getName());

}
