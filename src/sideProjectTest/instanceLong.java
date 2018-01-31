package sideProjectTest;

public class instanceLong {
    public static void main(String[] args) {

        Long a = (long)1000;
        String b = "1000";

        a.toString();

        System.out.println((b == a.toString()));
        System.out.println((b.equals(a.toString())));
    }
}
