package scjpJava5.ch8.Test8;

public class Foo {

    Foo(){
        System.out.print("foo");
    }

    class Bar{

        Bar(){
            System.out.print("bar");
        }
        public void go(){
            System.out.print("hi");
        }
    }

    public static void main(String[] args) {

        Foo f = new Foo();
        f.makerBar();
    }

    void makerBar() {
        (new Bar() {
        }).go();
    }

}
