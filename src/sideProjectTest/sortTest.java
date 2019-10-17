package sideProjectTest;

import java.util.*;
import java.util.stream.Collectors;

public class sortTest {

    public static void main(String[] args) {


        Object[] o1 = {"aaa", "D1"};
        Object[] o2 = {"aaa", "D1111"};
        Object[] o3 = {"aaa", "D2"};
        Object[] o5 = {"aaa", "Others"};
        Object[] o4 = {"aaa", "Dxx"};

        List<Object[]> list = Arrays.asList(o1, o2, o3, o4, o5);

        List<Object[]> listAllString = new ArrayList<>();
        TreeMap<String, Object[]> stringAndSeq = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                // 先比較第一個字 A1 < D1
                if(o1.charAt(0) < o2.charAt(0)){
                    return -1;
                }

                // 除了第一個字以外轉Integer
                boolean flag1 = false;
                boolean flag2 = false;
                Integer i1 = 0;
                try{
                    i1 = Integer.valueOf(o1.substring(1,o1.length()));
                }catch (Exception e){
                    flag1 = true;
                }

                Integer i2 = 0;
                try{
                    i2 = Integer.valueOf(o2.substring(1,o2.length()));
                }catch (Exception e){
                    flag2 = true;
                }

                // 兩個都轉失敗 視為均為字串
                if(flag1 && flag2){
                    return 0;
                }

                // flag1 失敗 1 AAA > A11
                if(flag1){
                    return 1;
                }
                // flag2 失敗 -1
                if(flag2){
                    return -1;
                }

                if(i1 < i2){
                    return -1;
                }else if(i1 == i2){
                    return 0;
                }else {
                    return 1;
                }

            }
        });

        for (Object[] o : list) {
            if (Objects.nonNull(o[1])) {
                char[] c = o[1].toString().toCharArray();
                if (Objects.nonNull(c[1])) {
                    int i = (int) c[1];
                    if (!(57 >= i && i >= 48)) {
                        listAllString.add(o);
                        continue;
                    }
                }
            }
            stringAndSeq.put(o[1].toString(),o);
        }

        List<Object[]> newList = new ArrayList<>();


//        stringAndSeq.entrySet().stream().forEach(s -> System.out.println(s.getValue()));
        newList = stringAndSeq.values().stream().collect(Collectors.toList());

        newList.addAll(listAllString);

//        newList.forEach(o ->System.out.println(o[1].toString()));
        String a1 = "D11";
        String a2 = "D2";
        String a3 = "D1";
        String a4 = "DD";

        List<String> ll = Arrays.asList(a1, a2, a3, a4);

        System.out.println(ll);

        ll.sort(Comparator.comparing(String::length).thenComparing(String::compareTo));
//Collections.sort(ll);

        System.out.println(ll);


    }
}
