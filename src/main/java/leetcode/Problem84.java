package leetcode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by magq on 16/9/14.
 */
public class Problem84 {

    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        } else {
            int area = 0;
            for (int i = 0; i < heights.length; i++) {
                for (int k = i + 1; k < heights.length; k++) {
                    if (heights[k] < heights[k - 1]) {
                        i = k - 1;
                        break;
                    } else {
                        i = k;
                    }
                }
                int lowest = heights[i];
                for (int j = i; j >= 0; j--) {
                    if (heights[j] < lowest) {
                        lowest = heights[j];
                    }
                    int currArea = (i - j + 1) * lowest;
                    if (currArea > area) {
                        area = currArea;
                    }
                }
            }
            return area;
        }
    }

    public static int largestRectangleArea1(int[] heights) {
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

    public static void main(String[] args) {
        int[] arr = new int[]{2,0,2};
        System.out.print(largestRectangleArea1(arr));
    }
}
