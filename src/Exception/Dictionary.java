package Exception;

import java.util.HashMap;
import java.util.Map;

public class Dictionary {

    public static Map<String, String> createDictionary() {
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("melon", "дыня");
        dictionary.put("lemon", "лимон");
        dictionary.put("pear", "груша");
        return dictionary;
    }

    public String getValue(String key) {
        Map<String, String> dictionary = createDictionary();
        String value = null;
        for (String count : dictionary.keySet()) {
            if (count.equals(key)) {
                value = dictionary.get(key);
            }
        }
        return value;
    }

}


