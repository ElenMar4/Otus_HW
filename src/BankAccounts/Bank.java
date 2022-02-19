package BankAccounts;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface Bank {

    List<Account> getAccounts(Client client, HashMap<Client, List<Account>> map);

    Client findClient(Account needAccount, HashMap<Client, List<Account>> map);

}
