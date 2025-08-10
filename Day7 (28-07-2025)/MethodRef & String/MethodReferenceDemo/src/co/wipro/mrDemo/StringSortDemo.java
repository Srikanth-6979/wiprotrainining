package co.wipro.mrDemo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringSortDemo {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Harsha", "Chandra", "Badari", "Ashok");
        List<String> sortedNames = names.stream()
                                        .sorted(String::compareTo)
                                        .collect(Collectors.toList());
        sortedNames.forEach(System.out::println);
    }
}
