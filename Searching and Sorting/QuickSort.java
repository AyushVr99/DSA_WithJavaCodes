
import java.util.Arrays;
//time complexity: O(nlogn)
//Space complexity: O(n)
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {2,1,4,3,5,8,6,7};
        sort(arr,0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    static void sort(int[] arr, int low, int high)
    {
        if (low>high)
        {
            return;
        }
        int start=low;
        int end = high;
        int targetPivot = start+(end-start)/2;
        while (start<=end)
        {
            while (arr[start] < arr[targetPivot])
            {
                start++;
            }
            while (arr[end] > arr[targetPivot])
            {
                end--;
            }
            if (start<=end)
            {
                int temp = arr[start];
                arr[start]=arr[end];
                arr[end]=temp;
                start++;
                end--;
            }
        }
        sort(arr,low,end);
        sort(arr,start,high);
    }
}
