package telran.interview;

import java.time.LocalDate;
import java.util.stream.Collectors;
import java.util.*;
import java.util.function.Function;

public class InterviewTasks {
    
    static public boolean hasSumTwo(int[] array, int sum) {
        HashSet<Integer> helpers = new HashSet<>();
        int index = 0;
        while (index < array.length && !helpers.contains(sum - array[index])) {
            helpers.add(array[index++]);
        }
        return index < array.length;
    }

    static public int getMaxWithNegativePresentation(int[] array) {
        Set<Integer> set = new HashSet<>();
        int max = -1;

        for (int element : array) {
            set.add(element);
            if (set.contains(-element)) {
                max = Math.max(max, Math.abs(element));
            }
        }
        return max;
    }

    public static List<DateRole> assignRoleDates(List<DateRole> rolesHistory, List<LocalDate> dates) {

        TreeMap<LocalDate, String> history = rolesHistory.stream()
                .collect(Collectors.toMap(DateRole::date, DateRole::role, (existing, replacement) -> existing,
                        TreeMap::new));
        return dates.stream()
                .map(date -> {
                    LocalDate floorKey = history.floorKey(date);
                    String role = floorKey != null ? history.get(floorKey) : null;
                    return new DateRole(date, role);
                })
                .collect(Collectors.toList());
    }

    public static boolean isAnagram(String word, String anagram) {
        boolean check = false;

        if (word.length() == anagram.length() && !word.equals(anagram)) {
            check = Objects.equals(getCharFrequencyMap(word), getCharFrequencyMap(anagram));
        }
        return check;
    }

    private static Map<Integer, Long> getCharFrequencyMap(String word) {
        return word.chars().boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}
