package org.algo4j.algorithm.sortAlgorithms;

import org.junit.Test;

import java.util.Arrays;

/**
 * 插入排序
 * Created by ithink on 17-7-12.
 */
public class InsertSort {

    /**
     * 直接插入排序
     * @param unsortedArray
     */
    public static void sort(int[] unsortedArray){
        int temp = 0;

        for(int i=0; i<unsortedArray.length-1; i++){
            temp = unsortedArray[i+1];
            int location = 0;
            for(int j=i; j>=0; j--){
                if(unsortedArray[j] > temp){
                    unsortedArray[j+1] = unsortedArray[j];
                }else{
                    location = j+1;
                    break;
                }
            }
            unsortedArray[location] = temp;
        }

        System.out.println(Arrays.toString(unsortedArray));
    }


    /**
     * 直接插入排序
     * @param unsortedArray
     */
    public static void sort2(int[] unsortedArray){
        for(int i=0; i<unsortedArray.length-1; i++){
            int temp = unsortedArray[i+1];
            int j = i;
            for(; j>=0; j--){
                if(temp < unsortedArray[j]){
                    unsortedArray[j+1] = unsortedArray[j];
                }else{
                    break;
                }
            }
            unsortedArray[j+1] = temp;
        }

        //System.out.println(Arrays.toString(unsortedArray));
    }

    /**
     * 二分插入排序
     */
    public static void sort3(int[] unsortedArray){
        for(int i=0; i<unsortedArray.length-1; i++){
            int temp = unsortedArray[i+1];
            int location = binarySearch(unsortedArray, 0, i, temp);
            for(int j=i; j>=location; j--){
                unsortedArray[j+1] = unsortedArray[j];
            }
            unsortedArray[location] = temp;
        }
        //System.out.println(Arrays.toString(unsortedArray));
    }

    public static int binarySearch(int[] array, int start, int end, int target){
        int high = end;
        int low = start;
        while(low <= high){
            int middle = low + (high-low)/2;

            if(array[middle] > target)high = middle - 1;
            else if(array[middle] < target)low = middle + 1;
            else return middle;
        }

        return low;
    }

    @Test
    public void test(){
        sort3(new int[]{5,6,2,3,8,7,1, -1});

        System.out.println(binarySearch(new int[]{1,3,4,5,6}, 0, 5, 4));
    }
}
