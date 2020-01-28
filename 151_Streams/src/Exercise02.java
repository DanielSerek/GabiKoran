import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Exercise02 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 3, -2, -4, -7, -3, -8, 12, 19, 6, 9, 10, 14);
        List<Integer> squaredOfPositiveNumbers = numbers.stream()
                                                        .filter(n -> n > 0)
                                                        .map(n -> n * n)
                                                        .collect(Collectors.toList());

        squaredOfPositiveNumbers.stream()
                                .forEach(System.out::println);
    }
}