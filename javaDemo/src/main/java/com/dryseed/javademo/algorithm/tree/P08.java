package com.dryseed.javademo.algorithm.tree;

import com.dryseed.javademo.algorithm.entity.TreeNode;

public class P08 {
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

        System.out.println(getLeafNodeNum(node));

    }

    private static int getLeafNodeNum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        }
        int left = getLeafNodeNum(node.left);
        int right = getLeafNodeNum(node.right);
        return left + right;
    }
}
