package com.dryseed.javademo.algorithm.link;


import com.dryseed.javademo.algorithm.entity.ListNode;

/**
 * Title: 在O(1)时间删除链表的节点
 * Description: 给定单向链表的头指针和一个节点的指针，定义一个函数在O(1)时间删除该节点。
 * 思路：被删除节点是中间节点，则只需复制后继节点的内容并使其覆盖待删除节点，然后再删除待删除节点的后继节点即可
 * 时间复杂度(平均)：[(n-1)O(1) + 1*O(n)]/n = O(1)
 */
public class P02 {
    public static void main(String[] args) {
        ListNode root = new ListNode();
        root.value = 1;
        ListNode node2 = root.next = new ListNode();
        root.next.value = 2;
        ListNode node3 = root.next.next = new ListNode();
        root.next.next.value = 3;
        ListNode node4 = root.next.next.next = new ListNode();
        root.next.next.next.value = 4;
        ListNode node5 = root.next.next.next.next = new ListNode();
        root.next.next.next.next.value = 5;

        new P02().deleteNode(root, node4);
        ListNode tmp = root;
        while (tmp != null) {
            System.out.print(tmp.value + " ");
            tmp = tmp.next;
        }
        System.out.println();

        /*new P02().deleteNode(root, node5);
        ListNode tmp2 = root;
        while (tmp2 != null) {
            System.out.print(tmp2.value + " ");
            tmp2 = tmp2.next;
        }*/
    }

    public void deleteNode(ListNode head, ListNode target) {
        if (target.next == null) { // 被删除节点没有后继节点
            if (head == target) { // 链表只有一个节点，并且这个节点就是被删除节点:O(1)
                head = null;
                target = null;
            } else { // 被删除节点是链表的尾节点(需要遍历整个链表)：O(n)
                ListNode tmp = head;
                while (tmp.next != target) {
                    tmp = tmp.next;
                }
                tmp.next = null;
                target = null;
            }
        } else { // 被删除节点是中间节点，则只需复制后继节点的内容并使其覆盖待删除节点，然后再删除待删除节点的后继节点即可
            ListNode tmp = target.next;
            target.value = tmp.value;
            target.next = tmp.next;
            tmp.next = null;
            tmp = null;
        }
    }


}
