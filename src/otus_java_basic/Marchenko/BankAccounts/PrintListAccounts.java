package otus_java_basic.Marchenko.BankAccounts;
import java.util.List;

public class PrintListAccounts {
    public static void printListAccounts(List<Account> listAccounts){
        for (Account account : listAccounts) {
            System.out.println(account.getAccount());
        }
    }
}
