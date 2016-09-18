package leetcode;

/**
 * Created by Guoqing on 2016/9/12.
 */
public class Problem10 {

    public static boolean isMatch(String s, String p) {
        if (s == null) {
            return p == null;
        }
        if (p == null) {
            return s == null;
        }
        if (p.length() == 0) {
            return s.length() == 0;
        }
        if (p.length() == 1) {
            if (p.equals(s) || p.charAt(0) == '.' && s.length() == 1) {
                return true;
            }
            return false;
        }

        if (p.charAt(1) != '*') {
            if (s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
                return isMatch(s.substring(1), p.substring(1));
            }
            return false;
        } else {
            while (s.length() > 0 && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.')) {
                if (isMatch(s, p.substring(2))) {
                    return true;
                }
                s = s.substring(1);
            }
            return isMatch(s, p.substring(2));
        }
    }

    public static void main(String[] args) {
        String str1 = "aab";
        String str2 = "c*a*b";
        System.out.print(isMatch(str1, str2));
    }
}
