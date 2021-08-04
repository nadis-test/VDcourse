import java.util.Scanner;

class Main {

    public static int readInt() {
        Scanner in = new Scanner(System.in);
        System.out.print("Array	size:	");
        int size = in.nextInt();
        return size;
    }

//public static String readString() {
//  Scanner in = new Scanner(System.in);
//  System.out.print("Enter value:	");
//  String stringValue = in.nextInt();
//  return stringValue;
//}

    public static void main(String[] args) {

        Student newAspirant = new Aspirant("John", "Doe", "Physics-1215", "");
        newAspirant.setAvgMark(5.0);
        System.out.println("Степуха этого неудачника " + newAspirant.getScholarship());

        //System.out.println("Размер массива студентов");
        //int student_count = TestArray.ReadInt;
        //System.out.println("Размер массива аспирантов");
        //int aspirants_count = TestArray.ReadInt;

        Student[] Learners = {new Student("a","b","c"), new Aspirant("d","e","f","g")};
        Learners[0].setAvgMark(3);
        Learners[1].setAvgMark(5);
        for (int i = 0; i< Learners.length; i++) {
            System.out.println("Неудачник " + i + " = " + Learners[i]);
            System.out.println("Степуха Неудачника " + Learners[i].getScholarship());
        }
/*
        from int i = 0 to student_count {
            System.out.println("Set first name");
            String fName = readString();
            System.out.println("Set last name");
            String lName = readString();
            System.out.println("Set group title");
            String tGroup = readString();
            System.out.println("Set averageMark");
            int avgMark = TestArray.ReadInt;

            studentList[i] = new Student(fName, lName, tGroup);
            studentList[i].getScholarship();
        }

        from int i = 0 to aspirant_count {
            System.out.println("Set first name");
            String fName = readString();
            System.out.println("Set last name");
            String lName = readString();
            System.out.println("Set group title");
            String tGroup = readString();
            System.out.println("Set essai title");
            String tEssai = readString();
            int avgMark = TestArray.ReadInt;

            aspirantList[i] = new Aspirant(fName, lName, tGroup, tEssai);
            aspirantList[i].getScholarship();
        }
*/
    }
}