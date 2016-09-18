package leetcode;

/**
 * Created by Guoqing on 2016/9/14.
 */
public class Problem41 {

    public static int firstMissingPositive(int[] nums) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            if (nums[left] == left + 1) {
                left ++;
            } else if (nums[left] <= left || nums[left] > right || nums[left] == nums[nums[left] - 1]) {
                right --;
                swap(nums, left, right);
            } else {
                swap(nums, left, nums[left] - 1);
            }
        }

        return left + 1;
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,4,-1,1};
        System.out.println(firstMissingPositive(nums));
    }
}
