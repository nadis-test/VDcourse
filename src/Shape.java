public abstract class Shape {

    private double coord_x;
    private double coord_y;

    Shape(double coord_x, double coord_y) {
        this.coord_x = coord_x;
        this.coord_y = coord_y;
    }

    abstract double area();

    abstract String defineType();

    abstract void printDimensions();

    public double getCoordX() {
        return  coord_x;
    }

    public double getCoordY() {
        return  coord_y;
    }

    @Override
    public boolean equals(Object someObject){
        if (this == someObject)
            return true;   // если передали тот же самый объект
        if (someObject == null)
            return false;  // если передали пустой объект
        if ( !(someObject instanceof Shape) )
            return false;  // если передали объект не того класса, с которым сравниваем

        Shape shape = (Shape) someObject;

        if (this.coord_x != shape.coord_x)
            return false;  // если первая координата не совпадает - выход
        if (this.coord_y != shape.coord_y)
            return false; // если вторая координата не совпадает - выход
        else return true;
    }

    final boolean compareAreas(double area1, double area2) {
        if (area1 == area2) return true;
        else return false;
    }
}
