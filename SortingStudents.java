package me.ductrader.javapractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Student implements Comparable<Student> {
    private String name;

    public Student(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public int compareTo(Student student) {
        return this.getName().compareTo(student.getName());
    }
}

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<Student>();
        Student michael = new Student("Michael");
        students.add(michael);
        Student carl = new Student("Carl");
        students.add(carl);
        Student zach = new Student("Zach");
        students.add(zach);
        Student charlie = new Student("Charlie");
        students.add(charlie);
        Student frank = new Student("Frank");
        students.add(frank);
        for(Student s: students) {
            System.out.println(s);
        }

        System.out.println();

        Collections.sort(students);
        students.forEach(System.out::println);
    }
}
