package javalearn.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamFilterLearn {

    public static void main(String[] args) {
        StreamLearnCustomer john = new StreamLearnCustomer("John P.", 15);
        StreamLearnCustomer sarah = new StreamLearnCustomer("Sarah M.", 200);
        StreamLearnCustomer charles = new StreamLearnCustomer("Charles B.", 150);
        StreamLearnCustomer mary = new StreamLearnCustomer("Mary T.", 1);

        List<StreamLearnCustomer> customerList = Arrays.asList(john, sarah, charles, mary);

        List<StreamLearnCustomer> list = customerList
                .stream()
                .filter(c -> c.getPoints() > 100)
                .collect(Collectors.toList());

        list.stream().forEach(System.out::println);
    }

}

class StreamLearnCustomer {
    private String name;
    private int points;

    public StreamLearnCustomer(String name, int points) {
        this.name = name;
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "StreamLearnCustomer{" +
                "name='" + name + '\'' +
                ", points=" + points +
                '}';
    }
}