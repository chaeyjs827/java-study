package pattern.factory.shape;

public class FactoryShapeMain {

    public static void main(String[] args) {
        FactoryShapeFactory circleFactory = new FactoryCircleFactory();
        FactoryShape circle = circleFactory.createShape();
        circle.draw();

        FactoryShapeFactory rectangleFactory = new FactoryRectangleFactory();
        FactoryShape rectangle = rectangleFactory.createShape();
        rectangle.draw();
    }

}
