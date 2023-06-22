package pl.maciek;

import java.util.*;

public class Wisielec {

    String wybraneSlowo;
    char[] wpisywaneSlowo;
    boolean isEnd = false;

    public void start() {

        //utworzenie listy przykładowych słów
        ArrayList<String> words = new ArrayList<>(List.of("maciek", "dom", "klawiatura", "laptop", "tester"));

        //wybranie losowego słowa z dostępnej puli
        Random random = new Random();
        wybraneSlowo = words.get(random.nextInt(words.size()));
        System.out.println(wybraneSlowo);

        //stworzenie tablicy znaków do zapisywania wybranych liter i porównywanie dwóch słów
        char[] zgadywanie = wybraneSlowo.toCharArray();
        wpisywaneSlowo = new char[zgadywanie.length];
        Arrays.fill(wpisywaneSlowo, '_');
        //System.out.println(wpisywaneSlowo);


        //pętla while do kontynuwania gry
        while (!end()) {
            Scanner scanner = new Scanner(System.in);
            System.out.println(wpisywaneSlowo);
            System.out.println("Proszę podać zgadywaną literę");

            char letter = scanner.nextLine().toLowerCase(Locale.ROOT).charAt(0);

            for (int i = 0; i < zgadywanie.length; i++) {
                if (letter == zgadywanie[i]) {
                    wpisywaneSlowo[i] = letter;
                }
            }
            if(Arrays.equals(wpisywaneSlowo, zgadywanie)) {
                System.out.println("Gratulacje! Wygrałeś!");
                isEnd = true;
            }
        }

    }

    public boolean end() {

        return isEnd;
    }

}
