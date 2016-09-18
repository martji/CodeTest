package algorithm;

import java.util.Scanner;

/**
 * Created by Guoqing on 2016/9/8.
 */
public class NumOfIsland {

    public static int getNumOfIsland(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;

        int max = 0;
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1) {
                    result ++;
                    int[] tmp = new int[1];
                    bfs(arr, i, j, tmp);
                    if (tmp[0] > max) {
                        max = tmp[0];
                    }
                } else {
                    continue;
                }
            }
        }

        System.out.println(max);
        return result;
    }

    public static void bfs(int[][] arr, int i, int j, int[] tmp) {
        int n = arr.length;
        int m = arr[0].length;
        if (i < 0 || i >= n || j < 0 || j >= m || arr[i][j] != 1) {
            return;
        }
        tmp[0] ++;
        arr[i][j] = 2;
        bfs(arr, i-1, j, tmp);
        bfs(arr, i, j+1, tmp);
        bfs(arr, i+1, j, tmp);
        bfs(arr, i, j-1, tmp);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.print(getNumOfIsland(arr));
    }
}
