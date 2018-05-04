package com.dryseed.javademo.algorithm.entity;

public class Node {
    public Node next;
    public int value;

    @Override
    public String toString() {
        return "Node{" +
                "next=" + next +
                ", value=" + value +
                '}';
    }

    public static void print(Node head) {
        StringBuffer sb = new StringBuffer();
        while (head != null) {
            sb.append(head.value + " ");
            head = head.next;
        }
        System.out.println(sb.toString());
    }
}
