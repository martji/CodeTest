package algorithm;

import java.util.Scanner;

/**
 * Created by Guoqing on 2016/9/7.
 */
public class MergeKSortedList {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null;
        ListNode[] heap = new ListNode[lists.length];
        for (int i = 0; i < lists.length; i++) {
            heapInsert(heap, i, lists[i]);
        }

        int len = lists.length;
        ListNode p, r = null;
        while (len > 0) {
            p = heap[0];
            if (r == null) {
                head = p;
                r = head;
            } else {
                r.next = p;
                r = p;
            }

            if (p.next == null) {
                len --;
                heapModify(heap, len, heap[len]);
            } else {
                heapModify(heap, len, p.next);
            }
        }
        return head;
    }

    public void heapInsert(ListNode[] arr, int index, ListNode node) {
        arr[index] = node;
        int parent;
        while (index > 0) {
            parent = (index - 1)  / 2;
            if (arr[parent].val > arr[index].val) {
                swap(arr, parent, index);
                index = parent;
            } else {
                break;
            }
        }
    }

    public void heapModify(ListNode[] arr, int len, ListNode node) {
        arr[0] = node;
        int index = 0;
        int left = 2*index + 1;
        int right = 2*index + 2;
        int minIndex;
        while (left < len) {
            minIndex = index;
            if (arr[left].val < arr[minIndex].val) {
                minIndex = left;
            }
            if (right < len && arr[right].val < arr[minIndex].val) {
                minIndex = right;
            }
            if (minIndex != index) {
                swap(arr, minIndex, index);
                index = minIndex;
                left = 2*index + 1;
                right = 2*index + 2;
            } else {
                break;
            }
        }
    }

    public void swap(ListNode[] arr, int i, int j) {
        ListNode tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ListNode[] listNodes = new ListNode[n];
        for (int i = 0; i < n; i++) {
            ListNode head = null;
            ListNode p = null;
            for (int j = 0; j < m; j++) {
                int tmp = sc.nextInt();
                ListNode node = new ListNode(tmp);
                if (head == null) {
                    head = node;
                    listNodes[i] = head;
                    p = head;
                } else {
                    p.next = node;
                    p = p.next;
                }
            }
        }

        MergeKSortedList mergeKSortedList = new MergeKSortedList();
        ListNode p = mergeKSortedList.mergeKLists(listNodes);
        while(p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
