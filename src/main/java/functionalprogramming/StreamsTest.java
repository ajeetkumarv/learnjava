package functionalprogramming;

import java.util.Arrays;
import java.util.List;

public class StreamsTest {
    public static void main(String[] args) {
        List<Integer> data = Arrays.asList(1,2,3,4,5);

        int total1 = imperativeWay(data);
        int total2 = functionalWay(data);

        System.out.println("Total 1: " + total1);
        System.out.println("Total 2: " + total2);
    }

    private static int imperativeWay(List<Integer> data) {
        int total = 0;
        //this is doing lot mutation hence bad practice
        for(int i=0;i< data.size();i++) {
            total += i * 2;
        }

        return total;
    }

    /**
     * this code is easy to parallelize
     * no risk of mutation
     * @param data
     * @return
     */
    private static int functionalWay(List<Integer> data) {
        return data
            .stream()
            .map(e -> e * 2)
            //for two number perform c + e operation
            //ie to reduce 10 numbers, the relation between two nums is +
            //ie. BinaryOperator ie. take two give one
            .reduce(0, (c, e) -> c + e);
    }

    
}
