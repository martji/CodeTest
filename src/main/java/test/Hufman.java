package test;

import java.util.*;

/**
 * Created by Guoqing on 2016/9/9.
 */
public class Hufman {

    public static int getResult(String str) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }

        List<Integer> list = new ArrayList<Integer>(map.values());
        Collections.sort(list);
        int result = 0;
        while (list.size() > 0) {
            int tmp = list.get(0) + list.get(1);
            list.remove(1);
            list.remove(0);
            result += tmp;

            if (list.size() > 0) {
                list.add(tmp);
                Collections.sort(list);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            System.out.println(getResult(input));
        }
        scanner.close();
    }
}
