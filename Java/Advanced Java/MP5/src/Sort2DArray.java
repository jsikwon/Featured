import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Sort2DArray {
    //Number array: {{34,89},{56,3},{27,61},{45,8},{45,89}}

    public static void main(String[] args) {
        int[][] myArr = {{34,89},{56,3},{27,61},{45,8},{45,89}};
        Stream.of(myArr).flatMapToInt(e -> IntStream.of(e)).distinct().sorted().forEach(e -> System.out.print(e + " "));
    }

}
