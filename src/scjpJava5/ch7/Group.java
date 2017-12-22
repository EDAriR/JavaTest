package scjpJava5.ch7;

import java.util.HashSet;

public class Group extends HashSet<Person>{

    public static void main(String[] args) {

        Group pg = new Group();

        pg.add(new Person("Hans"));
        pg.add(new Person("Lotte"));
        pg.add(new Person("Jane"));
        pg.add(new Person("Hans"));
        pg.add(new Person("Jane"));

        System.out.println("Total : " + pg.size());
    }

    public boolean add(Person  o){
        System.out.println("Adding: " + o);
        return super.add(o);
    }
}

class Person{

    private final String name;

    Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
