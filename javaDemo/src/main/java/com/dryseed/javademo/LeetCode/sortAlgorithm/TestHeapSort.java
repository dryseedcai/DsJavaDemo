package com.dryseed.javademo.LeetCode.sortAlgorithm;


/**
 * Created by caiminming on 2017/10/18.
 * <p>
 * 堆排序是一种树形选择排序方法，它的特点是：在排序的过程中，将array[0，...，n-1]看成是一颗完全二叉树的顺序存储结构，
 * 利用完全二叉树中双亲节点和孩子结点之间的内在关系，在当前无序区中选择关键字最大（最小）的元素。
 * <p>
 * 1. 若array[0，...，n-1]表示一颗完全二叉树的顺序存储模式，则双亲节点指针和孩子结点指针之间的内在关系如下：
 * 　　任意一节点指针 i：父节点：i==0 ? null : (i-1)/2
 * 　　　　　　　　　　  左孩子：2*i + 1
 * 　　　　　　　　　　  右孩子：2*i + 2
 * <p>
 * 2. 堆的定义：n个关键字序列array[0，...，n-1]，当且仅当满足下列要求：(0 <= i <= (n-1)/2)
 * 　　　　　　① array[i] <= array[2*i + 1] 且 array[i] <= array[2*i + 2]； 称为小根堆；
 * 　　　　　　② array[i] >= array[2*i + 1] 且 array[i] >= array[2*i + 2]； 称为大根堆；
 * <p>
 * 3. 建立大根堆：
 * 　　n个节点的完全二叉树array[0，...，n-1]，最后一个节点n-1是第(n-1-1)/2个节点的孩子。对第(n-1-1)/2个节点为根的子树调整，使该子树称为堆。
 * 　　对于大根堆，调整方法为：若【根节点的关键字】小于【左右子女中关键字较大者】，则交换。
 * 　　之后向前依次对各节点（(n-2)/2 - 1）~ 0为根的子树进行调整，看该节点值是否大于其左右子节点的值，若不是，将左右子节点中较大值与之交换，交换后可能会破坏下一级堆，于是继续采用上述方法构建下一级的堆，直到以该节点为根的子树构成堆为止。
 * 　　反复利用上述调整堆的方法建堆，直到根节点。
 * <p>
 * 4.堆排序：（大根堆）
 * 　　①将存放在array[0，...，n-1]中的n个元素建成初始堆；
 * 　　②将堆顶元素与堆底元素进行交换，则序列的最大值即已放到正确的位置；
 * 　　③但此时堆被破坏，将堆顶元素向下调整使其继续保持大根堆的性质，再重复第②③步，直到堆中仅剩下一个元素为止。
 * <p>
 * 堆排序算法的性能分析：
 * 　　空间复杂度:o(1)；( 因为堆排序是就地排序，空间复杂度为常数：O(1))
 * 　　时间复杂度:建堆：o(n)，每次调整o(log n)，故最好、最坏、平均情况下：o(n*logn);
 * 　　稳定性：不稳定
 * <p>
 * <p>
 * 最差时间分析	平均时间复杂度	稳定度	空间复杂度
 * 冒泡排序	O(n2)	O(n2)	         稳定	O(1)
 * 快速排序	O(n2)	O(n*log2n)	    不稳定	O(log2n)~O(n)
 * 选择排序	O(n2)	O(n2)	         稳定	O(1)
 * 二叉树排序	O(n2)	O(n*log2n)	    不一定	O(n)
 * 插入排序    O(n2)	O(n2)	         稳定	O(1)
 * 堆排序	O(n*log2n)	O(n*log2n)	    不稳定	O(1)
 * 希尔排序	O	    O	            不稳定	O(1)
 * 归并排序  O(n*log2n)	O(n*log2n)	  稳定	O(n+logn)
 */

public class TestHeapSort {
    public static void main(String[] args) {
        int[] a = {3, 2, 9, 2, 6, 7, 1, 5};
        sort(a);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < a.length; i++) {
            sb.append(a[i] + " ");
        }
        System.out.println(sb);
    }

    private static void sort(int[] a) {
        if (null == a || a.length < 2) return;

        buildMaxHeap(a);

        for (int i = a.length - 1; i >= 1; i--) {
            swap(a, 0, i);
            maxHeap(a, i, 0);
        }
    }

    private static void maxHeap(int[] a, int size, int index) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        int largest = index;
        if (left < size && a[left] > a[largest]) {
            largest = left;
        }
        if (right < size && a[right] > a[largest]) {
            largest = right;
        }
        if (largest != index) {
            swap(a, index, largest);
            maxHeap(a, size, largest);
        }
    }

    private static void buildMaxHeap(int[] a) {
        int half = a.length / 2;
        for (int i = half; i >= 0; i--) {
            maxHeap(a, a.length, i);
        }
    }

    private static void swap(int[] data, int a, int b) {
        int temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }

}
