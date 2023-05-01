package Structural;

// Interface
interface Shape {
    void draw();
}

// Class implementing the interface
class Rectangle implements Shape{

    @Override
    public void draw() {
        System.out.println("Rectangle::draw()");
    }
}

// Second Class implementing the interface
class Square implements Shape{

    @Override
    public void draw() {
        System.out.println("Square::draw()");
    }
}

// Third class implementing the interface
class Circle implements Shape{

    @Override
    public void draw() {
        System.out.println("Circle::draw()");
    }
}


class ShapeMaker{
    private Shape circle;
    private Shape rectangle;
    private Shape square;

    public ShapeMaker() {
        circle = new Circle();
        rectangle = new Rectangle();
        square = new Square();
    }

    public void drawCircle() {
        circle.draw();
    }

    public void drawRectangle() {
        rectangle.draw();
    }

    public void drawSquare() {
        square.draw();
    }
}

public class Facade {
    public static void main(String[] args) {
        ShapeMaker shapeMaker = new ShapeMaker();

        shapeMaker.drawCircle();
        shapeMaker.drawRectangle();
        shapeMaker.drawSquare();
    }
}