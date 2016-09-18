package huawei;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Guoqing on 2016/8/17.
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int min = 3300;
            int max = 4200;
            int len = 10;
            ArrayList<Integer> U = new ArrayList<Integer>();
            for (int i = 0; i < len; i++) {
                int tmp = sc.nextInt();
                if (tmp >= min && tmp <= max) {
                    U.add(tmp);
                }
            }

            int group = U.size() / 5;
            int[] out = new int[group + 1];
            for (int i = 0; i < U.size(); i++) {
                out[i/5] += U.get(i);
            }

            System.out.print(group);
            for (int i = 0; i < group; i++) {
                System.out.print(" " + out[i]/5);
            }
            System.out.println();
        }
        sc.close();
    }
}

//public class Main {
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        while (sc.hasNext()) {
//            String str = sc.nextLine();
//
//            int n1= 0;
//            int n2 = 0;
//            int n3 = 0;
//            String out = "";
//
//            StringBuffer stringBuffer = new StringBuffer();
//            HashSet<Character> set = new HashSet<Character>();
//
//            if (str != null && str.length() > 0) {
//                for (int i = 0; i < str.length(); i++) {
//                    char tmp = str.charAt(i);
//                    if (tmp == 'a' || tmp == 'A' ||
//                            tmp == 'e' || tmp == 'E' ||
//                            tmp == 'i' || tmp == 'I' ||
//                            tmp == 'o' || tmp == 'O' ||
//                            tmp == 'u' || tmp == 'U') {
//                        set.add(tmp);
//                        stringBuffer.append(tmp);
//                    }
//                }
//
//                out = stringBuffer.toString();
//                n1 = set.size();
//                n2 = out.length();
//                n3 = str.length() - n2;
//            }
//            System.out.println(n1 + " " + n2 + " " + n3);
//            System.out.println(out);
//        }
//
//        sc.close();
//    }
//}

//public class Main {
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()) {
//            String tmp = sc.nextLine();
//            char[][] map = new char[5][5];
//            for (int i = 0; i < 5; i++) {
//                for (int j = 0; j < 5; j++) {
//                    map[i][j] = tmp.charAt(i*5 + j);
//                }
//            }
//
//            boolean flag;
//            for (int i = 0; i < 5; i++) {
//                for (int j = 0; j < 5; j++) {
//                    int right = j + 1;
//                    if (right < 5) {
//                        swap(map, i, j, i, right);
//                        flag = check(map);
//                        if (flag) {
//                            System.out.println("YES " + (i*5 + j + 1));
//                            return;
//                        } else {
//                            swap(map, i, j, i, right);
//                        }
//                    }
//
//                    int bottom = i + 1;
//                    if (bottom < 5) {
//                        swap(map, i, j, bottom, j);
//                        flag = check(map);
//                        if (flag) {
//                            System.out.println("YES " + (i*5 + j + 1));
//                            return;
//                        } else {
//                            swap(map, i, j, bottom, j);
//                        }
//                    }
//                }
//            }
//
//            System.out.println("NO");
//        }
//        sc.close();
//    }
//
//    static void swap(char[][] a, int i1,int j1,int i2,int j2) {
//        char t = a[i1][j1];
//        a[i1][j1] = a[i2][j2];
//        a[i2][j2] = t;
//    }
//
//    static boolean check(char[][] a) {
//        for(int i = 0; i < 5; i++) {
//            for (int j = 0; j < 3; j++) {
//                if (a[i][j] == a[i][j + 1] && a[i][j] == a[i][j + 2]) {
//                    return true;
//                }
//            }
//        }
//
//        for(int j=0;j<5;j++) {
//            for (int i = 0; i < 3; i++) {
//                if (a[i][j] == a[i + 1][j] && a[i][j] == a[i + 2][j])
//                    return true;
//            }
//        }
//        return false;
//    }
//}
