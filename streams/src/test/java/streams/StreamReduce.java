package streams;

import org.junit.Test;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.OptionalInt;

public class StreamReduce {

    @Test
    public void simpleIntReductionOperations() {
        String[] strings = "this is an array of strings".split(" ");
        long count = Arrays.stream(strings)
                .map(String::length)
                .count();
        System.out.println("There are " + count + " strings");

        int totalLength = Arrays.stream(strings)
                .mapToInt(String::length)
                .sum();
        System.out.println("The total length is " + totalLength);

        Double ave = Arrays.stream(strings)
                .mapToInt(String::length)
                .average().orElse(0.0);
        System.out.println("The average length is " + ave);

        Integer max = Arrays.stream(strings)
                .mapToInt(String::length)
                .max().orElse(-1);

        Integer min = Arrays.stream(strings)
                .mapToInt(String::length)
                .min().orElse(-1);

        System.out.println("The max and min lengths are " + max + " and " + min);
    }
}
