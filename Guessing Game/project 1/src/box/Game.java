package box;

import java.util.ArrayList;

public class Game {

    public int GUESSTOHIGH = 2;
    public int GUESSTOLOW = 3;
    public int GUESSCORRECT = 1;
    private int randomNumber;
    private ArrayList<Integer> history = new ArrayList<Integer>();

    public Game(){
    this.randomNumber = (int) (Math.random() * 100) + 1;
    }
    
    public String getHistory(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < history.size(); i++) {

            int value = history.get(i);
            stringBuilder.append("Versuch ").append(i + 1).append(": ").append(value);
            if (i < history.size() - 1) {
                stringBuilder.append("\n");
            }
        }
        return stringBuilder.toString();
    }

    public int checkGuess(int userGuess) {
        /*
         * String currentText = historyTextArea.getText();
         * String updatedText = userGuess + "\n" + currentText;
         * historyTextArea.setText(updatedText);
         */
        this.history.add(userGuess);
        if (userGuess == randomNumber) {
            return this.GUESSCORRECT;
        } else if (userGuess < randomNumber) {
            return this.GUESSTOLOW;
        }
        return this.GUESSTOHIGH;
    }
}
