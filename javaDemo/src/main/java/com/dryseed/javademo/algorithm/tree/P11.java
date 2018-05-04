package com.dryseed.javademo.algorithm.tree;

import com.dryseed.javademo.algorithm.entity.TreeNode;

public class P11 {
    public static void main(String[] args) {
        int[] array = {19, 12, 3, 22, 6, 7, 21, 11, 43};

        /*
                    19
                   /  \
                  12   22
                 /    /  \
                3    21  43
                 \
                  6
                   \
                    7
                     \
                      11
         */
        TreeNode rootNode = BinarySortTree.createBinarySortTree(array);

        insertNode(rootNode, 13);
        insertNode2(rootNode, 13);
        BinaryTreeTraversal.levelOrderTraversal(rootNode); //19  12  22  3  13  21  43  6  7  11
    }

    /**
     * 递归
     *
     * @param rootNode
     * @param val
     * @return
     */
    private static TreeNode insertNode2(TreeNode rootNode, int val) {
        if (rootNode == null) {
            rootNode = new TreeNode(val);
            return rootNode;
        }
        if (rootNode.value < val) {
            rootNode.right = insertNode2(rootNode.right, val);
        } else if (rootNode.value > val) {
            rootNode.left = insertNode2(rootNode.left, val);
        } else {
            throw new RuntimeException("插入节点值已经存在");
        }
        return rootNode;
    }

    /**
     * 非递归
     *
     * @param rootNode
     * @param val
     */
    private static void insertNode(TreeNode rootNode, int val) {
        TreeNode insetNode = new TreeNode(val);
        TreeNode tmp = rootNode;
        while (tmp != null) {
            if (tmp.value > val) {
                if (tmp.left != null) {
                    tmp = tmp.left;
                } else {
                    tmp.left = insetNode;
                    return;
                }
            } else if (tmp.value < val) {
                if (tmp.right != null) {
                    tmp = tmp.right;
                } else {
                    tmp.right = insetNode;
                    return;
                }
            } else {
                throw new RuntimeException("插入节点值已经存在");
            }
        }
    }
}
