package com.Rough;
//Time complexity: Best case- O(n)
//                 Worst case-O(n2)
//Space complexity: O(1)
//It is a in-place sorting algorithm
//It is unstable algorithm
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {2,5,4,1,3};
        bubblesort2(arr);
        for(int num : arr)
        {
            System.out.print(num + " ");
        }
    }
    static void bubblesort1(int[] arr)
    {// this will be running even if the array is sorted
        for (int i = 0; i < arr.length; i++)
        {
            for (int j = 0; j < arr.length-i-1; j++)
            {
                if (arr[j]>arr[j+1])
                {
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }

    static void bubblesort2(int[] arr)
    {//this will break the loop if the array is sorted when found that no swapping is occuring
        boolean swapp;
        for (int i=0; i< arr.length;i++)
        {
            swapp=false;
            for (int j=0;j< arr.length-1-i ;j++)
            {
                if (arr[j]>arr[j+1])
                {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapp=true;
                }
            }
            if (swapp==false)
            {
                break;
            }
        }
    }
}
