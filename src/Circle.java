import java.util.Random;

public class Circle extends Shape {
    private double radius;

    Circle(double coord_x, double coord_y, double radius) {
        super(coord_x, coord_y);
        this.radius = radius;
    }

    double getRadius() {
        return radius;
    }

    @Override
    String defineType(){
        return "circle";
    }
    @Override
    double area() {
        return Math.pow(radius,2) * Math.PI;
    }

    @Override
    void printDimensions(){
        System.out.println("Radius=" + radius);
    }

    @Override
    public boolean equals(Object someObject) {
        if (this == someObject)
            return true;   // если передали тот же самый объект
        if (someObject == null)
            return false;  // если передали пустой объект
        if (!getClass().equals(someObject.getClass()))
            return false;  // если передали объект не того класса, с которым сравниваем

        Circle circle = (Circle) someObject;

        if (this.getCoordX() != circle.getCoordX()) {
            System.out.println("CoordX are not equal");
            return false;  // если первая координата не совпадает - выход
            }
        if (this.getCoordY() != circle.getCoordY()) {
            System.out.println("CoordY are not equal");
            return false; // если вторая координата не совпадает - выход
            }
        if (this.radius != circle.getRadius()) {
            System.out.println("Radius are not equal");
            return false; // если радиус не совпадает - выход
        }
        else return true;
    }
}
