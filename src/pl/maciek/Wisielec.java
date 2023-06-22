package pl.maciek;

import java.util.*;

public class Wisielec {

    String wybraneSlowo;
    char[] zgadywanie;
    char[] wpisywaneSlowo;
    int lives;
    boolean shoot;


    public void start() {

        intitialSetup();

        difficult();

        //pętla while do kontynuwania gry
        gameLoop();

    }

    private void gameLoop() {
        while (!end()) {
            checkingLetter();

            checkingGameRules();
        }
    }

    private void checkingGameRules() {
        if (!shoot) {
            System.out.println("Pudło! Straciłeś życie");
            lives--;
        }

        if (lives == 0) {
            System.out.println("Straciłeś wszystkie życia...przegrałeś");
        }

        if(Arrays.equals(wpisywaneSlowo, zgadywanie)) {
            System.out.println("Gratulacje! Wygrałeś!");
        }
    }

    private void checkingLetter() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(wpisywaneSlowo);
        System.out.println();
        System.out.println("Pozostało żyć: " + lives);
        System.out.println("Proszę podać zgadywaną literę");


        char letter = scanner.nextLine().toLowerCase(Locale.ROOT).charAt(0);
        shoot = false;

        for (int i = 0; i < zgadywanie.length; i++) {
            if (letter == zgadywanie[i]) {
                wpisywaneSlowo[i] = letter;
                System.out.println("Trafiłeś z literą " + letter);
                shoot = true;
            }

        }
    }

    private void intitialSetup() {
        //utworzenie listy przykładowych słów
        ArrayList<String> words = new ArrayList<>(List.of("maciek", "dom", "klawiatura", "laptop", "tester"));

        //wybranie losowego słowa z dostępnej puli
        Random random = new Random();
        wybraneSlowo = words.get(random.nextInt(words.size()));
        System.out.println(wybraneSlowo);

        //stworzenie tablicy znaków do zapisywania wybranych liter i porównywanie dwóch słów
        zgadywanie = wybraneSlowo.toCharArray();
        wpisywaneSlowo = new char[zgadywanie.length];
        Arrays.fill(wpisywaneSlowo, '_');
    }

    public boolean end() {

        return Arrays.equals(wpisywaneSlowo, zgadywanie) || lives == 0;
    }

    public void difficult() {



        System.out.println("Wybierz poziom trudności");
        System.out.println("1. Łatwy");
        System.out.println("2. Normalny");
        System.out.println("3. Trudny");

        Scanner scanner = new Scanner(System.in);

        int level = scanner.nextInt();

        switch (level) {
            case 1 -> lives = 5;
            case 2 -> lives = 3;
            case 3 -> lives = 2;
            default -> lives = 3;
        }


    }

}
