package algorithm;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by Guoqing on 2016/9/5.
 */
public class HeapSort {

    public static void main(String[] args) {

    }

    public static int[] getMinKNum(int[] arr, int k) {
        if (k < 0 || k > arr.length) {
            return arr;
        }
        int[] tmp = new int[k];
        for (int i = 0; i < k; i++) {
            heapInsert(tmp, arr[i], i);
        }

        for (int i = k; i < arr.length; i++) {
            if (arr[i] < tmp[0]) {
                tmp[0] = arr[i];
                heapModify(tmp);
            }
        }
        return tmp;
    }

    public static void heapInsert(int[] arr, int value, int index) {
        arr[index] = value;
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (value > arr[parent]) {
                swap(arr, parent, index);
                index = parent;
            } else {
                break;
            }
        }
    }

    public static void heapModify(int[] arr) {
        int index = 0;
        int len = arr.length;

        int left = index*2 + 1;
        int right = index*2 + 2;
        int largest;
        while (left < len) {
            largest = index;
            if (arr[left] > arr[largest]) {
                largest = left;
            }
            if (right < len && arr[right] > arr[largest]) {
                largest = right;
            }
            if (largest != index) {
                swap(arr, index, largest);
            } else {
                break;
            }

            index = largest;
            left = index*2 + 1;
            right = index*2 + 2;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
