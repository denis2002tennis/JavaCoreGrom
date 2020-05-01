package lesson8.homework;

import java.util.Date;

public class Demo {

    public static Student student=new Student("Alex","Karpenko",23,null);
    public static Student student2=new Student("Kiril","Sviderskiy",11,null);
    public static Student[] students={student,student2};
    public static Course java= new Course(new Date(),"Java",12,"Vasya",students);
    public static Course c= new Course(new Date(),"C",10,"Andrey",students);
    public static Course[] courses= {java,c};
    public static void main(String[] args) {



    }
    public static Student createHighestParent() {
        return new Student("Denis", "Semenov", 2, courses);
    }

    public static SpecialStudent createLowestChild() {
        return new SpecialStudent("Vasiliy", "Ignatenko", 1, courses, 134464757, "Vasya@gmail.com");
    }

}
