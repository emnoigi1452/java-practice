package me.ductrader.javapractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Human implements Comparable<Human> {
    private String name;
    private int salary;

    public Human(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }
    public String getName() {
        return name;
    }
    public int getSalary() {
        return salary;
    }
    @Override
    public String toString() {
        return this.getName() + " - Salary: " + this.getSalary();
    }

    @Override
    public int compareTo(Human human) {
        return this.getSalary() - human.getSalary();
    }
}

public class Main {
    public static void main(String[] args) {
        List<Human> people = new ArrayList<Human>();
        Human brian = new Human("Brian", 100);
        people.add(brian);
        Human alex = new Human("Alex", 250);
        people.add(alex);
        Human sophie = new Human("Sophie", 200);
        people.add(sophie);
        Human joseph = new Human("Joseph", 175);
        people.add(joseph);
        Collections.sort(people);
        people.forEach(person -> System.out.println(person));
    }
}
