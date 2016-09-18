package algorithm;

/**
 * Created by Guoqing on 2016/9/6.
 */
public class MaxSubArray {

    public static int getMaxSubArray(int[] arr, int k) {
        int len = arr.length;
        int[] sumArr = new int[len];
        int[] helpArr = new int[len];
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += arr[i];
            sumArr[i] = sum;
        }
        int maxSum = sumArr[0];
        for (int i = 0; i < len; i++) {
            if (sumArr[i] > maxSum) {
                maxSum = sumArr[i];
            }
            helpArr[i] = maxSum;
        }

        int result = 0;
        for (int i = 0; i < len; i++) {
            int tmp = arr[i] - k;
            int index = findIndex(helpArr, tmp);
            if (index != -1 && i - index + 1 > len) {
                len = i - index + 1;
            }
        }

        return result;
    }

    public static int findIndex(int[] arr, int value) {
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;
        int result = -1;
        while (low < high) {
            mid = (high + low) / 2;
            if (arr[mid] >= value) {
                result = mid;
                high = mid + 1;
            } else {
                low = mid - 1;
            }
        }
        return result;
    }

    /**
     * 二分查找
     * @param arr
     * @param value
     * @return
     */
    public static int subFind(int[] arr, int value) {
        int low = 0;
        int high = arr.length - 1;
        int result = -1;
        int mid;
        while (low <= high) {
            mid = (high + low) / 2;
            if (arr[mid] == value) {
                result = mid;
                high = mid - 1;
            } else if (arr[mid] > value) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,4,4,4,5,5,6};
        System.out.print(subFind(arr, 7));
    }
}
