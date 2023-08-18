import java.util.Random;
import java.util.stream.Stream;

import java.util.stream.Collectors;

public class CountDigits {
    public static void main(String[] args) {
        Random random = new Random();
        System.out.println("Number : Count");
        Stream.generate(() -> random.nextInt(10)).limit(100).collect(Collectors.groupingBy(e -> e, Collectors.counting()))
                .forEach((k, v) -> System.out.println(k + " : " + v));
    }
}


