package javalearn.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamLearn {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");
        List<StreamUserDto> userDtoList = getUserDtoList();

        streamMapTest(userDtoList);
//        streamFilterTestByDto(userDtoList);
//        streamFilterTest(names);
    }

    private static void streamMapTest(List<StreamUserDto> userDtoList) {
        List<String> resultList =  userDtoList.stream()
                .map(StreamLearn::getFullName)
                .collect(Collectors.toList());
        System.out.println(resultList);
    }

    private static String getFullName(StreamUserDto userDto) {
        return userDto.getName() + " - " + userDto.getEmail();
    }

    private static void streamFilterTest(List<String> names) {
        List<String> newNames = names.stream()
                .filter(name -> name.startsWith("A"))
                .collect(Collectors.toList());
        System.out.println(newNames);
    }

    private static void streamFilterTestByDto(List<StreamUserDto> userDtoList) {
        List<StreamUserDto> newUserDtoList = userDtoList.stream()
                .filter(user -> user.getName().equals("sdf"))
                .collect(Collectors.toList());
        System.out.println(newUserDtoList);
    }

    private static List<StreamUserDto> getUserDtoList() {
        StreamUserDto userDto1 = new StreamUserDto("sdf", 13, "email@test.com");
        StreamUserDto userDto2 = new StreamUserDto("ad", 25, "email@test.com");
        StreamUserDto userDto3 = new StreamUserDto("xcv", 36, "email@test.com");
        StreamUserDto userDto4 = new StreamUserDto("asdf", 47, "email@test.com");
        StreamUserDto userDto5 = new StreamUserDto("zxv", 58, "email@test.com");
        StreamUserDto userDto6 = new StreamUserDto("kuk", 69, "email@test.com");
        StreamUserDto userDto7 = new StreamUserDto("test_name", 47, "email@test.com");

        return Arrays.asList(userDto1, userDto2, userDto3, userDto4, userDto5, userDto6, userDto7);
    }

}

class StreamUserDto {
    private String name;
    private Integer age;
    private String email;

    public StreamUserDto(String name, Integer age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "StreamUserDto{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}