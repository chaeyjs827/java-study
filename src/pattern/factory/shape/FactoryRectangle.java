package pattern.factory.shape;

public class FactoryRectangle implements FactoryShape {
    @Override
    public void draw() {
        System.out.println("Rectangle Drawn");
    }
}
