package pattern.adapter.simple;

public class LegacyRetangleAdapter implements Rectangle{

    private LegacyRectangle adaptee;

    public LegacyRetangleAdapter(LegacyRectangle adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public double getArea() {
        return adaptee.getWidth() * adaptee.getHeight();
    }
}
