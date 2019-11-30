package creation;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8Sorting {

    /**
     * Destructive sorting, pre-8  Collections sort and Java 8 List.sort()
     */
    @Test
    public void destructiveSortDemo(){
        List<String> namesList = Arrays.asList("John", "Bill", "Anita", "Elina", "Sofia");
        // Pre JDK 8 sorting
        Collections.sort(namesList);
        System.out.println(namesList);

        namesList = Arrays.asList("John", "Bill", "Anita", "Elina", "Sofia");
        namesList.sort(String::compareTo);
        System.out.println(namesList);
    }


    /**
     * Classic way to sort Java 8 & onwards
     */
    @Test
    public void  java8classic() {
        List<String> namesList = Arrays.asList("John", "Bill", "Anita", "Elina", "Sofia");
        List<String> namesListSorted = namesList.stream().sorted().collect(Collectors.toList());
        System.out.println(namesList);
        System.out.println(namesListSorted);
    }

    @Test
    public void sortUsingMultipleCritiria() {
        /*
            Sorting by length, then  reversed lexical order
         */
        List<String> namesList = Arrays.asList("John", "Bill", "Anita", "Elina", "Sofia");
        List<String> namesListSorted = namesList.stream()
                .sorted(Comparator.comparing(String::length).thenComparing(Comparator.naturalOrder()).reversed())
                .collect(Collectors.toList());
        System.out.println(namesList);
        System.out.println(namesListSorted);
    }

}
