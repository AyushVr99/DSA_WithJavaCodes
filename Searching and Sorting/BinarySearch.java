package com.Rough;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,2,5,9,10,15,20};
        System.out.println(BS(arr,20));
    }
    static int BS(int[] arr,int target)
    {
        int low=0;
        int high = arr.length-1;
        while (low<=high)
        {
            int mid = low+(high-low)/2;
            if (arr[mid]==target)
            {
                return mid;
            }
            if (arr[mid]>target)
            {
                high=mid-1;
            }else
            {
                low = mid+1;
            }
        }
        return -1;
    }
}
