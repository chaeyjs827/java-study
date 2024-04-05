package pattern.composite.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeMain {

    public static void main(String[] args) {
        Shape triangle = new Triangle();
        Shape triangle2 = new Triangle();
        Shape circle = new Circle();

        Drawing drawing = new Drawing();
        drawing.add(triangle);
        drawing.add(triangle2);
        drawing.add(circle);

        drawing.draw("Red");

        List<Shape> shapes = new ArrayList<>();
        shapes.add(drawing);
        shapes.add(new Triangle());
        shapes.add(new Circle());

        for(Shape shape : shapes) {
            shape.draw("Green");
        }
    }
}
