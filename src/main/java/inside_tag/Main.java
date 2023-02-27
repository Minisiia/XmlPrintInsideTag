package inside_tag;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Используя работу с файлами вывести не все содержимое XML-документа, а только то, что находится внутри тега.
 * (Подсказка: используйте регулярные выражения).
 */

public class Main {
    public static void main(String[] args) {
        File file = new File("src/main/java/inside_tag/powertool.xml");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String s = "";
            int temp;
            for (; ; ) {
                temp = br.read();
                if (temp == -1) break;
                s += (char) temp;
            }
            Pattern p = Pattern.compile(">(.*)<", Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
            Matcher m = p.matcher(s);
            while (m.find()) {
                System.out.println(m.group(1));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
