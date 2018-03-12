package sideProjectTest;

public enum TEST {
    YES("yes")
    ,NO("no");

    private String value;
    private TEST(String value) {
        this.value = value;
    }
}
