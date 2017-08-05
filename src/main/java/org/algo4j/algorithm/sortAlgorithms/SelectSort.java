package org.algo4j.algorithm.sortAlgorithms;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by ithink on 17-7-12.
 */
public class SelectSort {

    public static void sort(int[] unsortedArray){
        for(int i=0; i<unsortedArray.length-1; i++){
            int minIndex = i;
            for(int j=i+1; j<unsortedArray.length; j++){
                minIndex = unsortedArray[minIndex] < unsortedArray[j] ? minIndex : j;
            }

            if(i != minIndex) {
                unsortedArray[i] ^= unsortedArray[minIndex];
                unsortedArray[minIndex] ^= unsortedArray[i];
                unsortedArray[i] ^= unsortedArray[minIndex];
            }
        }

        System.out.println(Arrays.toString(unsortedArray));
    }

    public static void optimizedSort(int[] unsortedArray){
        for(int i=0; i<unsortedArray.length/2; i++){
            int minIndex = i;
            int maxIndex = i;
            for(int j=i; j<unsortedArray.length-i; j++){
                minIndex = unsortedArray[minIndex] > unsortedArray[j] ? j : minIndex;
                maxIndex = unsortedArray[maxIndex] > unsortedArray[j] ? maxIndex : j;
            }
            if(i != minIndex){
                unsortedArray[minIndex] ^= unsortedArray[i];
                unsortedArray[i] ^= unsortedArray[minIndex];
                unsortedArray[minIndex] ^= unsortedArray[i];

            }

            if(maxIndex != unsortedArray.length-i-1){
                unsortedArray[maxIndex] ^= unsortedArray[unsortedArray.length-i-1];
                unsortedArray[unsortedArray.length-i-1] ^= unsortedArray[maxIndex];
                unsortedArray[maxIndex] ^= unsortedArray[unsortedArray.length-i-1];
            }
        }

        System.out.println(Arrays.toString(unsortedArray));
    }

    @Test
    public void test(){
        optimizedSort(new int[]{1,3,5,2,8,7,6});
    }

}
