package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Guoqing on 2016/8/4.
 */
public class AllSortDemo {

    public static void main(String[] args) {
        Integer[] a = new Integer[]{1, 5, 4, 3, 2};
        ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(a));
        Collections.sort(list);
        Integer[] array = list.toArray(new Integer[list.size()]);

        allSort(array);

//        allSort(array, 0, array.length - 1);
    }

    static void allSort(Integer[] array) {
        boolean flag;
        int len = array.length;
        do {
            for (int i = 0; i < len; i++) {
                System.out.print(array[i] + " ");
            }
            System.out.println();

            flag = false;
            int swap = -1;
            for (int i = len - 2; i >= 0; i--) {
                if (array[i] < array[i+1]) {
                    swap = i;
                    break;
                }
            }

            if (swap != -1) {
                int index = swap + 1;
                for (int i = swap + 1; i < len; i++) {
                    if (array[i] < array[index] && array[i] > array[swap]) {
                        index = i;
                    }
                }

                swap(array, swap, index);

                for (int i = 1; i <= (len - 1 -swap) / 2; i++) {
                    swap(array, swap + i, len - i);
                }

                flag = true;
            }

        } while (flag);
    }

    static void allSort(Integer[] array, int k, int m) {
        if (k == m) {
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i] + " ");
            }
            System.out.println();
        } else {
            for (int i = k; i <= m; i++) {
                swap(array, k ,i);
                allSort(array, k + 1, m);
                swap(array, k, i);
            }
        }
    }

    static void swap(Integer[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
