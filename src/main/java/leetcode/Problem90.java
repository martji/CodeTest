package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Guoqing on 2016/9/13.
 */
public class Problem90 {

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        //sort
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            tmp.add(nums[i]);
        }
        Collections.sort(tmp);
        for (int i = 0; i < nums.length; i++) {
            nums[i] = tmp.get(i);
        }

        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> arr = new ArrayList<Integer>();
        buildSet(nums, 0, arr, list);
        return list;
    }

    public static void buildSet(int[] nums, int index, List<Integer> arr, List<List<Integer>> list) {
        if (index == nums.length) {
            list.add(arr);
        } else {
            int end = index + 1;
            while (end < nums.length && nums[end] == nums[index]) {
                end++;
            }

            ArrayList<Integer> arr1 = new ArrayList<Integer>(arr);
            buildSet(nums, end, arr1, list);

            ArrayList<Integer> tmp = new ArrayList<Integer>();
            for (int i = index; i < end; i++) {
                tmp.add(nums[i]);
                ArrayList<Integer> arr2 = new ArrayList<Integer>(arr);
                arr2.addAll(tmp);
                buildSet(nums, end, arr2, list);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,2};
        subsetsWithDup(nums);
    }
}
