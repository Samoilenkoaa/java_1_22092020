package lesson3_advanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<String> list = new ArrayList<>();
        list.addAll(Arrays.asList("мама", "папа", "брат", "сестра", "бабушка", "дедушка", "мама", "свекр", "отец", "папа", "тетя",
                "дядя", "тещя", "свекр", "отец", "пробабка", "кум", "кума", "сын", "дочь"));

        Set<String> set = new HashSet<>();
        set.addAll(list);
        System.out.println(list);

        Map<String, Integer> duplicates = new HashMap<>();
        for (String s : list) {
            duplicates.put(s, Collections.frequency(list, s));
        }
        System.out.println(duplicates);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, String> map = new HashMap<>();
        String s = reader.readLine();
        map.put(1434, "Ivanov");
        map.put(4356, "Petrov");
        map.put(5467, "Zaicev");
        map.put(7687, "Ivanov");
        map.put(8873, "Sidorov");

        map.forEach((k, v) -> {
                if(s.equals(v))
                System.out.println(k + " " + v);

        });













    }
}
