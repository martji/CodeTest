package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Guoqing on 2016/9/13.
 */
public class Problem78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> arr = new ArrayList<Integer>();
        buildSet(nums, 0, arr, list);
        return list;
    }

    public void buildSet(int[] nums, int index, List<Integer> arr, List<List<Integer>> list) {
        if (index == nums.length) {
            list.add(arr);
        } else {
            ArrayList<Integer> arr1 = new ArrayList<Integer>(arr);
            ArrayList<Integer> arr2 = new ArrayList<Integer>(arr);
            arr2.add(nums[index]);
            buildSet(nums, index + 1, arr1, list);
            buildSet(nums, index + 1, arr2, list);
        }
    }
}
