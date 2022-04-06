package otus_java_basic.Marchenko.BankAccounts;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class GetAccounts  {
    public static List<Account> searchObjectOfInitialData(Client object, Map<Client, List<Account>> base) {
        List<Account> listAccountsClient = new ArrayList<>();
        for (Client client : base.keySet()) {
            if (object.equals(client)) {
                for (Account account : base.get(client)) {
                    Collections.addAll(listAccountsClient, account);
                }
            }
        }
        return listAccountsClient;
    }
}