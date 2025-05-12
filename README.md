# NewYork Times Spelling Bee Solver

The **Newyork Times Spelling Bee Solver** is a Java-based application that helps users solve the popular Spelling Bee puzzle. Users can input a set of 7 letters, and the program will find all valid words from a dictionary that meet the puzzle's rules. The application features a graphical user interface (GUI) for an interactive experience.

---

<img width="503" alt="image" src="https://github.com/user-attachments/assets/12d87932-cd9a-4c6a-9ba3-fa8eb08fb288" />


## Features

- **Graphical Interface**: Displays a hexagonal beehive with the entered letters.
- **Word Finder**: Finds all valid words from the dictionary that:
  - Use only the provided letters.
  - Include the center letter.
- **Scoring System**: Calculates total points based on word lengths and panagrams.
- **Customizable Dictionary**: Uses a text file (`EnglishWords.txt`) as the word source.

---

## How to Run

### Prerequisites
- Java Development Kit (JDK) installed (version 8 or higher).
- A text editor or IDE (e.g., Visual Studio Code, IntelliJ IDEA).
- `EnglishWords.txt` file containing a list of valid words (one word per line).

### Steps
1. **Clone or Download the Project**:
   - Place all `.java` files and `EnglishWords.txt` in the same directory.

2. **Compile the Code**:
   Open a terminal in the project directory and run:
   ```bash
   javac SpellingBee.java SpellingBeePuzzle.java SpellingBeeGraphics.java SpellingBeeEventListener.java SpellingBeeException.java
   ```

3. **Run the Program**:
   Execute the following command:
   ```bash
   java SpellingBee
   ```

4. **Input Letters**:
   - Enter 7 unique letters in the "Puzzle" field.
   - Click the "Solve" button to find all valid words.

---

## Rules for Valid Words

1. Words must use only the 7 provided letters.
2. Words must include the **center letter** (the first letter in the input).
3. Words must be at least 4 letters long.
4. Panagrams (words using all 7 letters) earn bonus points.

---

## File Structure

```
Spellingbee Solver/
├── SpellingBee.java               # Main application logic
├── SpellingBeePuzzle.java         # Puzzle validation and word-checking logic
├── SpellingBeeGraphics.java       # GUI implementation
├── SpellingBeeEventListener.java  # Event listener interface
├── SpellingBeeException.java      # Custom exception handling
├── EnglishWords.txt               # Dictionary file (one word per line)
```

---

## Troubleshooting

### No Words Found
- Ensure the `EnglishWords.txt` file is in the same directory as the `.java` files.
- Verify that the input letters include valid words from the dictionary.
- Check the console for debug messages.

### GUI Not Displaying
- Ensure the `SpellingBeeGraphics` class is properly initialized.
- Verify that the Java Swing library is supported on your system.

---

## Example Usage

### Input
- Puzzle Letters: `AZDIRWY`
- Center Letter: `A`

### Output
- Found Words: `AIRWAY`, `AWARD`, `WARD`
- Total Points: `15`

---

## Customization

### Updating the Dictionary
Replace the contents of `EnglishWords.txt` with your own word list. Ensure each word is on a new line.

---

## Author

Developed by Mahnoor Iftikhar . For questions or feedback, feel free to reach out!
```
