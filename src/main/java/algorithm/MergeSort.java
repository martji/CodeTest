package algorithm;

/**
 * Created by Guoqing on 2016/9/8.
 */
public class MergeSort {

    public static void mergeSort(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid+1, right);
        merge(arr, left, mid, right);
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int[] tmp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                tmp[k++] = arr[i++];
            } else {
                tmp[k++] = arr[j++];
            }
        }
        if (i <= mid) {
            while (i <= mid) {
                tmp[k++] = arr[i++];
            }
        } else if (j <= right) {
            while (j <= right) {
                tmp[k++] = arr[j++];
            }
        }

        for (k = 0; k < tmp.length; k++) {
            arr[left + k] = tmp[k];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,5,7,9,2,4,6,10,8};
        mergeSort(arr, 0, arr.length - 1);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
