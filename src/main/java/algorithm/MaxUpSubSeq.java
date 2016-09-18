package algorithm;

/**
 * Created by Guoqing on 2016/9/7.
 */
public class MaxUpSubSeq {

    public static int getMaxUpSubSeq(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int len = str.length();
        int result = 1;
        int[] helpArr = new int[len];
        helpArr[0] = 1;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (str.charAt(j) < str.charAt(i) && helpArr[j] + 1 > result) {
                    result = helpArr[j] + 1;
                    helpArr[i] = result;
                }
            }
        }
        return result;
    }

    public static int getMaxCommonSubSeq(String str1, String str2) {
        if (str1 == null || str1.length() == 0 || str2 == null || str2.length() == 0) {
            return 0;
        }
        int n = str1.length();
        int m = str2.length();
        int[][] helpArr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int top = 0;
                int left = 0;
                if (i - 1 >= 0) {
                    top = helpArr[i-1][j];
                }
                if (j - 1 >= 0) {
                    left = helpArr[i][j-1];
                }

                if (str1.charAt(i) == str2.charAt(j)) {
                    if (i - 1 >= 0 && j - 1 >= 0) {
                        helpArr[i][j] = helpArr[i - 1][j - 1] + 1;
                    } else {
                        helpArr[i][j] = 1;
                    }
                } else {
                    helpArr[i][j] = Math.max(top, left);
                }
            }
        }
        return helpArr[n-1][m-1];
    }

    public static void main(String[] args) {
        String str = "122346278";
        String str2 = "1234678";
        System.out.print(getMaxUpSubSeq(str));
        System.out.print(getMaxCommonSubSeq(str, str2));
    }
}
