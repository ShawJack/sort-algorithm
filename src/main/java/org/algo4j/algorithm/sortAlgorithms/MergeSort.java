package org.algo4j.algorithm.sortAlgorithms;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by ithink on 17-7-26.
 */
public class MergeSort {

    public static void mergeSort(int[] array, int step){
        for(int i=0; i<array.length; i+=step){
            if(i+step/2 < array.length)merge(array, i, i+step/2-1, i+step/2, i+step-1>=array.length?array.length-1:i+step-1);
        }
    }

    public static void merge(int[] array, int start1, int end1, int start2, int end2){
        int[] tempArray = new int[end2-start1+1];
        int index = 0;
        int start = start1;

        while(start1<=end1 && start2<=end2){
            if(array[start1] < array[start2])tempArray[index++] = array[start1++];
            else tempArray[index++] = array[start2++];
        }

        if(start1 > end1){
            while(start2 <= end2)tempArray[index++] = array[start2++];
        }else{
            while(start1 <= end1)tempArray[index++] = array[start1++];
        }

        index = 0;
        for(int i=start; i<=start+tempArray.length-1; i++){
            array[i] = tempArray[index++];
        }
    }

    @Test
    public void test(){
        int[] array = new int[]{1,3,2,6,8,5};

        int step = 2;
        while(step < array.length*2){
            mergeSort(array, step);

            step *= 2;
        }

        System.out.println(Arrays.toString(array));
    }

}
