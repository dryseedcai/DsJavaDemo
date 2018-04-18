package com.dryseed.javademo.algorithm.link;


import com.dryseed.javademo.algorithm.entity.ListNode;

import java.util.Stack;

public class P01 {
    /**
     * 输入个链表的头结点，从尾到头反过来打印出每个结点的值
     * 使用栈的方式进行
     *
     * @param root 链表头结点
     */
    public static void printListInverselyUsingIteration(ListNode root) {
        Stack<ListNode> stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.next;
        }
        ListNode tmp;
        while (!stack.isEmpty()) {
            tmp = stack.pop();
            System.out.print(tmp.value + " ");
        }
    }

    /**
     * 输入个链表的头结点，从尾到头反过来打印出每个结点的值
     * 使用递归的方式进行
     *
     * @param root 链表头结点
     */
    public static void printListInverselyUsingRecursion(ListNode root) {
        if (root != null) {
            printListInverselyUsingRecursion(root.next);
            System.out.print(root.value + " ");
        }
    }

    public static void main(String[] args) {
        ListNode root = new ListNode();
        root.value = 1;
        root.next = new ListNode();
        root.next.value = 2;
        root.next.next = new ListNode();
        root.next.next.value = 3;
        root.next.next.next = new ListNode();
        root.next.next.next.value = 4;
        root.next.next.next.next = new ListNode();
        root.next.next.next.next.value = 5;

        printListInverselyUsingIteration(root);
        System.out.println();
        printListInverselyUsingRecursion(root);
    }
}
