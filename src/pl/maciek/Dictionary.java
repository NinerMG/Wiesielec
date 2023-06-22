package pl.maciek;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Dictionary {

    ArrayList<String> slownik = new ArrayList<>();

    public String dictionaryRead() {

        String localization = "D:\\Wiesielec\\slowniki\\slowa.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(localization))) {
            String linia;
            while ((linia = reader.readLine()) != null) {
                slownik.add(linia);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        Random random = new Random();
        int range = random.nextInt(slownik.size());

        return slownik.get(range);

    }

}
