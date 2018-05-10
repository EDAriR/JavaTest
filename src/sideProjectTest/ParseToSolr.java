package sideProjectTest;

import org.jvnet.hk2.internal.Collector;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ParseToSolr {



    public static Map<String, String> findCommonFieldNameMap() {
        ConcurrentHashMap<String, String> commonFieldNameMap = new ConcurrentHashMap<>();

        commonFieldNameMap.put("createTime", "recordTime_dt");
        commonFieldNameMap.put("subjectId", "subjectId_s");
        commonFieldNameMap.put("status", "status_s");
        commonFieldNameMap.put("subjectSeq", "subjectSeq_l");
        commonFieldNameMap.put("userId", "subjectUserId_s");
        commonFieldNameMap.put("macAddress", "macAddress_s");
        return commonFieldNameMap;
    }


    public static void main(String[] args) {

        String s = "%28subjectId%3A%28%22sys%22%2A%20NOT%20%22%20A1%3A1%2A%22%29%20OR%20macAddress%3A%22%2Abc%3Aee%3A7b%3Adb%3Ac0%3Afe%22%29%20AND%20recordTime%3A%5B2018-03-05T16%3A00%3A00Z%20TO%20NOW%7D";

//        String filterStr = "(subjectId:(sys* OR A11*) OR macAddress:bc:ee:7b:db:c0:fe) AND recordTime:[2018-03-05T16:00:00Z TO NOW]";
        String filterStr = "(subjectId:(sy(s* NOT \" A1:1*\") OR (subjectId:sys*) OR macAddress:\"* bc:ee:(7b:db:c0:fe\") AND recordTime:[2018-03-05T16:00:00Z TO NOW]";

        String encode = "";
        String decode = "";

        try {
            encode = URLEncoder.encode(filterStr, "utf-8");
            decode = URLDecoder.decode(s, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
//        filterStr = decode;

        System.out.println(filterStr);

        StringBuilder reDecode = new StringBuilder(decode).reverse();
        StringBuffer reDecode2 = new StringBuffer(decode).reverse();



        Map<String, String> map = findCommonFieldNameMap();
        Set<String> set = map.keySet();

        int index = 0;
        boolean flag = true;
        boolean strFlag = false;

        List<String> re = new ArrayList<>();

        for (int i = 0; i < filterStr.length(); i++) {

            String nowStr = filterStr.substring(i, i + 1);

            // 遇到
            if (nowStr.equals("\"") && strFlag == false){
                strFlag = true;
                continue;
            }

            if (nowStr.equals("\"") && strFlag == true){
                strFlag = false;
                continue;
            }

            if (strFlag)
                continue;

            if (nowStr.equals("(")){
                index = i + 1;
                continue;
            }

            if(nowStr.equals(" ")) {
                index = i +1 ;
                flag = true;
                continue;
            }

            if(nowStr.equals(":") && flag == true) {
                flag = false;
                System.out.println("eq : => " + filterStr.substring(index, i));
                String unCheckKey = filterStr.substring(index, i);

                System.out.println("unCheckKey = " + unCheckKey + " and in Keyset :" + set.contains(unCheckKey));
                if (set.contains(unCheckKey))
                    re.add(unCheckKey);
                else {
                    System.out.println("✩★☆★☆★☆★☆✩  " + unCheckKey + " not in keySet do something" + "✩★☆★☆★☆★☆✩  ");
                }
            }

        }

        System.out.println("======================");
        String reOk = "";
        for (String r:re) {
            System.out.println("r : " + r + " || get(r) : " +map.get(r));
            reOk = filterStr.replace(r, map.get(r));
            filterStr = reOk;
        }
        System.out.println(reOk);

        class logic{

            int index;
            boolean flag;
            boolean strFlag;
            int i;
            String nowStr;

            logic(int index, boolean flag, boolean strFlag, int i, String nowStr){

                index = this.index;
                flag = this.flag;
                strFlag = this.strFlag;
                i = this.i;
                nowStr =this.nowStr;
            }

//            boolean
//
//            if (nowStr.equals("\"") && strFlag == false){
//                strFlag = true;
//                continue;
//            }
//
//            if (nowStr.equals("\"") && strFlag == true){
//                strFlag = false;
//                continue;
//            }
//
//            if (strFlag)
//                    continue;
//
//            if (nowStr.equals("(")){
//                index = i + 1;
//                continue;
//            }
//
//            if(nowStr.equals(" ")) {
//                index = i +1 ;
//                flag = true;
//                continue;
//            }

        }

    }
}
