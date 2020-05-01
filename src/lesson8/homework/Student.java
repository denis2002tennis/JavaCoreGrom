package lesson8.homework;

public class Student {

    public static void main(String[] args) {

        Student alex=new Student("Alex","Karpenko",23,null);
    }
    String firstName;
    String lastName;
    int group;
    Course[] coursesTaken;
    int age;

    public Student(String firstName, String lastName, int group, Course[] coursesTaken) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.group = group;
        this.coursesTaken = coursesTaken;
    }


}
