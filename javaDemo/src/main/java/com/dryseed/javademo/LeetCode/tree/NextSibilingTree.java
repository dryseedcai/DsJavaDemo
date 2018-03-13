package com.dryseed.javademo.LeetCode.tree;

import java.util.ArrayDeque;

/**
 * 链接二叉树的Next节点
 * <p>
 * 这个题目要求大家在拥有一个二叉树节点的左右节点指针之余，还要帮它找到它的next指针指向的节点。
 * 逻辑很简单，每一个的节点的next指向同一层中的下一个节点，不过如果该节点是当前层的最后一个节点的话，不设置next，或者说next为空。
 * 其实这个题目就是典型的层序遍历，使用队列就可以轻松解决，每次poll出来一个节点，判断是不是当前层的最后一个，
 * 如果不是，把其next设置成queue中的下一个节点就ok了。至于怎么判断当前节点是哪一层呢？我们有个小技巧，使用当前queue的size做for循环
 * <p>
 * https://www.jianshu.com/p/6f179f37ad79
 */
public class NextSibilingTree {
    public static void main(String[] args) {
        /**
         *------13
         *---- /  \
         *--- 65    5
         *---/  \    \
         *--97  25   37
         *-/    /\   /
         *22   4 28 32
         */
        int[] tree = {0, 13, 65, 5, 97, 25, 0, 37, 22, 0, 4, 28, 0, 0, 32, 0};
        TreeNode node = BinaryTreeTraversal.makeBinaryTreeByArray(tree, 1);
        nextSibilingTree(node);
    }

    private static void nextSibilingTree(TreeNode node) {
        ArrayDeque<TreeNode> arrayDeque = new ArrayDeque();
        arrayDeque.add(node);
        int level = 0;

        while (!arrayDeque.isEmpty()) {
            int size = arrayDeque.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = arrayDeque.remove();

                if (treeNode.left != null) {
                    arrayDeque.add(treeNode.left);
                }

                if (treeNode.right != null) {
                    arrayDeque.add(treeNode.right);
                }

                if (i != size - 1) {
                    treeNode.next = arrayDeque.peek();
                }
            }
            level++;
        }
    }

}
