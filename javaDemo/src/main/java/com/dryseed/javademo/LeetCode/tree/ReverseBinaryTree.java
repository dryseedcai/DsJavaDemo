package com.dryseed.javademo.LeetCode.tree;

/**
 * 反转二叉树
 * <p>
 * 我们使用分治的思维，假如说我们有个函数，专门翻转二叉树的。
 * 假如我们把B子树翻转好，再把C子树翻转好，那么我们要做的岂不就是简单的把A节点的左赋给C(原来是B)，再把A节点的右赋给B(原来是C)。
 * <p>
 * https://www.jianshu.com/p/6f179f37ad79
 */
public class ReverseBinaryTree {
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
        reverseBinaryTree(node);
        BinaryTreeTraversal.levelOrderTraversal(node); //13  5  65  37  25  97  32  28  4  22
    }

    private static TreeNode reverseBinaryTree(TreeNode node) {
        if (node == null) return null;

        //把左子树翻转
        TreeNode left = reverseBinaryTree(node.left);
        //把右子树翻转
        TreeNode right = reverseBinaryTree(node.right);

        //把左右子树分别赋值给root节点，但是是翻转过来的顺序
        node.left = right;
        node.right = left;

        return node;
    }
}
