package javalearn.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class TerminalOperations {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "b", "c", "d", "a", "e", "b");

        System.out.println("foreach 테스트 실행");
        list.forEach(System.out::println);
        System.out.println("---------------------");



        System.out.println("reduce 테스트 실행");
        List<StreamUser> users = Arrays.asList(
                new StreamUser("Alice", 30),
                new StreamUser("Bob", 25),
                new StreamUser("Charlie", 35)
        );
        Integer sum = users.stream()
                        .map(StreamUser::getAge)
                        .reduce(0, Integer::sum);

        System.out.println(sum);
        System.out.println("---------------------");


        // count
        long count = list.stream()
                .count();

        // anyMatch
        boolean anyMatch = list.stream()
                .anyMatch(s -> s.equals("a"));

        // allMatch
        boolean allMatch = list.stream()
                .allMatch(s -> s.length() == 1);

        // noneMatch
        boolean noneMatch = list.stream()
                .noneMatch(s -> s.equals("z"));

        System.out.println("Count: " + count);
        System.out.println("Any Match: " + anyMatch);
        System.out.println("All Match: " + allMatch);
        System.out.println("None Match: " + noneMatch);

    }

}

class StreamUser {
    private String name;
    private Integer age;

    public StreamUser(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}