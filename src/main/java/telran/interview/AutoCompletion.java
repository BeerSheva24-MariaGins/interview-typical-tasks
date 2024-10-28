package telran.interview;

import java.util.TreeSet;
import java.util.SortedSet;
import java.util.HashMap;

public class AutoCompletion {
    private TreeSet<String> lcWords = new TreeSet<>();
    private HashMap<String, String> originalWords = new HashMap<>();

    public boolean addWord(String word) {
        String lowerCaseWord = word.toLowerCase();
        originalWords.put(lowerCaseWord, word);
        return lcWords.add(lowerCaseWord);
    }

    public String[] getVariants(String prefix) {
        String lowerPrefix = prefix.toLowerCase();
        SortedSet<String> subset = lcWords.subSet(lowerPrefix, lowerPrefix + Character.MAX_VALUE);
        return subset.stream()
                .map(originalWords::get)
                .toArray(String[]::new);
    }
}
