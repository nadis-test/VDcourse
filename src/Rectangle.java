import java.util.Random;

public class Rectangle extends Shape {

    private double width;
    private double length;

    Rectangle(double coord_x, double coord_y, double width, double lenght) {
        super(coord_x, coord_y);
        this.width = width;
        this.length = lenght;
    }

    double getWidth() {
        return width;
    }

    double getLength() {
        return length;
    }
    @Override
    String defineType(){
        return "rectangle";
    }

    @Override
    double area() {
        return width*length;
    }

    @Override
    public void printDimensions(){
        System.out.println("Width=" + width+"; Length=" + length);
    }

    @Override
    public boolean equals(Object someObject){
        if (this == someObject)
            return true;   // если передали тот же самый объект
        if (someObject == null)
            return false;  // если передали пустой объект
        if ( !getClass().equals(someObject.getClass()) )
            return false;  // если передали объект не того класса, с которым сравниваем

        Rectangle rectangle = (Rectangle) someObject;

        if (this.getCoordX() != rectangle.getCoordX())
            return false;  // если первая координата не совпадает - выход
        if (this.getCoordY() != rectangle.getCoordY())
            return false; // если вторая координата не совпадает - выход
        if (this.width != rectangle.getWidth())
            return false; // если ширина не совпадает - выход
        if (this.length != rectangle.getLength())
            return false; // если длина не совпадает - выход
        else return true;
    }

}
