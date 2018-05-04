package com.dryseed.javademo.LeetCode.list;

import com.dryseed.javademo.algorithm.entity.Node;

/**
 * 判断两个链表是否相交
 */
public class TestLinkListIntersect {
    public static void main(String[] args) {
        int[] linkAData = new int[]{1, 2, 3, 5, 7, 8, 9};
        int[] linkBData = new int[]{4, 7, 8, 9};
        Node linkA = createLinkList(linkAData);
        Node linkB = createLinkList(linkBData);

        Node node = getLinkIntersectNode(linkA, linkB);

        Node.print(linkA);
        Node.print(linkB);
        System.out.println("node : " + node);
    }

    public static Node getLinkIntersectNode(Node linkA, Node linkB) {
        if (linkA == null || linkB == null) return null;

        int linkALen = 1;
        int linkBLen = 1;

        //获取链表A长度，以及最后一个节点值
        Node node = linkA;
        while (node.next != null) {
            node = node.next;
            linkALen++;
        }
        int lastAData = node.value;

        //获取链表B长度，以及最后一个节点值
        node = linkB;
        while (node.next != null) {
            node = node.next;
            linkBLen++;
        }
        int lastBData = node.value;

        //如果最后一个节点值相同，则两链表相交
        if (lastAData != lastBData) {
            return null;
        }

        //求相交的节点
        Node longLink = linkB;
        Node shortLink = linkA;
        if (linkALen > linkBLen) {
            longLink = linkA;
            shortLink = linkB;
        }

        for (int i = 0; i < Math.abs(linkALen - linkBLen); i++) {
            longLink = longLink.next;
        }

        while (shortLink != null) {
            //找到值相同的节点，即为相交节点
            if (longLink.value == shortLink.value) {
                return longLink;
            } else {
                longLink = longLink.next;
                shortLink = shortLink.next;
            }
        }

        return longLink;
    }


    public static Node createLinkList(int[] ints) {
        Node headNode = new Node();
        headNode.value = ints[0];
        Node lastNode = headNode;
        int size = ints.length;
        for (int i = 1; i < size; i++) {
            Node node = new Node();
            node.value = ints[i];
            lastNode.next = node;
            lastNode = node;
        }
        return headNode;
    }

}
