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

        //用递归的思想，把左右先铺平
        TreeNode left = flatternTree(node.left);
        TreeNode right = flatternTree(node.right);

        //把左指针和右指针先指向空
        node.left = null;
        node.right = null;

        if (left == null) {
            //假如左子树生成的链表为空，那么忽略它，把右子树生成的链表指向根节点的右指针
            node.right = right;
        } else {
            //如果左子树生成链表不为空，那么用while循环获取最后一个节点，并且它的右指针要指向右子树生成的链表的头节点
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
