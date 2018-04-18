package com.dryseed.javademo.LeetCode.tree;

/**
 * 找出数组中k个最小数并生成一个新的数组。
 */
public class TopK {
    public static void main(String[] args) {
        int[] a = {3, 2, 9, 2, 6, 7, 1, 5};
        int[] b = topK(a, 5);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            sb.append(b[i] + " ");
        }
        System.out.println(sb);
    }

    private static int[] topK(int[] a, int k) {
        if (k >= a.length) return new int[0];

        //1. 取a个数，构建最大堆
        int[] topK = new int[k];
        for (int i = 0; i < k; i++) {
            topK[i] = a[i];
        }
        buildMaxHeap(topK);

        //2. 对剩余内容，依次构建最大堆
        int size = a.length;
        for (int i = k; i < size; i++) {
            int val = a[i];
            if (val < topK[0]) {
                topK[0] = val;
                maxHeap(topK, 0);
            }
        }
        return topK;
    }

    private static void buildMaxHeap(int[] a) {
        int index = a.length / 2;
        for (int i = index; i >= 0; i--) {
            maxHeap(a, i);
        }
    }

    private static void maxHeap(int[] a, int i) {
        int left = i * 2 + 1;
        int right = i * 2 + 2;

        int smallest = i;
        if (left < a.length && a[left] > a[smallest]) {
            smallest = left;
        }
        if (right < a.length && a[right] > a[smallest]) {
            smallest = right;
        }
        if (i != smallest) {
            swap(a, smallest, i);
            maxHeap(a, smallest);
        }
    }

    private static void swap(int[] a, int larget, int i) {
        int temp = a[larget];
        a[larget] = a[i];
        a[i] = temp;
    }

}
