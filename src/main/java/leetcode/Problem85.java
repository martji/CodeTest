package leetcode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by magq on 16/9/15.
 */
public class Problem85 {

    public int maximalRectangle(char[][] matrix) {
        if (matrix == null && matrix.length == 0) {
            return 0;
        } else if (matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] arr = new int[n][m];

        for (int j = 0; j < m; j++) {
            for (int i = n - 1; i >= 0; i--) {
                if (i == n -1) {
                    arr[i][j] = matrix[i][j] == '1' ? 1 : 0;
                } else {
                    if (matrix[i][j] == '1') {
                        arr[i][j] = arr[i+1][j] + 1;
                    }
                }
            }
        }

        int area = 0;
        for (int i = 0; i < n; i++) {
            area = Math.max(area, largestRectangleArea1(arr[i]));
        }
        return area;
    }

    public int largestRectangleArea1(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        } else {
            int area = 0;
            Stack<Integer> stack = new Stack<>();
            ArrayList<Integer> arr = new ArrayList<>();
            for (int i = 0; i < heights.length; i++) {
                arr.add(heights[i]);
            }
            arr.add(0);

            for (int i = 0; i < arr.size(); i++) {
                if (stack.isEmpty() || arr.get(i) >= arr.get(stack.peek())) {
                    stack.push(i);
                } else {
                    int tmp = stack.pop();
                    int len = stack.isEmpty() ? i : i - stack.peek() - 1;
                    area = Math.max(area, arr.get(tmp) * len);
                    i--;
                }
            }

            return area;
        }
    }
}
