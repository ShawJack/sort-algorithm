package org.algo4j.algorithm.sortAlgorithms;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by ithink on 17-7-12.
 */
public class HeapSort {

    public static void heapSort(int[] array){
        for(int i=array.length-1; i>0; i--){
            swap(array, 0, i);
            adjustHeap(array, i-1, 0);
        }
    }

    public static void adjustHeap(int[] array, int wide, int root){
        int leftChild = 2*root + 1;
        int rightChild = 2*root + 2;
        if(rightChild <= wide){
            if(array[root] < array[leftChild] || array[root] < array[rightChild]){
                if(array[leftChild] > array[rightChild]){
                    swap(array, root, leftChild);
                    adjustHeap(array, wide, leftChild);
                }else{
                    swap(array, root, rightChild);
                    adjustHeap(array, wide, rightChild);
                }
            }
        }else if(leftChild <= wide){
            if(array[root] < array[leftChild]){
                swap(array, root, leftChild);
                adjustHeap(array, wide, leftChild);
            }
        }
    }

    public static void swap(int[] array, int i, int j){
        array[i] ^= array[j];
        array[j] ^= array[i];
        array[i] ^= array[j];
    }

    @Test
    public void test(){
        int[] array = new int[]{59, 46, 79, 38, 40, 88, -1};
        for(int i=array.length/2-1; i>=0; i--){
            adjustHeap(array, array.length-1, i);
        }

        System.out.println(Arrays.toString(array));

        heapSort(array);

        System.out.println(Arrays.toString(array));
    }

}
