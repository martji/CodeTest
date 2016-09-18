package leetcode;

/**
 * Created by Guoqing on 2016/9/14.
 */
public class Problem44 {
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
            if (p.equals(s) || p.charAt(0) == '?' && s.length() == 1 || p.charAt(0) == '*') {
                return true;
            }
            return false;
        }

        if (p.charAt(0) != '*') {
            if (s.length() > 0 && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '?')) {
                return isMatch(s.substring(1), p.substring(1));
            }
            return false;
        } else {
            String tmp = new String(s);
            while (tmp.length() > 0) {
                if (isMatch(tmp.substring(1), p)) {
                    return true;
                }
                tmp = tmp.substring(1);
            }
            return isMatch(s, p.substring(1));
        }
    }

    public static void main(String[] args) {
        String str1 = "cd";
        String str2 = "*cd";
        System.out.print(isMatch(str1, str2));
    }
}
