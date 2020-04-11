import java.util.Arrays;
import java.util.List;

public class Exercise04 {

    public static void main(String[] args) {
        // Write a Stream Expression to get the average value of the odd numbers from the following list:
        List<Integer> numbers = Arrays.asList(1, 3, -2, -4, -7, -3, -8, 12, 19, 6, 9, 10, 14);
        Double result = numbers.stream()
                // verzió 1:
//                                        .filter(n -> (n % 2 == 1) || (n % 2 == -1))
                // verzió 2:
//                                        .filter(n -> !(n % 2 == 0) )
                // verzió 3:
                .filter(n -> !((n & 1) == 0))
                .mapToInt(n -> n)
                .average()
                .getAsDouble();
        System.out.println(result);
    }
}
