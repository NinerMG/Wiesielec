package pl.maciek;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;

public class WindowVersion extends JFrame {
    private int incorrectGuesses;
    private final WordsDefinition wordsDefinition;
    private JLabel hangmanImage;
    private String[] wordChallange;



    public WindowVersion() {
        super("Wisielec (edycja Java)");
        setSize(CommonConstants.FRAME_SIZE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);

        wordsDefinition = new WordsDefinition();
        wordChallange = wordsDefinition.loadChallange();

        addGUIComponents();
    }
        private void addGUIComponents() {

            System.out.println(System.getProperty("user.dir"));
        hangmanImage = CustomTools.loadImage(CommonConstants.IMAGE_PATH);
        hangmanImage.setBounds(0,0, hangmanImage.getPreferredSize().width, hangmanImage.getPreferredSize().height);

        getContentPane().add(hangmanImage);

        }


}


