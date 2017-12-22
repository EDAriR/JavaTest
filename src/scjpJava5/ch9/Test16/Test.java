package scjpJava5.ch9.Test16;

public class Test {

    public static void main(String[] args) {
        final Foo f = new Foo();

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                f.doStuff();
            }
        });

        Thread g = new Thread(){
            @Override
            public void run() {
                f.doStuff();
            }
        };

        t.start();
        g.start();
    }
}

class Foo{

    int x = 5;

    public void doStuff(){

        if (x < 10) {

            // nothing to do

            try {
                wait();
            }catch (InterruptedException ex ){

            }

        }else {

            System.out.println("x is " + x++);
            if(x >= 10){
                notify();
            }
        }
    }
}