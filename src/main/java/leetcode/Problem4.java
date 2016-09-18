package leetcode;

/**
 * Created by Guoqing on 2016/9/12.
 */
public class Problem4 {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double value;
        if ((nums1.length + nums2.length) % 2 == 1) {
            value = findKthNumber(nums1, 0, nums1.length, nums2, 0, nums2.length, (nums1.length + nums2.length) / 2 + 1);
        } else {
            value = (findKthNumber(nums1, 0, nums1.length, nums2, 0, nums2.length, (nums1.length + nums2.length) / 2) +
                    findKthNumber(nums1, 0, nums1.length, nums2, 0, nums2.length, (nums1.length + nums2.length) / 2 + 1)) / 2;
        }
        return value;
    }

    public static double findKthNumber(int[] arr1, int left1, int len1, int[] arr2, int left2, int len2, int k) {
        if (len1 > len2) {
            return findKthNumber(arr2, left2, len2, arr1, left1, len1, k);
        }
        if (len1 == 0) {
            return arr2[k-1];
        }
        if (k == 1) {
            return Math.min(arr1[left1], arr2[left2]);
        }

        int p1 = Math.min(k / 2, len1), p2 = k - p1;
        if (arr1[left1 + p1 - 1] < arr2[left2 + p2 - 1]) {
            return findKthNumber(arr1, left1 + p1, len1 - p1, arr2, left2, len2, k - p1);
        } else if (arr1[left1 + p1 - 1] > arr2[left2 + p2 - 1]) {
            return findKthNumber(arr1, left1, len1, arr2, left2 + p2, len2 - p2, k - p2);
        } else {
            return arr1[left1 + p1 - 1];
        }
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1,3};
        int[] arr2 = new int[]{2,4};
        System.out.println(findMedianSortedArrays(arr1, arr2));
    }
}
