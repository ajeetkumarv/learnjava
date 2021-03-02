package collections.flatmap;

import java.util.List;
import java.util.stream.Collectors;

public class FlatMapTest {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1,2,3);

        List<List<Integer>> numsNested = nums.stream().map(e -> List.of(e-1, e+1)).collect(Collectors.toList());
        System.out.println("One to Many data: " + numsNested);

        List<Integer> flattned = nums.stream().flatMap(e -> List.of(e-1, e+1).stream()).collect(Collectors.toList());
        System.out.println("Flattened: " + flattned);
    }
}
