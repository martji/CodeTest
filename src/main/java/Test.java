import java.util.Arrays;

/**
 * Created by Guoqing on 2016/8/1.
 */
public class Test {

    public int findKth(int[] a, int n, int K) {
        // write code here
        int i = 0;
        int j = n - 1;
        while (i < j) {
            for (; i < n; i++) {
                if (a[i] > a[0]) {
                    break;
                }
            }

            for (; j >= 0; j--) {
                if (a[j] <= a[0]) {
                    break;
                }
            }

            if (i < j) {
                int p = a[i];
                a[i] = a[j];
                a[j] = p;
            } else {
                break;
            }
        }

        if (j != 0) {
            int tmp = a[0];
            a[0] = a[j];
            a[j] = tmp;
        }
        if (j == n - K) {
            return a[j];
        } else if(j < n - K) {
            int[] b = Arrays.copyOfRange(a, j+1, n);
            return findKth(b, n - j - 1, K);
        } else {
            int[] b = Arrays.copyOfRange(a, 0, j);
            return findKth(b, j, K - (n - j));
        }
    }

    public static void main(String[] args) {
        int a[] = new int[]{1,3,5,2,2};
        System.out.print(new Test().findKth(a, 5, 1));
    }
}
