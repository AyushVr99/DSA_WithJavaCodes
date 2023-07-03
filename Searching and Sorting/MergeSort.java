package com.Data_Structures.Sorting;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {2,5,4,1,3,62,80,9,7,58};
        mergeSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    static void mergeSort(int[] arr, int low, int high)
    {
        int mid = low+(high-low)/2;
        if(low>=high)
        {
            return;
        }
        mergeSort(arr,low, mid);
        mergeSort(arr,mid+1,high);
        merge(arr,low,mid,high);
    }
    static void merge(int[] arr, int low,int mid, int high)
    {
        int i=low;
        int j=mid+1;
        int k = low;
        int[] B = new int[arr.length];
        while(i<=mid && j<=high)
        {
            if (arr[i]<arr[j])
            {
                B[k] = arr[i];
                i++;
                k++;
            }
            else
            {
                B[k] = arr[j];
                j++;
                k++;
            }
        }
        while(i<=mid)
        {
            B[k] = arr[i];
            i++;
            k++;
        }
        while(j<=high)
        {
            B[k]= arr[j];
            j++;
            k++;
        }
        for (int s=low;s<=high;s++)
        {
            arr[s]=B[s];
        }
    }
}
