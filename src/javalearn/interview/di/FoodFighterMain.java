package javalearn.interview.di;

public class FoodFighterMain {
    public static void main(String[] args) {
        Chef westernChef = new WesternChef();
        Chef koreanChef = new KoreanChef();

        westernChef.cook();
        koreanChef.cook();

        // 이렇게 할 경우 양식/한식 조리가 가능하다.
        // 하지만 동적인 처리가 불가능하다.

        // 이럴경우 외부에서 파라미터를 전달 받아 동적 처리가 가능하다.
        Chef chef = getChef("Korean");
        chef.cook();

        // 위에 내용은 Food 객체 받기 전 일반 예제임. 실제 예제는 아래
        FoodFighter foodFighter = new FoodFighter(chef);
        foodFighter.eat();
    }

    private static Chef getChef(String type) {
        if (type.equals("Western")) {
            return new WesternChef();
        } else if (type.equals("Korean")) {
            return new KoreanChef();
        } else {
            return new DefaultChef();
        }
    }
}
