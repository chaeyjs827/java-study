package pattern.factory.shape;

public class FactoryCircleFactory implements FactoryShapeFactory {

    @Override
    public FactoryShape createShape() {
        return new FcatoryCircle();
    }
}
