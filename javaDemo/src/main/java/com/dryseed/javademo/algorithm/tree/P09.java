package com.dryseed.javademo.algorithm.tree;

import com.dryseed.javademo.algorithm.entity.TreeNode;

public class P09 {
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
        System.out.println(numsOfkLevelTreeNode(node, 4));

    }

    /**
     * 递归方式步骤：
     * 给定根节点root：
     * 如果root为空，或者层数k_Level <= 0，则为空树或者不合要求，则返回0；
     * 如果root不为空，且此时层数 k_Level==1，则此时root为第K层节点之一，则返回1；
     * 如果root不为空，且此时层数 k_Level > 1，则此时需要求proot左子树（k_Level - 1 ）层节点数和proot右子树（k_Level-1）层节点数；
     *
     * @param root
     * @param k
     * @return
     */
    private static int numsOfkLevelTreeNode(TreeNode root, int k) {
        if (root == null || k < 1) {
            return 0;
        }
        if (k == 1) {
            //此时root为第K层节点之一，则返回1
            return 1;
        }
        int numsLeft = numsOfkLevelTreeNode(root.left, k - 1);
        int numsRight = numsOfkLevelTreeNode(root.right, k - 1);
        return numsLeft + numsRight;
    }
}

