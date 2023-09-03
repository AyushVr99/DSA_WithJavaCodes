package com.Data_Structures.Sorting;
//Time Complexity: O(n+k) ~ (dn) d-no.of digits, n-arraylength
//Space Complexity: O(n)

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {43,453,626,894,0,3};
        radSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void radSort(int[] arr)
    {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++)
        {
            max = Math.max(max,arr[i]);  //Calculating Max value
        }

        for (int place = 1; max/place>0 ; place*=10)
        {
            countSort(arr,place);
        }
    }
    static void countSort(int[] arr, int place)
    {
        int[] freq = new int[10];

        //Updating freq array with the freq of element occuring in the array
        for (int i = 0; i < arr.length; i++)
        {
            freq[(arr[i]/place)%10]++;
        }

        // Taking prefix sum of the freq array
        for (int i = 1; i < freq.length; i++)
        {
            freq[i] = freq[i]+freq[i-1];
        }
        int[] ans = new int[arr.length];
        for (int i = arr.length-1; i >=0 ; i--)
        {
            int n = (arr[i]/place)%10;
            int index = freq[n]-1;
            ans[index] = arr[i];
            freq[n]--;
        }
        //copying into existing array
        for (int i = 0; i < ans.length; i++) {
            arr[i] = ans[i];
        }
    }
}
