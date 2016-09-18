package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by magq on 16/9/14.
 */
public class Problem56 {

    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> list = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) {
            return list;
        }
        Collections.sort(intervals, (o1, o2) -> {
            if (o1.start < o2.start || o1.start == o2.start && o1.end < o2.end) {
                return -1;
            } else if (o1.start == o2.start && o1.end == o2.end) {
                return 0;
            }
            return 1;
        });

        Interval base = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval tmp = intervals.get(i);
            if (tmp.start <= base.end) {
                if (tmp.end <= base.end) {
                    continue;
                } else {
                    base.end = tmp.end;
                }
            } else{
                list.add(new Interval(base.start, base.end));
                base = tmp;
            }
        }
        list.add(base);

        return list;
    }
}
