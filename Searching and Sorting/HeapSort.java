package com.Data_Structures.Sorting;

import java.util.Arrays;
//time complexity: O(nlogn)
//Space complexity: O(1)
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {12,11,13,5,6,7};

        int N = arr.length;

        for (int i=(N/2)-1; i>= 0; i--)
        {
            heapify(arr,N,i);
        }

        for (int i=N-1; i>0 ;i--)
        {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;

            heapify(arr,i,0);
        }

        System.out.println("After sorting: " + Arrays.toString(arr));
        //time complexity 0(nlogn)
    }
    static void heapify(int[] arr,int N, int i)
    {
        int largest = i;
        int left = 2*i + 1;
        int right = 2*i + 2;

        if (left < N && arr[left]>arr[largest])
        {
                largest = left;
        }
        if (right < N && arr[right]>arr[largest])
        {
                largest = right;
        }

        if (largest != i)
        {
            int temp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = temp;
            heapify(arr,N,largest);
        }

    }
}
