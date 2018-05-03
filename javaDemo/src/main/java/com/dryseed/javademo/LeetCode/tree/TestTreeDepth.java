package com.dryseed.javademo.LeetCode.tree;

import com.dryseed.javademo.algorithm.entity.TreeNode;
import com.dryseed.javademo.algorithm.tree.BinaryTreeTraversal;

public class TestTreeDepth {
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

        System.out.println(getTreeDepth(node));
    }

    private static int getTreeDepth(TreeNode treeNode) {
        if (treeNode == null) return 0;

        int leftDepth = getTreeDepth(treeNode.left);
        int rightDepth = getTreeDepth(treeNode.right);

        return Math.max(leftDepth + 1, rightDepth + 1);
    }
}
