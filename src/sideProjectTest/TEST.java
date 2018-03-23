package sideProjectTest;

public enum TEST implements ttt{
    YES("yes"){
        @Override
        public String createTest(String s){

            s = createTestUse(s);
            s = s + "  Yes";

            return s;
        }
    }
    ,NO("no"){
        @Override
        public String createTest(String s){

            s = createTestUse(s);
            s = s + "  No";

            return s;
        }

    };

    private String value;
    private TEST(String value) {
        this.value = value;
    }

    protected String createTestUse(String s){
        s = s + "_aaa_";
//        s = s + this.createTest("bbb");
        return s;
    }
}
interface ttt{
    String createTest(String s);
}