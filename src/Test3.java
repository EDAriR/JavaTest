public class Test3 {


    public static void main(String[] args) {

        Long ecgPoint = Long.valueOf(10);
        Long interpretationPoint = Long.valueOf(20);
        Long integrationReportpoint = Long.valueOf(30);

        int count = 2;

        Long point = (ecgPoint * count) + (interpretationPoint * count) + integrationReportpoint;
        Long point2 = ecgPoint * count + interpretationPoint * count + integrationReportpoint;

        System.out.println(point);
        System.out.println(point2);
    }

}
