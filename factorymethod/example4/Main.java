package factorymethod.example4;

import java.util.Calendar;

public class Main {

    public static void main(String[] args) {

        Calendar.getInstance();
        Integer.valueOf("200");
        Person.createAdult("Joao", 25);

    }

}


class Person {

    private String name;
    private int age;

    private Person(final String name, final int age) {
        this.name = name;
        this.age = age;
    }

    public static Person createAdult(String name, int age) {
        if (age < 18) {
            throw new IllegalArgumentException("Adult must be age greather than 18 years");
        }

        return new Person(name, age);
    }

}
