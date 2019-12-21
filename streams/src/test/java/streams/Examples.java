package streams;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Examples {

    /**
     * Use of Stream.of
     */
    @Test
    public void stringArrayToCSV(){
        // Arrays to Stream using Arrays.stream
        String[] munsters = { "Herman", "Lily", "Eddie", "Marilyn", "Grandpa" };
        String csv = Arrays.stream(munsters).collect(Collectors.joining(","));
        System.out.println(csv);
    }
}
