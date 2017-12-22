package scjpJava5.ch9.Test15;

import java.util.Date;

public class ThreeDemo {

    synchronized void a(){
        actBusy();
    }

    static synchronized void b() {
        actBusy();
    }

    static void actBusy(){

        try {
            Thread.sleep(1000);
        }catch (InterruptedException ex){}

    }

    public static void main(String[] args) {

        final ThreeDemo x = new ThreeDemo();

        final ThreeDemo y = new ThreeDemo();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                int option = (int) (Math.random() * 4);

                System.out.println(Thread.currentThread().getName() + " " + option);
                switch (option){
                    case 0:
                        x.a();
                        System.out.println(Thread.currentThread().getName() + "x.a" + new Date().getTime());
                        break;

                    case 1:
                        x.b();
                        System.out.println(Thread.currentThread().getName() + "x.b" + new Date().getTime());
                        break;

                    case 2:
                        y.a();
                        System.out.println(Thread.currentThread().getName() + "y.a" + new Date().getTime());
                        break;
                    case 3:
                        y.b();
                        System.out.println(Thread.currentThread().getName() + "y.b" + new Date().getTime());
                        break;
                }
            }
        };

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread1.start();
        thread2.start();
    }
}
