package patterns.behavioural.visitor;

import java.util.Arrays;
import java.util.List;

public class VisitorPatternInCollections {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // Use Consumer to print each number (a "visitor" that prints)
        numbers.forEach(System.out::println);

        // Use Predicate to filter and remove even numbers
        numbers.removeIf(n -> n % 2 == 0); //Predicate is a visitor that filters
        System.out.println(numbers);
    }
}