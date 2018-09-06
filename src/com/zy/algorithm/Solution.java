package com.zy.algorithm;


public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // write your code here
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;

        while(fast.next != null){
            if(n <= 0){
                slow = slow.next;
            }
            fast = fast.next;
            n--;
        }
        if(slow.next != null)
            slow.next = slow.next.next;

        return dummy.next;
    }
}
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

