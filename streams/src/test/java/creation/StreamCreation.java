package creation;

import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamCreation {

    /**
     * Create Stream using Stream.of
     */
    @Test
    public void stringArrayToCSV1() {
        // Arrays to Stream using Arrays.stream
        Stream<String> stream = Stream.of("Herman", "Lily", "Eddie", "Marilyn", "Grandpa");
        String csv = stream.collect(Collectors.joining(","));
        System.out.println(csv);
    }

    /**
     * Using Arrays.stream
     */
    @Test
    public void stringArrayToCSV2() {
        // Arrays to Stream using Arrays.stream
        String[] munsters = {"Herman", "Lily", "Eddie", "Marilyn", "Grandpa"};
        String csv = Arrays.stream(munsters).collect(Collectors.joining(","));
        System.out.println(csv);
    }

    /**
     * Using Stream.iterate
     */
    @Test
    public void iterateDemo() {
        Stream<LocalDate> stream = Stream.iterate(LocalDate.of(1961, 12, 15).plusYears(1), ld -> ld.plusYears(1L))
                .limit(10);
        List<LocalDate> firstTenBirhDays = stream.collect(Collectors.toList());
        System.out.println(firstTenBirhDays);
// prints 10 days starting from today
    }


    /**
     * Use of Stream.generate
     */
    @Test
    public void generateListOfRandomDoubles() {
        List<Double> randomList = Stream.generate(Math::random)
                .limit(5)
                .collect(Collectors.toList());
        System.out.println(randomList);
    }

    /**
     * Create a stream from a collection
     * use Collection default stream method
     */
    @Test
    public void createStreamFromCollection() {
        List<String> namesList = Arrays.asList("John", "Bill", "Anita", "Elina", "Sofia");

        Stream<String> namesStream = namesList.stream();

        String allNames = namesStream.collect(Collectors.joining(","));
        System.out.println(allNames);
    }

    /**
     * Use of ranges and boxed, Int[Long]Stream range & rangeClosed methods
     * Note that without boxed code doesn't compile
     * Alternatives
     * - use of mapObj
     * - three argument version of collect
     */
    @Test
    public void rangesAndBoxingDemo() {
        IntStream intStream = IntStream.range(10, 15);
        Stream<Integer> streamOfInt = intStream.boxed();
        List<Integer> intList = streamOfInt.collect(Collectors.toList());
        System.out.println(intList);
// prints [10, 11, 12, 13, 14]

        LongStream longStream = LongStream.rangeClosed(10, 15);
        Stream<Long> streamOfLong = longStream.boxed();
        List<Long> listOfLongs = streamOfLong.collect(Collectors.toList());
        System.out.println(listOfLongs);

        // Use of mapObj
        longStream = LongStream.rangeClosed(10, 15);
        Stream<Long> streamOfLongMapped = longStream.mapToObj(Long::valueOf);
        List<Long> listOfMappedLongs = streamOfLongMapped.collect(Collectors.toList());
        System.out.println(listOfMappedLongs);

        // Use of three argument collect
        List<Long> listOfCollectedLongs = LongStream.rangeClosed(10, 15)
                .collect(ArrayList<Long>::new, ArrayList::add, ArrayList::addAll);
        System.out.println(listOfMappedLongs);
    }


}
