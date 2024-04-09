package pattern.factory.shape;

public class FactoryRectangleFactory implements FactoryShapeFactory {
    @Override
    public FactoryShape createShape() {
        return new FactoryRectangle();
    }
}
