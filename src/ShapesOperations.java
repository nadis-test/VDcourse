import java.util.Arrays;
import java.util.Scanner;

class Main2 {

    public static void main(String[] args) {
        //MyUtils myUtils = new MyUtils();

        //как это сделать кросиво ? заполнить массив рандомными значениями
        Shape[] shape = {new Circle(0, 3, 0.3),
                new Rectangle(-5, -10, 1.5, 3.43),
                new Rectangle(-7, 8, 1.55, 6.78),
                new Rectangle(-7, 8, 1.55, 6.78),
                new Circle(-100, 3.2, 2),
                new Circle(-100, 3.2, 2)};

        System.out.println("==== счтитаем площадь фигур =============================");
        for (int i = 0; i < shape.length; i++) {
            System.out.println("Shape type: " + shape[i].defineType());
            System.out.println("Coordinates : x=" + shape[i].getCoordX() + " y=" + shape[i].getCoordY());  // можно в Shapes запилить printCoordinates, как лучше ?
            shape[i].printDimensions();
            System.out.println("Area of " + shape[i].defineType() + " " + i + " = " + shape[i].area());
            System.out.println("=============================");
        }

        System.out.println("==== тестируем сравение на circle =============================");
        Circle[] circle = {new Circle(1, 1, 2),
                new Circle(1, 1, 2),
                new Circle(2, 1, 2),
                new Circle(2, 2, 2),
                new Circle(2, 2, 3)};

        for (int i = 0; i < circle.length; i++) {
            for (int j = i + 1; j < circle.length; j++) {

                System.out.println("First circle coordinates :  x=" + circle[i].getCoordX() + " y=" + circle[i].getCoordY() + " Radius=" + circle[i].getRadius());
                System.out.println("Second circle coordinates : x=" + circle[j].getCoordX() + " y=" + circle[j].getCoordY() + " Radius=" + circle[j].getRadius());
                System.out.println("Are those circles equal: " + circle[i].equals(circle[j]));
                System.out.println("=============================");
            }
        }
        //
        System.out.println("==== тестируем сравение на shape =============================");
        for (int k = 0; k < shape.length; k++) {
            for (int n = k + 1; n < shape.length; n++) {
                System.out.println("First shape coordinates :  x=" + shape[k].getCoordX() + " y=" + shape[k].getCoordY());
                System.out.println("Second shape coordinates : x=" + shape[n].getCoordX() + " y=" + shape[n].getCoordY());
                System.out.println("Are those shapes equal: " + shape[k].equals(shape[n]));
                System.out.println("=============================");
            }
        }

    }
}


