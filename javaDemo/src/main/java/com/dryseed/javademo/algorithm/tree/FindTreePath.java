package com.dryseed.javademo.algorithm.tree;

import com.dryseed.javademo.algorithm.entity.TreeNode;

import java.util.Stack;

/**
 * Created by caiminming on 2017/10/19.
 * <p>
 * 题目：输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶结点所经过的所有的结点形成一条路径。
 */

public class FindTreePath {
    public static void main(String[] args) {
        /**
         *------13
         *---- /  \
         *--- 65    5
         *---/  \    \
         *--97  25   37
         *-/    /\   / \
         *22   4 28 32 52
         */
        int[] tree = {0, 13, 65, 5, 97, 25, 0, 37, 22, 0, 4, 28, 0, 0, 32, 52};
        TreeNode node = BinaryTreeTraversal.makeBinaryTreeByArray(tree, 1);
        FindTreePath.find(new Stack(), node, 107, 0); //13 65 25 4  & 13 5 37 52
    }

    private static void find(Stack<TreeNode> stack, TreeNode node, int expectedSum, int currentSum) {
        if (null == node) return;
        //统计路径节点值的和
        currentSum += node.value;

        //前序遍历
        stack.push(node);

        if (node.left == null && node.right == null) {
            //叶子节点
            if (currentSum == expectedSum) {
                StringBuffer sb = new StringBuffer();
                for (TreeNode i : stack) {
                    sb.append(i.value + " ");
                }
                System.out.println(sb.toString());
            }
        } else {
            if (null != node.left) {
                find(stack, node.left, expectedSum, currentSum);
            }
            if (null != node.right) {
                find(stack, node.right, expectedSum, currentSum);
            }
        }

        //当前节点访问结束后，递归函数将自动回到它的父节点。
        //因此我们在函数退出之前要在路径上删除当前节点并减去当前节点的值
        stack.pop();
        currentSum -= node.value;
    }
}
