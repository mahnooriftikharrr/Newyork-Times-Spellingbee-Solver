public class SpellingBeePuzzle {
    private String s;

    public SpellingBeePuzzle(String s) throws SpellingBeeException {
        if (s.length() != 7) {
            throw new SpellingBeeException("Not 7 letters!");
        }

        if (checkRepeatedLetters(s)) {
            throw new SpellingBeeException("Do not repeat letters!");
        }

        this.s = s.toUpperCase(); // Store the puzzle letters in uppercase
    }

    private boolean checkRepeatedLetters(String s) {
        for (int i = 0; i < s.length(); ++i) {
            char letter = s.charAt(i);
            for (int j = i + 1; j < s.length(); j++) {
                if (letter == s.charAt(j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean wordUsesPuzzleLettersOnly(String word) {
        for (int i = 0; i < word.length(); ++i) {
            char letter = word.charAt(i);
            if (!s.contains(String.valueOf(letter))) {
                return false; // Return false immediately if a letter is invalid
            }
        }
        return true; // All letters are valid
    }

    public boolean wordUsesCenterLetter(String word) {
        char centerLetter = s.charAt(0); // The first letter is the center letter
        for (int j = 0; j < word.length(); j++) {
            if (centerLetter == word.charAt(j)) {
                return true; // Center letter is used
            }
        }
        return false; // Center letter is not used
    }

    public boolean wordIsPanagram(String word) {
        int count = 0;
        for (int i = 0; i < s.length(); ++i) {
            boolean isLetter = false;
            for (int j = 0; j < word.length(); ++j) {
                if (s.charAt(i) == word.charAt(j)) {
                    isLetter = true;
                }
            }
            if (isLetter) {
                count += 1;
            }
        }
        return count == 7; // True if all 7 letters are used
    }
}