package com.dryseed.javademo.algorithm.tree;

import com.dryseed.javademo.algorithm.entity.TreeNode;

public class P10 {
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

        boolean isSame = isSameTreeNode(node, node);
        System.out.println("isSame : " + isSame); //true
    }

    private static boolean isSameTreeNode(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        if (t1.value != t2.value) {
            return false;
        }

        boolean isLeftSame = isSameTreeNode(t1.left, t2.left);
        boolean isRightSame = isSameTreeNode(t1.right, t2.right);
        if (isLeftSame && isRightSame) {
            return true;
        } else {
            return false;
        }
    }
}
