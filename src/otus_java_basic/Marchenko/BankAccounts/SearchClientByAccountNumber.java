package otus_java_basic.Marchenko.BankAccounts;
import java.util.List;
import java.util.Map;

public class SearchClientByAccountNumber implements SearchSystem {

    Account accountBySearch = new Account();
    Client clientAfterSearch = new Client();

    @Override
    public void inputData() {
        accountBySearch.setAccount(InputOfInitialData.inputOfInitialData("Введите номер счета: "));
    }

    @Override
    public void searchData(Map<Client, List<Account>> base) {
        clientAfterSearch = FindClient.searchObjectOfInitialData(accountBySearch, base);
    }

    @Override
    public void outputData() {
        clientAfterSearch.printClient();
    }
}