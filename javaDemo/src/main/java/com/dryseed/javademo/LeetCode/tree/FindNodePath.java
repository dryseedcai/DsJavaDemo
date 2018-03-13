package com.dryseed.javademo.LeetCode.tree;

import java.util.Stack;

/**
 * Created by caiminming on 2017/10/19.
 *
 * 二叉树中，找到从根节点到某一个节点的路径
 */

public class FindNodePath {
    public static void main(String[] args) {
        /**
         *------13
         *---- /  \
         *--- 65    5
         *---/  \    \
         *--37  25   37
         *-/    /\   /
         *37   4 28 32
         */
        int[] tree = {0, 13, 65, 5, 37, 25, 0, 37, 37, 0, 4, 28, 0, 0, 32, 0};
        TreeNode node = BinaryTreeTraversal.makeBinaryTreeByArray(tree, 1);
        FindNodePath.find(new Stack(), node, 37);
    }

    private static void find(Stack<TreeNode> stack, TreeNode node, int expectedValue) {
        if(node == null || stack == null) return;
        stack.push(node);

        if(node.value == expectedValue){
            StringBuffer sb = new StringBuffer();
            for (TreeNode i : stack) {
                sb.append(i.value + " ");
            }
            System.out.println(sb.toString());
        }

        if(null != node.left){
            find(stack, node.left, expectedValue);
        }
        if(null != node.right){
            find(stack, node.right, expectedValue);
        }

        stack.pop();
    }
}
