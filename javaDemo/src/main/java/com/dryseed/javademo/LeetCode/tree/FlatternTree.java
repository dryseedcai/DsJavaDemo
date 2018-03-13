package com.dryseed.javademo.LeetCode.tree;

/**
 * 把二叉树铺平
 * <p>
 * 从图中我们可以看出来，把二叉树铺平的这个过程，是先把左子树铺平，链接到根节点的右节点上面，再把右子树铺平,链接到已经铺平的左子树的最后一个节点上。
 * 最后返回根节点。那么我们从一个宏观的角度来说，需要做的就是先把左右子树铺平。
 * <p>
 * https://www.jianshu.com/p/6f179f37ad79
 */
public class FlatternTree {
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
        flatternTree(node);
        BinaryTreeTraversal.levelOrderTraversal(node); //13  65  97  22  25  4  28  5  37  32
    }

    private static TreeNode flatternTree(TreeNode node) {
        if (node == null) return null;

        TreeNode left = flatternTree(node.left);
        TreeNode right = flatternTree(node.right);

        node.left = null;
        node.right = null;

        if (left == null) {
            node.right = right;
        } else {
            TreeNode lastNode = left;
            while (lastNode != null && lastNode.right != null) {
                lastNode = lastNode.right;
            }
            node.right = left;
            lastNode.right = right;
        }

        return node;
    }
}
