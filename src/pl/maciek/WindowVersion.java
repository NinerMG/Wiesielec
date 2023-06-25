package pl.maciek;

import javax.swing.*;

public class WindowVersion extends JFrame {

    private final WordsDefinition wordsDefinition;

    //liczenie niepowodzeń użytkownika
    private int incorrectGuesses;

    //przechowywanie słowa do zgadnięcia
    private String[] wordChallenge;

    private JLabel wisielecZdjecie;

    public WindowVersion() {
        super("Wisielec (edycja Java)");
        setSize(CommonConstants.FRAME_SIZE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);

        //inicjacja
        wordsDefinition = new WordsDefinition();
        wordChallenge = wordsDefinition.loadChallange();



        addGUIComponents();

    }

    private void addGUIComponents(){
        //wisielec zdjęcie
        wisielecZdjecie = CustomTools.loadImage(CommonConstants.IMAGE_PATH);
        wisielecZdjecie.setBounds(0,0, wisielecZdjecie.getPreferredSize().width, wisielecZdjecie.getPreferredSize().height);


        getContentPane().add(wisielecZdjecie);
    }

}


