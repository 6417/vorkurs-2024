package box;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class window {
    private Game spiel;
    private static JTextField textField;
    private static JButton guessButton;
    private static JLabel resultLabel;
    private static JTextArea historyTextArea;
    private int guessCount; // Variable zur Verfolgung der Versuche

    private void enterPressed() {
        try {
            int userGuess = Integer.parseInt(textField.getText());
            int result = this.spiel.checkGuess(userGuess);
            System.out.println(result);
            guessCount++; // Erhöhen Sie die Anzahl der Versuche
            if (result == this.spiel.GUESSCORRECT) {
                resultLabel.setText("Congratulations! You guessed the correct number in " + guessCount + " tries.");
                guessButton.setEnabled(false);
            } else if (result == this.spiel.GUESSTOHIGH) {
                resultLabel.setText("Try a lower number.");
            } else if (result == this.spiel.GUESSTOLOW) {
                resultLabel.setText("Try a higher number.");
            }
            String currentText = this.spiel.getHistory();
            historyTextArea.setText(currentText);
            textField.setText("");
        } catch (NumberFormatException e) {
            resultLabel.setText("Please enter a valid number.");
        }
    }

    public void main() {
        this.spiel = new Game();
        guessCount = 0; // Setzen Sie die Anzahl der Versuche auf 0
        JFrame frame;
        frame = new JFrame("Number Guess Game");
        frame.setLayout(new GridBagLayout());

        textField = new JTextField(10);
        guessButton = new JButton("Guess");
        resultLabel = new JLabel("");
        historyTextArea = new JTextArea(10, 20);

        historyTextArea.setEditable(false);

        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);

        c.gridx = 0;
        c.gridy = 0;
        frame.add(textField, c);

        c.gridx = 1;
        frame.add(guessButton, c);

        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 2;
        frame.add(resultLabel, c);

        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 2;
        frame.add(new JScrollPane(historyTextArea), c);

        guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enterPressed();
            }
        });

        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    enterPressed();
                }
            }
        });

        frame.setVisible(true);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
}