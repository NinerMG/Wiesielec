package pl.maciek;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class WindowVersion extends JFrame implements ActionListener {
    private int incorrectGuesses;
    private final WordsDefinition wordsDefinition;
    private JLabel hangmanImage, categoryLabel, hiddenWordLabel;
    private String[] wordChallange;

    private JButton[] letterButtons;


    public WindowVersion() {
        super("Wisielec (edycja Java)");
        setSize(CommonConstants.FRAME_SIZE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        getContentPane().setBackground(CommonConstants.BACKGROUND_COLOR);

        wordsDefinition = new WordsDefinition();
        letterButtons = new JButton[32];
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

        //litery
            GridLayout gridLayout = new GridLayout(4, 8);
            JPanel buttonPanel = new JPanel();
            buttonPanel.setBounds(
                    -5,
                    hiddenWordLabel.getY() + hiddenWordLabel.getPreferredSize().height,
                    CommonConstants.BUTTON_PANEL_SIZE.width,
                    CommonConstants.BUTTON_PANEL_SIZE.height
            );
            buttonPanel.setLayout(gridLayout);

            //utworzenie przycisków dla liter

            for (char c = 'A'; c <= 'Z'; c++) {
                JButton button = new JButton(Character.toString(c));
                button.setBackground(CommonConstants.PRIMARY_COLOR);
                button.setForeground(Color.BLACK);
                button.addActionListener(this);

                //używanie wartości ASCII do obliczenia indeksu
                int currentIndex = c - 'A';

                letterButtons[currentIndex] = button;
                buttonPanel.add(letterButtons[currentIndex]);

            }

            getContentPane().add(categoryLabel);
            getContentPane().add(hangmanImage);
            getContentPane().add(hiddenWordLabel);
            getContentPane().add(buttonPanel);
        }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

