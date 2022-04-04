package otus_java_basic.Marchenko.Testing.Test;

import otus_java_basic.Marchenko.Testing.App.Game.Dice;

public class TestDiceImplDifferent implements Dice {
    private boolean isFirst = false;

    @Override
    public int roll() {
        isFirst = !isFirst;
        return isFirst ? 6 : 3;
    }
}
