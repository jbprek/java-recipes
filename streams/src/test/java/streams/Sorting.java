package streams;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Sorting {

    /**
     * Destructive sorting, pre-8  Collections sort and Java 8 List.sort()
     */
    @Test
    public void destructiveSortDemo() {
        List<String> namesList = Arrays.asList("John", "Bill", "Anita", "Elina", "Sofia");
        // Pre JDK 8 sorting
        Collections.sort(namesList);
        System.out.println(namesList);
        // Post JDK 8 destructive sorting
        namesList = Arrays.asList("John", "Bill", "Anita", "Elina", "Sofia");
        namesList.sort(String::compareTo);
        System.out.println(namesList);
    }

    /**
     * Classic way to sort Java 8 & onwards
     */
    @Test
    public void java8classic() {
        List<String> namesList = Arrays.asList("John", "Bill", "Anita", "Elina", "Sofia");
        List<String> namesListSorted = namesList.stream().sorted().collect(Collectors.toList());
        System.out.println(namesList);
        System.out.println(namesListSorted);
    }

    /**
     * Sort using multiple criteria
     * Sorting by length, then  reversed lexical order
     */
    @Test
    public void sortUsingMultipleCritiria() {

        List<String> namesList = Arrays.asList("John", "Bill", "Anita", "Elina", "Sofia");
        List<String> namesListSorted = namesList.stream()
                .sorted(Comparator.comparing(String::length).thenComparing(Comparator.naturalOrder()).reversed())
                .collect(Collectors.toList());
        System.out.println(namesList);
        System.out.println(namesListSorted);
    }

}

/**
 * Sort using variable criteria
 * Order is specified by a flag
 */
@Test
public void testYearRange(){
    System.out.println(yearRange(false));
    System.out.println(yearRange(true));
}


public List<Integer> yearRange(boolean reverseOrder) {
    Comparator<Integer> comparator = reverseOrder ? (x, y)-> y.compareTo(x) :  (x, y)-> x.compareTo(y);
    UnaryOperator<LocalDate> incrementer = ld ->  ld.plusYears(1L);
    return Stream.iterate(LocalDate.now(), incrementer)
            .map(LocalDate::getYear)
            .limit(3)
            .sorted(comparator)
            .collect(Collectors.toList());
}
