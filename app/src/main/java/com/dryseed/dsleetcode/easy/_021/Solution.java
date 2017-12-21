package com.dryseed.dsleetcode.easy._021;

import com.dryseed.dsleetcode.structure.ListNode;

/**
 * Created by caiminming on 2017/12/21.
 */

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode tmp = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tmp.next = l1;
                l1 = l1.next;
            } else {
                tmp.next = l2;
                l2 = l2.next;
            }
            tmp = tmp.next;
        }
        tmp.next = l1 == null ? l2 : l1;
        return head.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode0 = ListNode.createTestData("[1,3,5,7,9]");
        ListNode listNode1 = ListNode.createTestData("[2,4,6,8,10]");
        ListNode.print(listNode0);
        ListNode.print(listNode1);
        ListNode.print(solution.mergeTwoLists(listNode0, listNode1));
    }
}
