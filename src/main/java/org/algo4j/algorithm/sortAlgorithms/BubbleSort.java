package org.algo4j.algorithm.sortAlgorithms;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by ithink on 17-7-12.
 */
public class BubbleSort {

    public static void sort(int[] unsortedArray){
        for(int i=0; i<unsortedArray.length-1; i++){
            for(int j=0; j<unsortedArray.length-i-1; j++){
                if(unsortedArray[j] > unsortedArray[j+1]){
                    unsortedArray[j] ^= unsortedArray[j+1];
                    unsortedArray[j+1] ^= unsortedArray[j];
                    unsortedArray[j] ^= unsortedArray[j+1];
                }
            }
        }

        //System.out.println(Arrays.toString(unsortedArray));
    }


    public static void optimizedSort(int[] unsortedArray){
        int end = unsortedArray.length-1;
        int record = 0;
        for(int i=0; i<unsortedArray.length-1; i++){
            for(int j=0; j<end; j++){
                if(unsortedArray[j] > unsortedArray[j+1]){
                    unsortedArray[j] ^= unsortedArray[j+1];
                    unsortedArray[j+1] ^= unsortedArray[j];
                    unsortedArray[j] ^= unsortedArray[j+1];

                    record = j;
                }
            }
            end = record;
        }

        //System.out.println(Arrays.toString(unsortedArray));
    }

    @Test
    public void test(){
        optimizedSort(new int[]{3,2,7,6,9,8,2,5,-1});
    }

}
