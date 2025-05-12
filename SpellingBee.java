import java.awt.Color;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class SpellingBee {
    private SpellingBeeGraphics sbg;
    private ArrayList<String> dictionary = new ArrayList<>();
    private ArrayList<String> foundWords = new ArrayList<>();
    private String puzzleLetters; // Store the user's input

    public void run() {
        sbg = new SpellingBeeGraphics();
        sbg.addField("Puzzle", (s) -> puzzleAction(s));
        sbg.addButton("Solve", (s) -> solveAction());

        try {
            FileInputStream openFile = new FileInputStream("EnglishWords.txt");
            Scanner readFile = new Scanner(openFile);
            while (readFile.hasNext()) {
                String word = readFile.next();
                dictionary.add(word);
            }
            System.out.println("Dictionary loaded with " + dictionary.size() + " words.");
        } catch (IOException excpt) {
            System.out.println("Error loading dictionary: " + excpt.getMessage());
        }
    }

    private void puzzleAction(String s) {
        // Validate the user's input for the puzzle
        if (s.length() != 7) {
            sbg.showMessage("Puzzle must have exactly 7 letters!", Color.red);
            return;
        }
        puzzleLetters = s.toUpperCase(); // Convert to uppercase
        sbg.setBeehiveLetters(puzzleLetters); // Update the beehive in the GUI
        sbg.showMessage("Puzzle set to: " + puzzleLetters, Color.green);
    }

    private void solveAction() {
        // Ensure the puzzle letters are set
        if (puzzleLetters == null || puzzleLetters.isEmpty()) {
            sbg.showMessage("Please enter a valid puzzle first!", Color.red);
            return;
        }

        try {
            SpellingBeePuzzle puzzle = new SpellingBeePuzzle(puzzleLetters); // Use the user's input
            foundWords.clear(); // Clear previous results
            sbg.clearWordList(); // Clear the word list in the GUI
            int totalPoints = 0;

            for (String word : dictionary) {
                if (puzzle.wordUsesPuzzleLettersOnly(word) && puzzle.wordUsesCenterLetter(word)) {
                    foundWords.add(word);
                    sbg.addWord(word); // Add the word to the GUI
                    if (word.length() == 4) {
                        totalPoints += 4;
                    } else if (puzzle.wordIsPanagram(word)) {
                        totalPoints += word.length() + 7;
                    } else {
                        totalPoints += word.length();
                    }
                }
            }

            // Display results
            sbg.showMessage("Found " + foundWords.size() + " words! Total points: " + totalPoints, Color.green);
        } catch (SpellingBeeException e) {
            sbg.showMessage(e.getMessage(), Color.red);
        }
    }

    public static void main(String[] args) {
        new SpellingBee().run();
    }
}