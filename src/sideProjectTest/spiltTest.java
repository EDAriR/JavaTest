package sideProjectTest;

public class spiltTest {


    void getclass(){

        System.out.println(this.getClass().getSimpleName());
        System.out.println(this.getClass());
    }

    public static void main(String[] args) {

        String f ="friend_01";

        String[] ff = f.split("_");

        System.out.println(ff[0].equals("friend"));

        System.out.println(ff[1]);

        new spiltTest().getclass();

        String errCode = "OBJECT_DOES_NOT_EXIST";
        System.out.println(errCode.split("_")[0]);
    }
}
