package algorithm;

/**
 * Created by Guoqing on 2016/9/9.
 */
public class KMP {

    public static int getIndex(String str1, String str2) {
        int result = -1;
        int[] helpArr = new int[str2.length()];
        getHelpArr(str2, helpArr);
        int i , j;
        for (i = 0, j = 0; i < str1.length() && j < str2.length(); i++) {
            int tmp = j;
            while (tmp >= 0) {
                if (str1.charAt(i) == str2.charAt(tmp)) {
                    break;
                } else {
                    tmp = helpArr[tmp];
                }
            }

            if (tmp >= 0) {
                j = tmp + 1;
            } else {
                j = 0;
            }
        }

        if (j == str2.length()) {
            result = i - j;
        }

        return result;
    }

    public static void getHelpArr(String str, int[] arr) {
        arr[0] = -1;
        arr[1] = 0;
        if (str.length() <= 2) {
            return;
        }
        for (int i = 2; i < str.length(); i++) {
            int tmp = arr[i-1];
            while (tmp >= 0) {
                if (str.charAt(i) == str.charAt(tmp)) {
                    arr[i] = tmp + 1;
                    break;
                } else {
                    tmp = arr[tmp];
                }
            }
        }
    }

    public static void main(String[] args) {
        String str1 = "abc1234d";
        String str2 = "12345";
        System.out.print(getIndex(str1, str2));
    }
}
