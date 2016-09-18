package algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Guoqing on 2016/9/7.
 */
public class NKNumber {

    /**
     * 找出数组中刚出现次数大于N/K的所有数据
     * @param arr
     * @param k
     */
    public static void getNKNumber(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                if (map.size() < k) {
                    map.put(arr[i], 1);
                } else {
                    Set<Integer> keys = new HashSet<Integer>(map.keySet());
                    for (Integer key : keys) {
                        if (map.get(key) == 1) {
                            map.remove(key);
                        } else {
                            map.put(key, map.get(key) - 1);
                        }
                    }
                }
            }
        }

        Set<Integer> keys = new HashSet<Integer>(map.keySet());
        map.clear();
        for (int i = 0; i < arr.length; i++) {
            if(keys.contains(arr[i])) {
                if (!map.containsKey(arr[i])) {
                    map.put(arr[i], 1);
                } else {
                    map.put(arr[i], map.get(arr[i]) + 1);
                }
            }
        }

        for (Integer key : keys) {
            if (map.get(key) > arr.length / k) {
                System.out.println(k);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,2,3,2,4,4};
        getNKNumber(arr, 2);
    }
}
