package org.algo4j.algorithm.sortAlgorithms;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by ithink on 17-7-26.
 */
public class QuickSort {

    public static int partition(int[] array, int start, int end){
        int privotKey = array[start];

        while(start < end){
            while(start<end && array[end]>=privotKey)end--;
            if(array[end] != privotKey)HeapSort.swap(array, start, end);
            while(start<end && array[start]<=privotKey)start++;
            if(array[start] != privotKey)HeapSort.swap(array, start, end);
        }

        return start;
    }

    public static void quickSort(int[] array, int start, int end){
        if(start < end){
            int position = partition(array, start, end);

            quickSort(array, start, position-1);
            quickSort(array, position+1, end);
        }
    }

    @Test
    public void test(){
        int[] array = new int[]{1,2,3,4,5};

        quickSort(array, 0, array.length-1);

        System.out.println(Arrays.toString(array));

    }

}
