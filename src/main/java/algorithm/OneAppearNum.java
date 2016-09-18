package algorithm;

/**
 * Created by Guoqing on 2016/9/7.
 */
public class OneAppearNum {

    public static int getOneAppearNum(int n) {
        int result = 0;
        int base = 1;

        int high;
        int current;
        int low;

        while (n / base != 0) {
            high = (n / base) / 10;
            current = (n / base) % 10;
            low = n % base;

            if (current == 0) {
                result += high * base;
            } else if (current == 1) {
                result += high * base + low + 1;
            } else {
                result += (high + 1) * base;
            }
            base *= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.print(getOneAppearNum(123));
    }
}
