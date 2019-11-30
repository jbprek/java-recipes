package creation;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamConversion {

    /**
     * Convert to a List
     * using collect
     */
    @Test
    public void toListDemo(){
        Stream<String> namesStream = Stream.of("John", "Bill", "Anita", "Elina", "Sofia");
        List<String> names = namesStream.collect(Collectors.toList());
        System.out.println(names);
    }

    /**
     * Convert to a Array
     */
    @Test
    public void toArrayDemo(){
        Stream<String> namesStream = Stream.of("John", "Bill", "Anita", "Elina", "Sofia");
        String[] names = namesStream.toArray(String[]::new);
        System.out.println(Arrays.toString(names));

        IntStream intStream = IntStream.rangeClosed(1, 3);
        int[] intArr = intStream.toArray();
        System.out.println(Arrays.toString(intArr));
    }
}
