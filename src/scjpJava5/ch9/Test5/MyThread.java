package scjpJava5.ch9.Test5;

public class MyThread extends Thread {

    public static void main(String[] args) {

        MyThread t = new MyThread();

        Thread x = new Thread(t);

        x.start();
    }

    public void run(){
        for (int i = 0; i < 3; i++) {
            System.out.println(i + "..");
        }
    }
}
