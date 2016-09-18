package algorithm;

import java.util.ArrayList;

/**
 * Created by Guoqing on 2016/9/7.
 */
public class LuckyNumber {

    public static int getMinLuckyNum(int price, ArrayList<Integer> unLucky) {
        ArrayList<Integer> luckyNum = new ArrayList<Integer>();
        for (int i = 1; i < 10; i++) {
            if (!unLucky.contains(i)) {
                luckyNum.add(i);
            }
        }

        int maxLuckyNum = luckyNum.get(luckyNum.size() - 1);
        String priceStr = String.valueOf(price);
        String out = "";
        boolean flag = false;
        for (int i = priceStr.length() - 1; i >= 0; i--) {
            int tmp = priceStr.charAt(i) - '0';
            if (!luckyNum.contains(tmp)) {
                if (tmp < maxLuckyNum) {
                    for (int j = 0; j < luckyNum.size(); j++) {
                        if (luckyNum.get(j) > tmp) {
                            tmp = luckyNum.get(j);
                            if (flag) {
                                out = "";
                                for (int k = i; k < priceStr.length(); k++) {
                                    out += luckyNum.get(0);
                                }
                                flag = false;
                            }
                            break;
                        }
                    }
                } else {
                    flag = true;
                }
            }
            out = tmp + out;
        }

        int result = Integer.parseInt(out);
        if (flag || result < price) {
            out = "";
            for (int k = 0; k <= priceStr.length(); k++) {
                out += luckyNum.get(0);
            }
            result = Integer.parseInt(out);
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(1);
        arr.add(3);
        arr.add(5);
        arr.add(7);
        arr.add(9);

        System.out.print(getMinLuckyNum(9000, arr));
    }
}
