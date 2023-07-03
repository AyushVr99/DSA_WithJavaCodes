package com.Rough;

import java.util.Arrays;

//Time complexity: Best case- O(n)
//                 Worst case-O(n2)
//Space complexity: O(1)
//It is a in-place sorting algorithm
//It is stable algorithm
//It is adaptive
//It takes part in hybrid sorting algorithms
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {2,5,4,3,1};
        inserSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void inserSort(int[] arr)
    {
        for (int i = 0; i < arr.length-1; i++)
        {
            for (int j = i+1; j >0; j--)
            {
                if (arr[j]>arr[j-1])continue;
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
            }
        }
    }
}
