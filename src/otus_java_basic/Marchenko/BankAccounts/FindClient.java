package otus_java_basic.Marchenko.BankAccounts;
import java.util.List;
import java.util.Map;

public class FindClient  {


    public static Client searchObjectOfInitialData(Account object, Map<Client, List<Account>> base) {

        String idClient = null;
        String nameClient = null;
        int ageClient = 0;
        for (Client client : base.keySet()) {
            for (Account account : base.get(client)) {
                if (object.equals(account)) {
                    nameClient = client.getName();
                    ageClient = client.getAge();
                    idClient = client.getClientID();
                    break;
                }
            }
        }
        return (new Client(idClient, nameClient, ageClient));
    }
}