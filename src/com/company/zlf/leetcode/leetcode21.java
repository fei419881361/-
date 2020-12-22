package com.company.zlf.leetcode;

public class leetcode21 {
}

class Solution0 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        new Solution0().mergeTwoLists(l1, l2);
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val > l2.val) {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        } else {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
    }

    Integer getMin(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null && l2 != null) {
            int temp = l2.val;
            l2 = l2.next;
            return temp;
        }
        if (l1 != null && l2 == null) {
            int temp = l1.val;
            l1 = l1.next;
            return temp;
        }
        if (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                int temp = l2.val;
                l2 = l2.next;
                return temp;
            } else {
                int temp = l1.val;
                l1 = l1.next;
                return temp;
            }
        }
        return null;
    }
}


// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
