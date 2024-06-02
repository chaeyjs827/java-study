package javalearn.interview.di;

public class KoreanChef implements Chef {
    @Override
    public Food cook() {
        return new Food("한식 요리");
    }
}
