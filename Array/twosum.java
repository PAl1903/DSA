package Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import Array.*;

 public class twosum {

    public static void main(String[] args) {
        twosum tw = new twosum();
        int[] arr = { 1, 2, 3, 4, 5 };
        int target = 4;

        ArrayList<Pair> pair = tw.sum(arr, target, 0);

        for (int i = 0; i < pair.size(); i++) {
            System.out.println(pair.get(i));
        }
    }

     

    ArrayList<Pair> sum(int[] arr, int target, int n) {

        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Pair> arr2 = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        int prev = map.size();

        Iterator hmIterator = map.entrySet().iterator();

        while (hmIterator.hasNext()) {
            Map.Entry mapElement = (Map.Entry) hmIterator.next();

            int value = (int) mapElement.getValue();
            if (map.containsKey(Math.abs(value - target)) && map.get(Math.abs(value - target)) > 0) {
                arr2.add(new Pair(value, Math.abs(value - target)));
                map.put(value, map.get(value) - 1);
                map.put(Math.abs(value - target), map.get(Math.abs(value - target)) - 1);
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
}

