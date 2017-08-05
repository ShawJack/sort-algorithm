package org.algo4j.algorithm.sortAlgorithms;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by ithink on 17-7-12.
 */
public class ShellSort {

    public static void shellSort(int[] unsortedArray){
        int increament = unsortedArray.length / 2;
        while(increament >= 1){
            sort(unsortedArray, increament);
            increament /= 2;
        }

        //System.out.println(Arrays.toString(unsortedArray));
    }

    public static void sort(int[] unsortedArray, int increament){
        for(int i=increament; i<unsortedArray.length; i++){
            int temp = unsortedArray[i];
            int j = i-increament;
            for(; j>=0; j-=increament){
                if(unsortedArray[j] > temp){
                    unsortedArray[j+increament] = unsortedArray[j];
                }else{
                    break;
                }
            }
            unsortedArray[j+increament] = temp;
        }
    }

    @Test
    public void test(){
        int length = 100000;
        int[] array = new int[length];
        Random random = new Random(length);
        for(int i=0; i<length; i++){
            array[i] = random.nextInt(length);
        }
        //System.out.println(Arrays.toString(array));
        long start = System.currentTimeMillis();
        shellSort(array);
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }

}
