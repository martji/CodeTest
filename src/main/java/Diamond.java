/**
 * Created by Guoqing on 2016/8/1.
 */
public class Diamond {

    public int cmp(int g1, int g2, int[][] records, int n) {
        // write code here
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int tmp = Math.max(records[i][0], records[i][1]);
            if (tmp > max) {
                max = tmp;
            }
        }

        int arrs[][] = new int[max+1][max+1];
        for (int i = 0; i < n; i++) {
            arrs[records[i][0]][records[i][1]] = 1;
        }

        for (int k = 0; k <= max; k++) {
            for (int i = 0; i <= max; i++) {
                for (int j = 0; j <= max; j++) {
                    if (arrs[i][k] == 1 && arrs[k][j] == 1) {
                        arrs[i][j] = 1;
                    }
                }
            }
        }

        if (arrs[g1][g2] > 0) {
            return 1;
        } else if (arrs[g2][g1] > 0) {
            return -1;
        }
        return 0;
    }
}
