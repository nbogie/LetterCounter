package org.academy.lettercounter;

import java.util.*;

public class LetterCounter {
    Map<Character, Integer> counts;

    public LetterCounter() {
        counts = new HashMap<>();
    }

    public void countAll(String word) {
        for (char c : word.toCharArray()) {
            countOneLetter(c);
        }
    }

    public List<String> generateReport() {
        List<String> outputStrings = new ArrayList<>();
        Set<Character> letters = counts.keySet();

        for (Character letter : letters) {
            outputStrings.add(letter + ": " + counts.get(letter).toString());
        }
        //sort alphabetically
        Collections.sort(outputStrings);
        return outputStrings;
    }

    public int getCountForLetter(char letter) {
        Character lowerLetter = Character.toLowerCase(letter);
        Integer result = counts.get(lowerLetter);
        if (result == null) {
            return 0;
        }
        return result;
    }

    public void countOneLetter(Character inputLetter) {
        Character lowerLetter = Character.toLowerCase(inputLetter);
        if (!LetterCounter.isLetter(lowerLetter)) {
            return;
        }
        if (counts.containsKey(lowerLetter)) {
            counts.replace(lowerLetter, counts.get(lowerLetter) + 1);
        } else {
            counts.put(lowerLetter, 1);
        }
    }

    private static boolean isLetter(Character lowerLetter) {
        return Character.isLetter(lowerLetter);
    }

}
