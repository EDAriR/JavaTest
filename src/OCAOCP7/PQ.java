package OCAOCP7;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PQ {

    static class PQsort implements Comparator<Integer>{

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }

    public static void main(String[] args) {

        int[] ia = {1,5,3,7,6,9,8};

        PriorityQueue<Integer> pq1 = new PriorityQueue<>();

        for (int x: ia);
    }
}
