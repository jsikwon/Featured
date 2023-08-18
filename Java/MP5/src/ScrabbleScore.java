import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ScrabbleScore {
    public static int calculateScrabbleScore(String word) {

        Map<Character, Integer> letterValues = new HashMap();
        letterValues.put('a', 1);
        letterValues.put('b', 3);
        letterValues.put('c', 3);
        letterValues.put('d', 2);
        letterValues.put('e', 1);
        letterValues.put('f', 4);
        letterValues.put('g', 2);
        letterValues.put('h', 4);
        letterValues.put('i', 1);
        letterValues.put('j', 8);
        letterValues.put('k', 5);
        letterValues.put('l', 1);
        letterValues.put('m', 3);
        letterValues.put('n', 1);
        letterValues.put('o', 1);
        letterValues.put('p', 3);
        letterValues.put('q', 10);
        letterValues.put('r', 1);
        letterValues.put('s', 1);
        letterValues.put('t', 1);
        letterValues.put('u', 1);
        letterValues.put('v', 8);
        letterValues.put('w', 4);
        letterValues.put('x', 8);
        letterValues.put('y', 4);
        letterValues.put('z', 10);

        return word.toLowerCase().chars().map(e -> letterValues.get((char)e)).sum();

    }

    public static void main(String[] args) {

        String[] wordList = {"Java", "program", "list", "string", "unix", "hours", "syntax", "error"};
        System.out.println("Top three words are:");
        Stream.of(wordList).sorted((e1,e2) -> calculateScrabbleScore(e2)-calculateScrabbleScore(e1))
                .limit(3).forEach(e -> System.out.println(e + ":" + calculateScrabbleScore(e)));

        double average = Stream.of(wordList).mapToInt(e ->calculateScrabbleScore(e)).average().getAsDouble();
        System.out.println("average is: " + average);

        Stream.of(wordList).collect(Collectors.groupingBy(e -> calculateScrabbleScore(e) > average)).forEach((k,v) ->
        System.out.println((k ? "words above average" : "words below average") + ":" + v));




    }
}
