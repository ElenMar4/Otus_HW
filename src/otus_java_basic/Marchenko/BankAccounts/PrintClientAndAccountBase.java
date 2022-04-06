package otus_java_basic.Marchenko.BankAccounts;
import java.util.List;
import java.util.Map;

public class PrintClientAndAccountBase {

    public static void printClientAndAccountBase(Map<Client, List<Account>> base){

        for (Client client : base.keySet()) {
            client.printClient();
            System.out.println("Счета: ");
            PrintListAccounts.printListAccounts(base.get(client));
        }
    }
}
