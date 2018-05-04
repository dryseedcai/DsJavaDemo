package com.dryseed.javademo.algorithm.tree;


import com.dryseed.javademo.algorithm.entity.TreeNode;

public class BinarySortTree {
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
        TreeNode rootNode = createBinarySortTree(array);
        BinaryTreeTraversal.levelOrderTraversal(rootNode); //19  12  22  3  21  43  6  7  11
    }

    public static TreeNode createBinarySortTree(int[] array) {
        if (array == null) return null;

        TreeNode rootNode = new TreeNode(array[0]);
        int size = array.length;
        for (int i = 1; i < size; i++) {
            addBinarySort(rootNode, array[i]);
        }
        return rootNode;
    }

    private static void addBinarySort(TreeNode rootNode, int key) {
        int val = rootNode.value;
        if (key > val) {
            if (rootNode.right == null) {
                TreeNode rightNode = new TreeNode(key);
                rootNode.right = rightNode;
            } else {
                addBinarySort(rootNode.right, key);
            }
        } else {
            if (rootNode.left == null) {
                TreeNode leftNode = new TreeNode(key);
                rootNode.left = leftNode;
            } else {
                addBinarySort(rootNode.left, key);
            }
        }
    }
}
