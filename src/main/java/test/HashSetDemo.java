package test;

import java.util.HashSet;

/**
 * Created by Guoqing on 2016/8/4.
 */
public class HashSetDemo {

    static class Point extends Object{
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return x + y;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj.getClass() == getClass()) {
                Point p = (Point) obj;
                return  p.x == x && p.y == y;
            }
            return false;
        }

    }

    public static void main(String[] args) {
        HashSet<Point> set = new HashSet<Point>();
        for (int i = 0; i < 10; i++) {
            set.add(new Point(1, 1));
        }
        System.out.println(set.size());
    }
}
