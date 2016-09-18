package leetcode;

/**
 * Created by magq on 16/9/14.
 */
public class Problem198_213 {

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(subRob(nums, 0, nums.length - 2), subRob(nums, 1, nums.length - 1));
    }

    public int subRob(int[] nums, int start, int end) {
        int len = end - start + 1;
        if (len == 1) {
            return nums[start];
        } else if (len == 2) {
            return Math.max(nums[start], nums[start+1]);
        } else {
            int[] help = new int[len];
            help[0] = nums[start];
            help[1] = Math.max(nums[start], nums[start+1]);
            help[2] = Math.max(nums[start+1], nums[start] + nums[start+2]);
            for (int i = 3; i < len; i++) {
                help[i] = Math.max(help[i-1], help[i-2] + nums[start+i]);
            }
            return help[len-1];
        }
    }
}
