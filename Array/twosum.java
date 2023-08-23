package Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class twosum {

    public static void main(String[] args) {
        twosum tw = new twosum();
        int[] arr = { 1, 3, 4, 5 ,2,2,3,-1,-5,6,9,2,8,-6,-2};
        int target = 6;

        ArrayList<Pair> pairs = tw.sum(arr, target);

        for (int i = 0; i < pairs.size(); i++) {
            System.out.println(pairs.get(i));
        }
    }

    ArrayList<Pair> sum(int[] arr, int target) {
    	   HashMap<Integer, Integer> map = new HashMap<>();
           ArrayList<Pair> arr2 = new ArrayList<>();

           for (int num : arr) {
               int complement = target - num;
               if (map.containsKey(complement) && map.get(complement) > 0) {
                   arr2.add(new Pair(num, complement));
                   if(map.get(num)!=null) {
                   map.put(num, map.get(num) - 1);
                   }
                   map.put(complement, map.get(complement) - 1);
               } else {
                   map.put(num, map.getOrDefault(num, 0) + 1);
               }
           }
        return arr2;
    }
}

class Pair {
    int num1;
    int num2;

    Pair(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    @Override
    public String toString() {
        return "(" + num1 + ", " + num2 + ")";
    }
}
