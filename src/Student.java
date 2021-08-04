import java.util.Scanner;

public class Student {
    private String FirstName;
    private String LastName;
    private String Group;

    double averageMark;

    Student(String FN, String LN, String Gr) {
        FirstName = FN;
        LastName = LN;
        Group = Gr;
    }

    public void setAvgMark(double avgM) {
        //Scanner in = new Scanner(System.in);
        //System.out.print("Enter avg mark:	");
        //averageMark = in.nextInt();
        averageMark = avgM;
    }

    int getScholarship(){
        if (averageMark == 5) return 100;
        else return 80;
    }

    @Override
    public String toString()  {
        return (FirstName + " " + LastName + " " + Group);
    }

    //public static String readString() {
    //  Scanner in = new Scanner(System.in);
    //  System.out.print("Enter value:	");
    //  String stringValue = in.nextInt();
    //  return stringValue;
    //}
}

