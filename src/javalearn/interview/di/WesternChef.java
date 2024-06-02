package javalearn.interview.di;

public class WesternChef implements Chef {
    @Override
    public Food cook() {
        return new Food("양식 요리");
    }
}
