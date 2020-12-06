/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTH;

/**
 *
 * @author USER
 */
public class Rectangle_BTH3 implements Shape_BTH3{

    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
    
}
class Square implements Shape_BTH3 {

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
class Circle implements Shape_BTH3 {

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
class ShapeFactory {
    public Shape_BTH3 getShape(String shapeType) {
    if (shapeType == null) {
        return null;
    }
    if (shapeType.equalsIgnoreCase("CIRCLE")) {
        return new Circle();

    } else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
        return new Rectangle_BTH3();

    } else if (shapeType.equalsIgnoreCase("SQUARE")) {
        return new Square();
    }
    return null;
    }
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        //get an object of Circle and call its draw method.
        Shape_BTH3 shape1 = shapeFactory.getShape("CIRCLE");
        //call draw method of Circle
        shape1.draw();

        //get an object of Rectangle and call its draw method.
        Shape_BTH3 shape2 = shapeFactory.getShape("RECTANGLE");

        //call draw method of Rectangle
        shape2.draw();

        //get an object of Square and call its draw method.
        Shape_BTH3 shape3 = shapeFactory.getShape("SQUARE");

        //call draw method of circle
        shape3.draw();
    }
}
