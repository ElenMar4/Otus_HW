package otus_java_basic.Marchenko.BankAccounts;

import java.util.List;
import java.util.Map;

public interface SearchSystem {

    void inputData();

    void searchData(Map<Client, List<Account>> base);

    void outputData();
}
