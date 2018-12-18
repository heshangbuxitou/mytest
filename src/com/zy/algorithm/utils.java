package com.zy.algorithm;

public class utils {
    public static ListNode getListNode(int[] nums) {
        ListNode head = new ListNode(1);
        ListNode end = head;
        for (int i : nums) {
            ListNode node = new ListNode(i);
            end.next = node;
            end = end.next;
        }
        return head.next;
    }

    public static void output(ListNode head) {
        int count = 1;
        while (head != null) {
            System.out.println("我是节点[" + count++ + "],值为[" + head.val + "]");
            head = head.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
        next = null;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
