package otus_java_basic.Marchenko.ProjectWork.UnitTest;

import otus_java_basic.Marchenko.ProjectWork.UserInteractionService;

public class DublerConsoleUserInteractionService implements UserInteractionService {

    int userValueTest;
    String userCurrencyTest;

    public DublerConsoleUserInteractionService(int userValueTest, String userCurrencyTest) {
        this.userValueTest = userValueTest;
        this.userCurrencyTest = userCurrencyTest;
    }

    @Override
    public int selectNumber() {
        return userValueTest;
    }

    @Override
    public String selectCurrency(String str) {
        return userCurrencyTest;
    }

    @Override
    public void outputToConsole(String convertUserNumberToString, String currencyStringOut) {
        System.out.println(convertUserNumberToString + currencyStringOut);
    }
}
