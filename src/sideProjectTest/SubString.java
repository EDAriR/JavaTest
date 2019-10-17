package sideProjectTest;

public class SubString {

    public static void main(String args[]) {
        String N = "01:大汽车";
        String L = "";
        String R = "";
        int k = N.length();
        for (int i = 0; i < N.length(); i++) {
            if (N.substring(i, i + 1).equals(".")) {
                L = N.substring(0, i).trim();
                R = N.substring(i + 1, k).trim();
            } else {

            }
            System.out.println(L);
            System.out.println(R);
        }
    }
}
