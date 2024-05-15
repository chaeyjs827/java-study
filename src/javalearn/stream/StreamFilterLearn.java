package javalearn.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamFilterLearn {

    public static void main(String[] args) {
        StreamLearnCompany company = new StreamLearnCompany("testCompany");
        StreamLearnCustomer john = new StreamLearnCustomer("John P.", 15, company);
        StreamLearnCustomer sarah = new StreamLearnCustomer("Sarah M.", 200, company);
        StreamLearnCustomer charles = new StreamLearnCustomer("Charles B.", 150, company);

        StreamLearnCompany company2 = new StreamLearnCompany("DAN_COC");
        StreamLearnCustomer mary = new StreamLearnCustomer("Mary T.", 1, company2);

        List<StreamLearnCustomer> customerList = Arrays.asList(john, sarah, charles, mary);

        System.out.println("=====단일 조건=====");
        // 단일 조건
        customerList
            .stream()
            .filter(c -> c.getPoints() > 100)
            .forEach(System.out::println);

        System.out.println("=================");

        System.out.println("=====다중 조건=====");
        customerList
            .stream()
            .filter(c -> c.getPoints() > 100 && c.getName().equals("Sarah M."))
            .forEach(System.out::println);
        System.out.println("=================");

        System.out.println("=====다중 조건 with 자식 객체 조회=====");
        customerList
                .stream()
                .filter(c -> c.getCompany().getCompanyName().equals("testCompany") && c.getPoints() > 100)
                .forEach(System.out::println);
        System.out.println("=================");

    }

}

class StreamLearnCustomer {
    private String name;
    private int points;
    private StreamLearnCompany company;

    public StreamLearnCustomer(String name, int points, StreamLearnCompany company) {
        this.name = name;
        this.points = points;
        this.company = company;
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

    public StreamLearnCompany getCompany() {
        return company;
    }

    public void setCompany(StreamLearnCompany company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "StreamLearnCustomer{" +
                "name='" + name + '\'' +
                ", points=" + points +
                ", company=" + company +
                '}';
    }
}


class StreamLearnCompany {
    private String companyName;

    public StreamLearnCompany(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }
}