package scjpJava5.ch7;

public class EqualsTest {
    public static void main(String[] args) {

        Moof one = new Moof(8);
        Moof Two = new Moof(8);

        if (one.equals(Two)){
            System.out.println(" one and two are eq");
        }
    }
}

class Moof {

    private int moofValue;

    Moof(int val) {
        moofValue = val;
    }

    public int getMoofValue() {
        return moofValue;
    }

    //(((Moof) obj).getMoofValue() == this.moofValue) 可以編譯但是不好
    @Override
    public boolean equals(Object obj) {
        if ((obj instanceof Moof) && (((Moof) obj).getMoofValue() == this.moofValue)) {
            return true;
        }
        else return false;
    }

}
