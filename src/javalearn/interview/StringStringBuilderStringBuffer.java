package javalearn.interview;

public class StringStringBuilderStringBuffer {

    public static void main(String[] args) {
    }

    private void aboutString() {
        // String 은 불변(Immutable) 객체이다.
        String str1 = "Hello";

        // 만약 이렇게 할 경우 "Hello"의 주소 대신 "hi"의 주소를 참조하여, "Hello"는 GC가 삭제한다.
        // 즉, 인스턴스 자체가 교체 되더라도 인스턴스의 문자열이 변경되는건 아니기 때문에 '불변'이라 할 수 있다.
        str1 = "hi";

        System.out.println(str1);

        // 또한 변화가 없기 때문에 thread-safe 하다
    }

    private void aboutStringBuffer() {
        StringBuffer stringBuffer = new StringBuffer("Hello");
        stringBuffer.append(" world");
        System.out.println(stringBuffer.toString());

        // StringBuffer 클래스는 가변(immutable)이며 멀티스레드 환경에서 사용할 수 있다. 즉, thread-safe 하다.
        // -> 동기화(synchronized)된 메서드를 제공한다.
    }

    private void aboutStringBuilder() {
        StringBuilder stringBuilder = new StringBuilder("Hello");
        stringBuilder.append(" world");
        System.out.println(stringBuilder.toString());

        // StringBuilder는 StringBuffer 와 유사하지만, 멀티스레드 환경에서의 동기화를 제공하지 않습니다. 따라서 단일 스레드 환경에서 더 빠른 성능을 제공합니다.
    }

}
