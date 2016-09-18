package algorithm;

/**
 * Created by Guoqing on 2016/9/9.
 */
public class Manacher {

    public static int getMaxSeq(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("#");
        for (int i = 0; i < str.length(); i++) {
            stringBuilder.append(str.charAt(i) + "#");
        }
        str = stringBuilder.toString();

        int len = str.length();
        int[] p = new int[len];
        int id = 0;
        int right = 0;
        int result = 0;
        for (int i = 0; i < len; i++) {
            int tmp = 1;
            if (i < right) {
                tmp = Math.min(p[2*id - i], right - i);
            }

            for (int j = tmp; i + j < len && i - j >= 0; j++) {
                if (str.charAt(i + j) == str.charAt(i - j)) {
                    tmp++;
                }
            }

            if (i + tmp > right) {
                right = i + tmp;
                id = i;
                if (tmp > result) {
                    result = tmp;
                }
            }

            if (i + tmp == len) {
                break;
            }
        }

        return result - 1;
    }

    public static void main(String[] args) {
        System.out.print(getMaxSeq("1221"));
    }
}
