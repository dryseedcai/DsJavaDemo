package com.dryseed.javademo.LeetCode.tree;

/**
 * 先序、中序、后序遍历
 */
public class OrderTree {

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

        //先序遍历
        preOrderTree(node); //13 65 97 22 25 4 28 5 37 32
        System.out.println();

        //中序遍历
        centerOrderTree(node); //22 97 65 4 25 28 13 5 32 37
        System.out.println();

        //后序遍历
        postOrderTree(node); //22 97 4 28 25 65 32 37 5 13
        System.out.println();
    }

    /**
     * 先序遍历
     *
     * @param node
     */
    private static void preOrderTree(TreeNode node) {
        //根-左-右
        if (null == node) return;
        System.out.print(node.value + " ");
        preOrderTree(node.left);
        preOrderTree(node.right);
    }

    /**
     * 中序遍历
     *
     * @param node
     */
    private static void centerOrderTree(TreeNode node) {
        //左-根-右
        if (null == node) return;
        centerOrderTree(node.left);
        System.out.print(node.value + " ");
        centerOrderTree(node.right);
    }

    /**
     * 后序遍历
     *
     * @param node
     */
    private static void postOrderTree(TreeNode node) {
        //左-右-根
        if (null == node) return;
        postOrderTree(node.left);
        postOrderTree(node.right);
        System.out.print(node.value + " ");
    }
}
