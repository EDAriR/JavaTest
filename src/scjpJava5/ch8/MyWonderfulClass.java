package scjpJava5.ch8;

public class MyWonderfulClass {

    void go(){
        Bar b = new Bar();
        b.doStuff(new Foo() {
            public void foof() {
                System.out.println("foofy");
            }
        });
    }
}

interface Foo{
    void foof();
}

class Bar{
    void doStuff(Foo f){}
}
