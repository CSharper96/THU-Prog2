package HornyMerk.prog2.exercises.set06.Utilities;

import java.net.CookieHandler;
import java.util.*;

import static java.util.stream.Collectors.toMap;

public class Collector
{
    public static Map<String, Integer> CollectedWords = new HashMap<>();
    public static Integer LineCount = 0;
    public static Integer WordCount = 0;

    public static void add(String s)
    {
        if(!check(s))
        {
            CollectedWords.put(s, 1);
        }
        else
            CollectedWords.put(s, CollectedWords.get(s) + 1);
    }
    private static boolean check(String s)
    {
        if(CollectedWords.get(s) != null)
            return true;
        else
            return false;
    }
    public static void sort()
    {
        Map<String, Integer> sorted = new HashMap<>();
        sorted = CollectedWords
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(
                        toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                                LinkedHashMap::new));
        CollectedWords = sorted;
    }
}
