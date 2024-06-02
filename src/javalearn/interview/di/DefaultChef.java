package javalearn.interview.di;

public class DefaultChef implements Chef {
    @Override
    public Food cook() {
        return new Food("주방장 랜덤 요리");
    }
}
