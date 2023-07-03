package com.Rough;

public class OrderAgnostic_BS {
    public static void main(String[] args) {
        int[] nums= {9,8,7,6,5,4,3,2,1};
        boolean checkifAsc = true;

        //to check whether array is ascending or descending
        if (nums[0] > nums[nums.length-1])
        {
            checkifAsc=false;
        }


        System.out.println(search(nums,7,checkifAsc));
    }
    static int search(int[] arr, int target, boolean checkifAsc)
    {
        int low = 0;
        int high = arr.length-1;
        while (low<=high)
        {
            int mid = low + (high-low)/2;
            if (arr[mid] == target)
            {
                return mid;
            }

            if (checkifAsc)
            {//for ascending array
                if (arr[mid] < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            else
            {//for descending array
                if (arr[mid] > target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

        }
        return -1;
    }
}
