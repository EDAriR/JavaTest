package sideProjectTest;

import java.util.HashMap;

public class FubanDaDa {
    public static void main(String[] args) {

        String inputStr = "(subjectId:(sy(s* NOT \" A1:1*\") OR (subjectId:sys*) OR macAddress:\"* bc:ee:(7b:db:c0:fe\") AND recordTime:[2018-03-05T16:00:00Z TO NOW]";
        boolean haveMap = false;
        StringBuilder result = new StringBuilder();
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("createTime", "recordTime_dt");
        map.put("subjectId", "subjectId_s");
        map.put("status", "status_s");
        map.put("subjectSeq", "subjectSeq_l");
        map.put("userId", "subjectUserId_s");
        map.put("macAddress", "macAddress_s");

        for (String str : map.keySet()) {
            System.out.println("str : " + str + " inputStr.contains(str) : " + inputStr.contains(str));
            if (inputStr.contains(str)) {
                haveMap = true;
            }
        }
        System.out.println("===============");
        System.out.println("haveMap : " + haveMap );

        for (String str : map.keySet()) {
            if (haveMap) {
                inputStr = inputStr.replaceAll(str, map.get(str));
            }
        }
        result = new StringBuilder(inputStr);

        System.out.println(result);
    }
}
