package unit9.Classwork.Student;

import java.util.Arrays;

/**
 * class Student
 * with 4 instance variables,
 * 3 constructors, a print method,
 * and a main method to test them.
 */
public class Student {
    // Write 4 instance variables
    private String name, id;
    private int grade;
    private String[] classes;

    // Write 3 constructors to initialize the instance variables
    //  1. no parameters using default values
    //  2. 1 parameter and the rest default values
    //  3. 4 parameters

    public Student(String iname, String iid, int igrade, String[] iclasses) {
        name = iname;
        id = iid;
        grade = igrade;
        classes = iclasses;
    }

    public Student() {
        new Student("No Name provided", "0000000", 9, new String[7]);
    }

    public Student(String iname) {
        new Student(iname, "0000000", 9, new String[7]);
    }

    // Write a print method that prints all the instance variables
    public void print() {
        System.out.println("name: " + name);
        System.out.println("id: " + id);
        System.out.println("grade: " + grade);
        System.out.println("classes: " + Arrays.toString(classes));
    }

    // main method
    public static void main(String[] args) {
        // Construct 3 Student objects using the 3 different constructors
        Student s1 = new Student();
        Student s2 = new Student("david");
        Student s3 = new Student("boe jiden", "1234567", 4274, new String[]{"engrish", "history", "math", "chemistry"});
        s1.print();
        s2.print();
        s3.print();

        // call their print() methods

    }
}
 