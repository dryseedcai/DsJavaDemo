package com.dryseed.javademo.algorithm.tree;

import com.dryseed.javademo.algorithm.entity.TreeNode;

public class BinaryTreeMinDepth {
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

        System.out.println(getTreeMinDepth(node));

    }

    private static int getTreeMinDepth(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }

        return getTreeMinDepthInner(treeNode);
    }

    private static int getTreeMinDepthInner(TreeNode treeNode) {
        if (treeNode == null) {
            return Integer.MAX_VALUE;
        }
        if (treeNode.left == null || treeNode.right == null) {
            return 1;
        }

        int left = getTreeMinDepthInner(treeNode.left);
        int right = getTreeMinDepthInner(treeNode.right);
        return Math.min(left, right) + 1;
    }
}
