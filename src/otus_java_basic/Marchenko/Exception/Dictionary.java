package otus_java_basic.Marchenko.Exception;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
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

    //Поиск в словаре перевода
    public String[] getValue(String key) {
        Map<String, String> dictionary = createDictionary();
        String[] value = {key, null};
        for (String count : dictionary.keySet()) {
            if (count.equals(key)) {
                value[1] = dictionary.get(key);
                break;
            }
        } return value;
    }

    //прверка результата поиска
    public String messageOutput(String[] resultGetValue){
        try {
            if (resultGetValue[1] == null) {
                newWords(resultGetValue[0]);
                return "Translation isn't found\n";
            } else System.out.println(resultGetValue[1] + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Enter word:";
    }
    //запись в файл слов, которых нет в словаре
    public void newWords(String string) throws IOException {
        String text = string +"\n";
        try (FileOutputStream fos = new FileOutputStream("NewWords.txt", true)) {
            // перевод строки в байты
            byte[] buffer = text.getBytes();
            fos.write(buffer, 0, buffer.length);
            System.out.println("The file has been written");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    //Вывод списка слов, которых нет в словаре
    public void printNewWords() {
        FileReader reader = null;
        try {
            reader = new FileReader("NewWords.txt");
            char[] buf = new char[256];
            int count;
            while ((count = reader.read(buf)) > 0) {
                if (count < 256) {
                    buf = Arrays.copyOf(buf, count);
                }
                System.out.println("New words:");
                System.out.print(buf);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }finally {
            if (reader!= null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}


