import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            int[] numbers = new int[n+1];
            int[] origin = new int[n];
            for (int i = 0; i < n; i++) {
                int index = sc.nextInt();
                origin[i] = index;
                if (index != 0) {
                    numbers[index] = 1;
                }
            }

            ArrayList<Integer> arr = new ArrayList<Integer>();
            for (int i = 1; i <= n; i++) {
                if (numbers[i] == 0) {
                    arr.add(i);
                }
            }
            Collections.sort(arr);

            // 全排列
            int result = 0;
            boolean flag;
            do {
                flag = false;
                int len = arr.size();
                int index = -1;
                for (int i = len - 2; i >= 0 ; i--) {
                    if (arr.get(i) < arr.get(i+1)) {
                        index = i;
                        break;
                    }
                }

                if (index != -1) {
                    int swap = index + 1;
                    for (int i = len - 1; i > index ; i--) {
                        if (arr.get(i) > arr.get(index) && arr.get(i) < arr.get(swap)) {
                            swap = i;
                        }
                    }

                    int tmp = arr.get(index);
                    arr.set(index, arr.get(swap));
                    arr.set(swap, tmp);

                    for (int i = 1; i <= (len - 1 -index) / 2; i++) {
                        tmp = arr.get(index + i);
                        arr.set(index + i, arr.get(len - i));
                        arr.set(len - i, tmp);
                    }

                    if (check(origin, arr, k)) {
                        result ++;
                    }

                    flag = true;

                }

            } while (flag);

            System.out.println(result);

        }
        sc.close();
    }

    static boolean check(int[] number, ArrayList<Integer> arr, int k) {
        int[] tmp = new int[number.length];
        for (int i = 0, j = 0; i < number.length; i++) {
            if (number[i] == 0) {
                tmp[i] = arr.get(j++);
            } else {
                tmp[i] = number[i];
            }
        }

        int count = 0;
        for (int i = 1; i < tmp.length; i++) {
            for (int j = i+1; j < tmp.length; j++) {
                if (tmp[i] < tmp[j]) {
                    count ++;
                }
            }
        }

        return count == k;
    }

}