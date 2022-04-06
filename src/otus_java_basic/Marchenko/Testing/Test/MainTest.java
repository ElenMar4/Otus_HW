package otus_java_basic.Marchenko.Testing.Test;

import otus_java_basic.Marchenko.Testing.App.Game.*;

public class MainTest {


    public static void main(String[] args) {

//        Кости принимают значения от 0 до 6?"
//        diceImplTest();

//        Если значения костей одинаковы
//        playGameDiceImplSame();

//        Сравнение значений костей игроков
//        playGameDiceImplDifferent();

//        Если имя игрока Null
//        playerIsNull();

//        Если игроки имеют одинаковые имена
//        playersAreSame();
    }

    public static void diceImplTest() { // Решение: в методе diceImplTest.roll() использовать Random().nextInt(7);

        DiceImpl diceImplTest = new DiceImpl();
        int count = diceImplTest.roll();
        if ((count > 0) && (count <= 6)) {
            System.out.println("Good");
        } else {
            System.err.println("Value is out of range (0, 6]." + " Value: " + count);
            throw new TestFailed();
        }
    }

    public static void playGameDiceImplSame() {

        Player player_1 = new Player("Вася");
        Player player_2 = new Player("Игорь");
        Dice dice = new TestDiceImplSame();
        TestResultDraw draw = new TestResultDraw(player_1, player_2, dice);
        Game gameDraw = new Game(dice, draw);
        gameDraw.playGame(player_1, player_2);
    }

    public static void playGameDiceImplDifferent() {

        Player player_1 = new Player("Вася");
        Player player_2 = new Player("Игорь");
        Dice diceDifferent = new TestDiceImplDifferent();
        TestResultOneWinner different = new TestResultOneWinner(player_1, player_2, diceDifferent.roll(), diceDifferent.roll(), diceDifferent);
        Game gameDifferent = new Game(diceDifferent, different);
        gameDifferent.playGame(player_1, player_2);
    }

    public static void playerIsNull() {

        Player player_1 = new Player(null);
        Player player_2 = new Player(null);
        Dice dice = new DiceImpl();
        TestResultPlayerIsNull resultPlayerIsNull = new TestResultPlayerIsNull(player_1, player_2);
        Game gamePlayerIsNull = new Game(dice, resultPlayerIsNull);
        gamePlayerIsNull.playGame(player_1, player_2);
    }

    public static void playersAreSame() {

        Player player_1 = new Player("Коля");
        Player player_2 = new Player("Коля");
        Dice dice = new DiceImpl();
        TestResultPlayersAreSame resultPlayersAreSame = new TestResultPlayersAreSame(player_1, player_2);
        Game gamePlayersAreSame = new Game(dice, resultPlayersAreSame);
        gamePlayersAreSame.playGame(player_1, player_2);
    }
}
