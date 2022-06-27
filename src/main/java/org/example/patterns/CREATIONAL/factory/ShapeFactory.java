package org.example.patterns.CREATIONAL.factory;

public class ShapeFactory {

    public static Shape getShape(String shapeName) {
        return switch (shapeName) {
            case "CIRCLE" -> new Circle();
            case "SQUARE" -> new Square();
            case "RECTANGLE" -> new Rectangle();
            case "TRIANGLE" -> new Triangle();
            default -> null;
        };
    }
}
