package scjpJava5.ch2;

public class Dog extends Animal{

    static void doStuff(){
        System.out.println("b ");
    }

    public static void main(String[] args) {


        Dog d = new Dog();

        Animal[] a = {
                new Animal(), new Dog(), new Animal(), d
        };

        for (int x = 0 ; x < a.length; x++) {
            a[x].doStuff();
            if (a[x].equals(d)) {
                System.out.println("yes");
                d.doStuff();
            }

        }
        System.out.println("==============");
        doStuff();
        Animal.doStuff();
    }
}

class Animal{

    static void doStuff(){
        System.out.println("a ");
    }
}
