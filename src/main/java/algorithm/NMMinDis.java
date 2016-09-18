package algorithm;

/**
 * Created by Guoqing on 2016/9/7.
 */
public class NMMinDis {

    public static int getMinDis(int[][] arr, int n, int m) {
        int[][] helpArr = new int[n][m];
        for (int j = 0, sum = 0; j < m; j++) {
            sum += arr[0][j];
            helpArr[0][j] = sum;
        }
        for (int i = 0, sum = 0; i < n; i++) {
            sum += arr[i][0];
            helpArr[i][0] = sum;
        }
        for (int s = 1; s < n; s++) {
            for (int i = s, j = s; j < m; j++) {
                int tmp = Math.min(helpArr[i-1][j], helpArr[i][j-1]);
                helpArr[i][j] = tmp + arr[i][j];
            }
            for (int i = s, j = s; i < n; i++) {
                int tmp = Math.min(helpArr[i-1][j], helpArr[i][j-1]);
                helpArr[i][j] = tmp + arr[i][j];
            }
        }
        return helpArr[n-1][m-1];
    }

    public static void main(String[] args) {

    }
}
