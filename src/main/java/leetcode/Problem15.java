package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by magq on 16/9/14.
 */
public class Problem15 {

    public static List<List<Integer>> threeSum(int[] nums) {
        //sort
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            arr.add(nums[i]);
        }
        Collections.sort(arr);
        for (int i = 0; i < nums.length; i++) {
            nums[i] = arr.get(i);
        }

        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            while (i > 0 && i < nums.length && nums[i] == nums[i-1]) {
                i++;
            }
            if (i == nums.length) {
                break;
            }
            int tmp = -1 * nums[i];
            for (int s = i + 1, t = nums.length - 1; s < t;) {
                if (nums[s] + nums[t] == tmp) {
                    arr = new ArrayList<>();
                    arr.add(nums[i]);
                    arr.add(nums[s]);
                    arr.add(nums[t]);
                    lists.add(arr);

                    s ++;
                    t --;
                } else if (nums[s] + nums[t] < tmp) {
                    s ++;
                } else {
                    t --;
                }

                while (s > i + 1 && s < nums.length && nums[s] == nums[s-1]) {
                    s ++;
                }
                while (t >= 0 && t + 1 < nums.length && nums[t] == nums[t+1]) {
                    t --;
                }
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        System.out.print(threeSum(arr).size());
    }
}
