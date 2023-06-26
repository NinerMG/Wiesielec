package pl.maciek;

import javax.swing.*;
import java.awt.*;


public class WindowVersion extends JFrame {
    private int incorrectGuesses;
    private final WordsDefinition wordsDefinition;
    private JLabel hangmanImage, categoryLabel, hiddenWordLabel;
    private String[] wordChallange;



    public WindowVersion() {
        super("Wisielec (edycja Java)");
        setSize(CommonConstants.FRAME_SIZE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        getContentPane().setBackground(CommonConstants.BACKGROUND_COLOR);

        wordsDefinition = new WordsDefinition();
        wordChallange = wordsDefinition.loadChallange();

        addGUIComponents();
    }
        private void addGUIComponents() {

            System.out.println(System.getProperty("user.dir"));
        hangmanImage = CustomTools.loadImage(CommonConstants.IMAGE_PATH);
        hangmanImage.setBounds(0,0, hangmanImage.getPreferredSize().width, hangmanImage.getPreferredSize().height);

        //ekran kategorii
        categoryLabel = new JLabel(wordChallange[0]);
        categoryLabel.setHorizontalAlignment(SwingConstants.CENTER);
        categoryLabel.setOpaque(true);
        categoryLabel.setForeground(Color.WHITE);
        categoryLabel.setBackground(CommonConstants.SECONDARY_COLOR);
        categoryLabel.setBorder(BorderFactory.createLineBorder(CommonConstants.SECONDARY_COLOR));
        categoryLabel.setBounds(
                0,
                hangmanImage.getPreferredSize().height - 28,
                CommonConstants.FRAME_SIZE.width,
                categoryLabel.getPreferredSize().height
        );
        //ukryte słowo - do zgadnięcia
        hiddenWordLabel = new JLabel(CustomTools.hiddenWords(wordChallange[1]));
        hiddenWordLabel.setForeground(Color.WHITE);
        hiddenWordLabel.setBounds(
                0,
                categoryLabel.getY() + categoryLabel.getPreferredSize().height +  50,
                CommonConstants.FRAME_SIZE.width,
                hiddenWordLabel.getPreferredSize().height
        );

            getContentPane().add(categoryLabel);
            getContentPane().add(hangmanImage);
            getContentPane().add(hiddenWordLabel);
        }


}

