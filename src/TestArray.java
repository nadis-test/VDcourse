
import java.util.Random;
import java.util.Scanner;

import static java.lang.Math.round;

public class TestArray {
    //int size;
    int[] intArray;
    float[] floatArray;

    TestArray(int intsize, int floatsize){
        intArray = new int[intsize];
        floatArray = new float[floatsize];
    }

    // генерим случайные числе в интервале от Min до Max
    public int intervalIntRandom(int min, int max) {
        Random rnd = new Random();
        int i = rnd.nextInt(max - min + 1) + min;
        return i;
    }

    public float intervalFloatRandom(float min, float max) {
        Random rnd = new Random();
        float i = rnd.nextFloat()*(max-min) + min;
        return i;
    }



    //метод создает массив int и заполняем его рандомными значениями
    public void setIntArrayValues(int minvalue, int maxvalue) {

        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = intervalIntRandom(minvalue, maxvalue);
        }
    }

    //метод создает массив float и заполняем его рандомными значениями от - 100 до 100
    public void setFloatArrayValues(float minvalue, float maxvalue) {

        for (int i = 0; i < floatArray.length; i++) {
            floatArray[i] = intervalFloatRandom(minvalue, maxvalue);
        }
    }

    // выводим значения массива
    public void printArrayElem(int[] Array){
        for (int i = 0; i < Array.length; i++)
            System.out.println("Элемент int-массива: " + i + " = " + Array[i]);
    }

    public void printArrayElem(float[] Array){
        for (int i = 0; i < Array.length; i++)
            System.out.println("Элемент float-массива: " + i + " = " + Array[i]);
    }

    //метод считает сумму элементов массива
    public int getArraySum(int[] Array) {
        int sum = 0;
        for (int i = 0; i < Array.length; i++)
            sum = sum + Array[i];
        return sum;
    }

    public float getArraySum(float[] Array) {
        float sum = 0;
        for (int i = 0; i < Array.length; i++)
            sum = sum + Array[i];
        return sum;
    }

    //метод выводит все четные элементы массива по индексу
    public void printEvenElementsByIndex(int[] Array) {
        System.out.println("=======================");
        for (int i = 0; i < Array.length; i++) {
            if (i % 2 == 0) System.out.println("Чётный элемент int-массива по индексу: " + i + " = " + Array[i]);
        }
    }

    public void printEvenElementsByIndex(float[] Array) {
        System.out.println("=======================");
        for (int i = 0; i < Array.length; i++) {
            if (i % 2 == 0) System.out.println("Чётный элемент float-массива по индексу: " + i + " = " + Array[i]);
        }
    }

    // метод выводит четные элементы по значению
    public void printEvenElementsByValues(int[] Array) {
        System.out.println("=======================");
        for (int i = 0; i < Array.length; i++) {
            if (Array[i] % 2 == 0)
                System.out.println("Чётный элемент int-массива " + i + " по значению = " + Array[i]);
        }
    }

    public  void printEvenElementsByValues(float[] Array) {
        System.out.println("=======================");
        for (int i = 0; i < Array.length; i++) {
            int check = (int)(Array[i]);
            if (check % 2 == 0)
                System.out.println("Чётный элемент float-массива " + i + " по значению = " + Array[i]);
        }
    }

    //метод выводит все отрицательные значения
    public void printNegativeElements(int[] Array) {
        System.out.println("=======================");
        for (int i = 0; i < Array.length; i++) {
            if (Array[i] < 0) System.out.println("Отрицательный элемент int-массива " + i + " = " + Array[i]);
        }
    }

    public  void printNegativeElements(float[] Array) {
        System.out.println("=======================");
        for (int i = 0; i < Array.length; i++) {
            if (Array[i] <= 0f) System.out.println("Отрицательный элемент float-массива " + i + " = " + Array[i]);
        }
    }

    //метод выводит сумму элементов по абсолютной величине
    public void printSumByAbs(int[] Array) {
        int asum = 0;
        System.out.println("=======================");
        for (int i = 0; i < Array.length; i++)  asum += Math.abs(Array[i]);

        System.out.println("Сумма элементов int-массива по абсолютной величине = " + asum);
    }

    public void printSumByAbs(float[] Array) {
        float asum = 0;

        System.out.println("=======================");
        for (int i = 0; i < Array.length; i++) asum = asum + Math.abs(Array[i]);

        System.out.println("Сумма элементов float-массива по абсолютной величине = " + asum);
    }

    //метод выводит: отрицательные+5; положительные-10 только для int
    public void printAddSubstract(int[] Array) {
        int negative = 0;
        int positive = 0;

        System.out.println("=======================");
        for (int i = 0; i < Array.length; i++) {

            if (Array[i] < 0) {
                negative = Array[i] + 5;
                System.out.println("Отрицательный элемент int-массива " + i + ": " + Array[i] + " + 5 = " + negative);
            } else if (Array[i] >= 0) {
                positive = Array[i] - 10;
                System.out.println("Положительный элемент int-массива " + i + ": " + Array[i] + " - 10 = " + positive);
            }
        }
    }

    public void printAddSubstract(float[] Array) {
        float negative = 0;
        float positive = 0;
        System.out.println("=======================");
        for (int i = 0; i < Array.length; i++) {
            if (Array[i] < 0f) {
                negative = Array[i] + 5;
                System.out.println("Отрицательный элемент float-массива " + i + ": " + Array[i] + " + 5 = " + negative);
            }
        }
    }

    //метод выводит: отрицательный*2, положительный / 1.5 только для float
    public void printMultiplyDivide(int[] Array) {
        int negative = 0;
        int positive = 0;
        System.out.println("=======================");
        for (int i = 0; i < Array.length; i++) {

            if (Array[i] < 0) {
                negative = Array[i] * 2;
                System.out.println("Отрицательный элемент int-массива " + i + ": " + Array[i] + " * 2 = " + negative);
            }
        }
    }

    public void printprintMultiplyDivide(float[] Array) {
        float negative = 0;
        float positive = 0;

        System.out.println("=======================");
        for (int i = 0; i < Array.length; i++) {

            if (Array[i] < 0) {
                negative = Array[i] * 2;
                System.out.println("Отрицательный элемент float-массива " + i + ": " + Array[i] + " * 2 = " + negative);
            } else if (Array[i] >= 0) {
                positive = Array[i] / 1.5f;
                System.out.println("Положительный элемент float-массива " + i + ": " + Array[i] + " / 1.5 = " + positive);
            }
        }
    }

    //метод выводит максимальное значение в массиве
    public void printMaxElement(int[] Array) {
        System.out.println("=======================");
        int temp_max = Array[0];
        for (int i = 1; i < (Array.length); i++) {
            if (temp_max < Array[i]) temp_max = Array[i];
        }
        System.out.println("Максимальный элемент int-массива  = " + temp_max);
        System.out.println("=======================");
    }

    public  void printMaxElement(float[] Array) {
        System.out.println("=======================");
        float temp_max = Array[0];
        for (int i = 1; i < (Array.length - 1); i++) {
            if (temp_max < Array[i]) temp_max = Array[i];
        }
        System.out.println("Максимальный элемент float-массива  = " + temp_max);
        System.out.println("=======================");
    }

    //метод выводит минимальное значение в массиве
    public void printMinElement(int[] Array) {
        System.out.println("=======================");
        int temp_min = Array[0];
        for (int i = 1; i < (Array.length); i++) {
            if (temp_min > Array[i]) temp_min = Array[i];
        }
        System.out.println("Минимальный элемент int-массива  = " + temp_min);
        System.out.println("=======================");
    }

    public  void printMinElement(float[] Array) {
        System.out.println("=======================");
        float temp_min = Array[0];
        for (int i = 1; i < (Array.length); i++) {
            if (temp_min > Array[i]) temp_min = Array[i];
        }
        System.out.println("Минимальный элемент float-массива  = " + temp_min);
        System.out.println("=======================");
    }


    // метод считываем размер массива
    public static int readInt() {
        Scanner in = new Scanner(System.in);
        System.out.print("Array	size:	");
        int size = in.nextInt();
        return size;
    }

    public static void main(String[] args) {

        //читаем длину массива
        //firstArray.size = TestArray.readSize();

        //заполняем массив рандомными значениями диапазона -100;100
        //firstArray.setIntArrayValues(-100, 100);



        int intsize = readInt();
        int floatsize = readInt();
        TestArray firstArray = new TestArray(intsize, floatsize);

        firstArray.setIntArrayValues(-10,10);
        firstArray.printArrayElem(firstArray.intArray);


        // задание 1: выводим сумму массива
        int isum = firstArray.getArraySum(firstArray.intArray);
        System.out.println("Сумма элементов int-массива: " + isum);
        // задание 2: выводим четные по индексу
        firstArray.printEvenElementsByIndex(firstArray.intArray);
        // задание 3: выводим четные по значению
        firstArray.printEvenElementsByValues(firstArray.intArray);
        // задание 4: выводим отрицательне элементы для массива
        firstArray.printNegativeElements(firstArray.intArray);
        // задание 5: выводим сумму по абсолютной величине
        firstArray.printSumByAbs(firstArray.intArray);
        // задание 6: отриц-5, полож +10
        firstArray.printAddSubstract(firstArray.intArray);
        // задание 7: отриц *2
        firstArray.printMultiplyDivide(firstArray.intArray);
        //максимальные
        firstArray.printMaxElement(firstArray.intArray);
        //минимальные
        firstArray.printMinElement(firstArray.intArray);

        firstArray.setFloatArrayValues(-10f,10f);
        firstArray.printArrayElem(firstArray.floatArray);
        float fsum = firstArray.getArraySum(firstArray.floatArray);
        System.out.println("Сумма элементов float-массива: " + fsum);


        // задание 2: выводим четные по индексу
        firstArray.printEvenElementsByIndex(firstArray.floatArray);
        // задание 3: выводим четные по значению
        firstArray.printEvenElementsByValues(firstArray.floatArray);
        // задание 4: выводим отрицательне элементы для массива
        firstArray.printNegativeElements(firstArray.floatArray);
        // задание 5: выводим сумму по абсолютной величине
        firstArray.printSumByAbs(firstArray.floatArray);
        // задание 6: отриц-5
        firstArray.printAddSubstract(firstArray.floatArray);
        // задание 7: отриц *2, полож / 1.5
        firstArray.printprintMultiplyDivide(firstArray.floatArray);
        //максимальные
        firstArray.printMaxElement(firstArray.floatArray);
        //минимальные
        firstArray.printMinElement(firstArray.floatArray);

    }
}
