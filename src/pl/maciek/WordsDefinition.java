package pl.maciek;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class WordsDefinition {

    private HashMap<String, String[]> wordList;

    private ArrayList<String> categories;

    public WordsDefinition() {
        try {
            wordList = new HashMap<>();
            categories = new ArrayList<>();

            String filePath = getClass().getClassLoader().getResource(CommonConstants.DATA_PATH).getPath();
            if (filePath.contains("%20")) filePath = filePath.replaceAll("%20", " ");

            BufferedReader reader = new BufferedReader(new FileReader(filePath));

            String line;
            while ((line = reader.readLine()) != null) {
                //podzielenie danych pod względem przecinka
                String[] parts = line.split(",");

                //pierwsze slowo reprezentuje kategorie
                String category = parts[0];
                categories.add(category);

                //pozostałe wartości to słowa do odgadnięcia
                String values[] = Arrays.copyOfRange(parts, 1, parts.length);
                wordList.put(category, values);
            }
            }catch(IOException e) {
            System.out.println("Error: " + e);
        }
    }
    public String[] loadChallange(){
        Random random = new Random();

        String category = categories.get(random.nextInt(categories.size()));

        String[] categoryValues = wordList.get(category);
        String word = categoryValues[random.nextInt(categoryValues.length)];

        return new String[]{category.toUpperCase(), word.toUpperCase()};
    }

}
