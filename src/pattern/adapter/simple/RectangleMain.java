package pattern.adapter.simple;

public class RectangleMain {

    /**
     * Adapter Pattern 은 한 클래스의 인터페이스를 클라이언트에서 사용하고자 하는 다른 인터페이스로 변환시켜주는 패턴입니다.
     *
     * 호환되지 않는 인터페이스를 가진 클래스들을 함께 동작할 수 있게 만들어줍니다.
     * 이를 통해 기존의 코드를 변경하지 않고도 새로운 클래스를 도입할 수 있습니다.
     * @param args
     */

    public static void main(String[] args) {
        LegacyRectangle legacyRectangle = new LegacyRectangle();
        legacyRectangle.width = 5;
        legacyRectangle.height = 10;

        Rectangle adapter = new LegacyRetangleAdapter(legacyRectangle);
        System.out.println("Area : " + adapter.getArea());
    }

}
