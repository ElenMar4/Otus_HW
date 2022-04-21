package otus_java_basic.Marchenko.ProjectWork;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

public class Currency {

    private Map<String, String[]> currency = new HashMap<>();

    public Map<String, String[]> createCurrency(){
        currency.put("rub", new String[]{"рубль", "рубля", "рублей"});
        currency.put("usd", new String[]{"доллар", "доллара", "долларов"});
        currency.put("eur", new String[]{"евро", "евро", "евро"});

        return currency;
    }

    public void setCurrency(Map<String, String[]> currency) {
        this.currency = currency;
    }

    public String[] getCurrency(String key){
        createCurrency();
        return currency.get(key);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Currency currency1 = (Currency) o;
        return Objects.equals(currency, currency1.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currency);
    }
}
