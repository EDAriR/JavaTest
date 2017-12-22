package scjpJava5.ch9;

class NameRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 993; i++) {
            System.out.println("Run by " + Thread.currentThread().getName() + ", i is " + i );
        }
    }
}

public class ManyNames{
    public static void main(String[] args) {

        NameRunnable nr = new NameRunnable();

        Thread one = new Thread(nr);
        Thread two = new Thread(nr);
        Thread three = new Thread(nr);

        one.setName("Fred");
        two.setName("Lucy");
        three.setName("Ricky");

        one.start();
        two.start();
        three.start();
    }
}
