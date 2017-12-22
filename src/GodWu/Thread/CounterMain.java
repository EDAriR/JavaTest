package GodWu.Thread;

public class CounterMain {

    int counter = 10;

    public CounterMain() {
    } //建構者函數

    public void runMethod() { //一般的成員方法
        while (counter >0) {
            System.out.println(Thread.currentThread().getName() + "   " +counter);
            counter--;

            try {
                Thread.sleep(1000); //暫停一秒
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String arg[]) {
        CounterMain m1 = new CounterMain();
        CounterMain m2 = new CounterMain();
        m1.runMethod();
        m2.runMethod();
    }
}
