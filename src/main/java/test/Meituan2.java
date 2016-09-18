package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by Guoqing on 2016/9/9.
 */
public class Meituan2 {

    public static int compute(int n) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (int i = 0; i <= n; i++) {
            arr.add(i);
        }
        while (arr.size() > 1) {
            for (int i = arr.size() - 1; i >= 0; i--) {
                if (i%2 == 0) {
                    arr.remove(i);
                }
            }
        }
        return arr.get(0);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int arr[] = new int[n];
            for(int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            System.out.println(maxProfit(arr, n));
        }
        scanner.close();
    }

    public static int maxProfit(int[] prices, int n) {
        // write code here
        int[] preArr = new int[n];
        int[] postArr = new int[n];

        int min_buy = prices[0];
        for (int i = 1; i < n; i++) {
            min_buy = Math.min(min_buy, prices[i]);
            preArr[i] = Math.max(preArr[i-1], prices[i] - min_buy);
        }

        int max_sale = prices[n-1];
        for (int i = n -2; i >= 0; i--) {
            max_sale = Math.max(prices[i], max_sale);
            postArr[i] = Math.max(postArr[i+1], max_sale - prices[i]);
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            if (preArr[i] + postArr[i] > result) {
                result = preArr[i] + postArr[i];
            }
        }

        return result;
    }
}
