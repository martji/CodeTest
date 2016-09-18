package leetcode;

/**
 * Created by Guoqing on 2016/9/13.
 */
public class Problem31 {

    public static void nextPermutation(int[] nums) {
        boolean flag = false;
        int index = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i+1]) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            flag = true;
            int tmp = index + 1;
            for (int i = tmp + 1; i < nums.length; i++) {
                if (nums[i] <= nums[tmp] && nums[i] > nums[index]) {
                    tmp = i;
                }
            }
            swap(nums, index, tmp);

            for (int k = 1; k <= (nums.length - 1 - index) / 2; k++) {
                swap(nums, index + k, nums.length - k);
            }
        }

        if (!flag) {
            for (int k = 0; k < nums.length / 2; k++) {
                swap(nums, k, nums.length - 1 - k);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,2};
        nextPermutation(arr);
    }
}
