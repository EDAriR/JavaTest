package scjpJava5.ch7;

import java.util.Arrays;
import java.util.Comparator;

public class SearchObjArray {

    //處理搜尋和排序的問題的時候的二大問題
    // 1.搜尋一個沒被排序過得陣列或集合
    // 2.在排序或搜尋使用Comparator ，但並非兩者都有使用

    public static void main(String[] args) {

        String [] sa = {"one" , "two", "three", "four"};

        //  對sa 陣列依照字母順序進行排序(自然順序)
        Arrays.sort(sa);

        for (String s : sa)
            System.out.print(s + " ");

        System.out.println(" ");

        //  尋找元素"one" 的位置 就是1
        System.out.println("\none = " + Arrays.binarySearch(sa,"one"));

        System.out.println("\nnow reverse sort\n");

        //  建立一個 compartor 實體。下一行我們會使用這個 Comparator 在重新排序。
        ResortComparator rs = new ResortComparator();

        Arrays.sort(sa, rs);

        for (String s:sa)
            System.out.print(s + " ");

        System.out.println(" ");

        //  嘗試搜尋這個陣列。我們並沒有將拿來排序的 Comparator的實體傳進 binarySearch()，因此我們得到一個不正確(未定義的）的答案。
        System.out.println("\none = " + Arrays.binarySearch(sa,"one"));

        //  再次搜，這次有將Comparator 傳入binarySearch()，因此得到正確的案，2。
        System.out.println("\none = " + Arrays.binarySearch(sa,"one", rs));

    }


    // 我們定義了 Comparator;這裡可以使用隱藏類別 (inner class)
    static class ResortComparator implements Comparator<String>{


        //  藉由交換呼叫 compareTo()的引數，我們得到一個反向的排序
        @Override
        public int compare(String a, String b){

            return b.compareTo(a);
        }

    }
}


