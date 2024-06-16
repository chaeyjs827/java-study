package javalearn.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class IntermediateOperations {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("a", "b", "c", "d", "a", "e", "b");
        System.out.println("---------------------");

        List<String> filtered = list.stream()
                .filter(s -> s.equals("a"))
                .collect(Collectors.toList());

        System.out.println("filter 테스트 실행");
        System.out.println(filtered);
        System.out.println("---------------------");

        List<String> mapped = list.stream()
                .map(IntermediateOperations::printList)
                .collect(Collectors.toList());

        System.out.println("mapped 테스트 실행");
        System.out.println(mapped);
        System.out.println("---------------------");


        List<String> sorted = list.stream()
                .sorted()
                .collect(Collectors.toList());

        List<String> reverseSorted = list.stream()
                        .sorted(Comparator.reverseOrder())
                        .collect(Collectors.toList());

        System.out.println("sorted 테스트 실행");
        System.out.println(sorted);
        System.out.println(reverseSorted);
        System.out.println("---------------------");


        List<String> distinct = list.stream()
                        .distinct()
                        .collect(Collectors.toList());

        System.out.println("distinct 테스트 실행");
        System.out.println(distinct);
        System.out.println("---------------------");

        List<String> limited = list.stream()
                    .limit(1)
                    .collect(Collectors.toList());

        System.out.println("limited 테스트 실행");
        System.out.println(limited);
        System.out.println("---------------------");

        List<String> skipped = list.stream()
                        .skip(2)
                        .collect(Collectors.toList());


        System.out.println("skipped 테스트 실행");
        System.out.println(skipped);
        System.out.println("---------------------");


    }

    public static String printList(String str) {
        return str.toUpperCase();
    }

}
