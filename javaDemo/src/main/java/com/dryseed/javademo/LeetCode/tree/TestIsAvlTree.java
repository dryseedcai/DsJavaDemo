package com.dryseed.javademo.LeetCode.tree;

/**
 * 判断该树是不是平衡二叉树
 * 平衡二叉树：如果某二叉树中任意结点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 * 思路：
 * 我们用后序遍历的方式遍历二叉树的每一个结点，在遍历到一个结点之前我们已经遍历了它的左右子树。
 * 只要在遍历每个结点的时候记录它的深度（某一结点的深度等于它到叶节点的路径的长度），我们就可以一边遍历一边判断每个结点是不是平衡的
 */
public class TestIsAvlTree {
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

        boolean isBalanced = isBalanced(node, new Depth(0));
        System.out.println("isBalanced : " + isBalanced);
    }

    private static boolean isBalanced(TreeNode node, Depth depth) {
        if (node == null) {
            depth.depth = 0;
            return true;
        }

        Depth leftDepth = new Depth(0);
        Depth rightDepth = new Depth(0);
        boolean isLeftBalanced = isBalanced(node.left, leftDepth);
        boolean isRightBalanced = isBalanced(node.right, rightDepth);
        if (isLeftBalanced && isRightBalanced) {
            int diff = Math.abs(leftDepth.depth - rightDepth.depth);
            if (diff <= 1) {
                depth.depth = 1 + Math.max(leftDepth.depth, rightDepth.depth);
                return true;
            }
        }
        return false;
    }


}

class Depth {
    int depth = 0;

    public Depth(int depth) {
        this.depth = depth;
    }
}
