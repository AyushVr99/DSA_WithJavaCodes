package com.Data_Structures.Sorting;
//Time Complexity: O(n+k)  k-max element in array
//Space Complexity: O(n+k)
import java.util.Arrays;

public class CountSort {
    public static void main(String[] args) {
        int[] arr = {1,4,5,2,2,5};
//        basicsort(arr);
        adaptiveCountSort(arr);
    }

    //order of the duplicate elements is preserved
    static void adaptiveCountSort(int[] arr)
    {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++)
        {
            max = Math.max(max,arr[i]);  //Calculation Max value
        }
        int[] freq = new int[max+1]; // Creating freq array with size maxvalue + 1

        //Updating freq array with the freq of element occuring in the array
        for (int i = 0; i < arr.length; i++)
        {
            freq[arr[i]]++;
        }

        // Taking prefix sum of the freq array
        for (int i = 1; i < freq.length; i++)
        {
            freq[i] = freq[i]+freq[i-1];
        }

        //iterating from the end of array
        int[] ans = new int[arr.length];
        for (int i = arr.length-1; i >=0 ; i--)
        {
            int n = arr[i];
            int index = freq[n]-1;
            ans[index] = n;
            freq[n]--;
        }
        //you may copy the sorted element in the original array
        System.out.println(Arrays.toString(ans));

    }
    static void basicsort(int[] arr)
    {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++)
        {
            max = Math.max(max,arr[i]);  //Calculation Max value
        }

        int[] freq = new int[max+1]; // Creating freq array with size maxvalue + 1

        //Updating freq array with the freq of element occuring in the array
        for (int i = 0; i < arr.length; i++)
        {
            freq[arr[i]]++;
        }

        int j=0;
        //
        for (int i = 0; i < freq.length; i++)
        {
            int num = freq[i];
            while (num-->0)
            {
                arr[j++] = i;

            }
        }
        System.out.println(Arrays.toString(arr));
    }
}

