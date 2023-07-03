package com.Rough;

public class LinearSearch {
    public static void main(String[] args) {
        int[] nums= {2,95,57,20,3,40};

        System.out.println("Index is: " + Lsearch(nums,57) );

        System.out.println(findInrange(nums,20,1,4));
    }
    static int Lsearch(int[] arr, int target)
    {
        for (int i =0;i<arr.length;i++)
        {
            if (arr[i]==target)
            {
                return i;
            }
        }
        return -1;
    }

    static int findInrange(int[] arr,int target, int start, int end)
    {
        for (int i=start; i<=end ; i++)
        {
            if(arr[i]== target)
            {
                return i;
            }
        }
        return -1;
    }

}
