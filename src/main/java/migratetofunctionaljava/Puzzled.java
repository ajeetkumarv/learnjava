package migratetofunctionaljava;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Puzzled {
    public static void main(String[] args) {

        List<Integer> data = Arrays.asList(1,2,3,4,5);
        int[] factorWrapper = {2};

        Stream stream = data.stream()
                .peek(n -> System.out.print("Before: " + factorWrapper[0]))
                .map(n -> n * factorWrapper[0])
                .peek(n -> System.out.print(" After: " + factorWrapper[0] + " "));

        factorWrapper[0] = 5; // this is picked

        stream.forEach(System.out::println);


    }
}
