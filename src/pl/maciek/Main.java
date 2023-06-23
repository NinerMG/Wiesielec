package pl.maciek;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        //Wisielec wisielec = new Wisielec();
        //wisielec.start();

       // Dictionary dictionary = new Dictionary();
       // dictionary.dictionaryRead();


        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new WindowVersion().setVisible(true);
            }
        });

    }
}

