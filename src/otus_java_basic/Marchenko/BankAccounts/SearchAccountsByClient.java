package otus_java_basic.Marchenko.BankAccounts;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SearchAccountsByClient implements SearchSystem{

    List<Account> accountListAfterSearch = new ArrayList<>();
    Client clientBySearch = new Client();

    @Override
    public void inputData() {
        clientBySearch.setClientID(InputOfInitialData.inputOfInitialData("Введите ID клиента: "));
        clientBySearch.setName(InputOfInitialData.inputOfInitialData("Введите имя клиента: "));
    }

    @Override
    public void searchData(Map<Client, List<Account>> base) {
        accountListAfterSearch = GetAccounts.searchObjectOfInitialData(clientBySearch, base);
    }

    @Override
    public void outputData() {
        PrintListAccounts.printListAccounts(accountListAfterSearch);
    }
}