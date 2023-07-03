import java.util.Arrays;

//time complexity: O(n2)
//Space complexity: O(1)

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr={5,4,3,2,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void sort(int[] arr)
    {
        for (int i = 0; i < arr.length; i++) {
            int last = arr.length-1-i;
            int max = 0;
            for (int j=0;j<= last;j++)
            {
                if (arr[j]>arr[max])
                {
                    max=j;
                }
            }
            swap(arr,last,max);
        }
    }
    static void swap(int[] arr,int maxIndex, int last)
    {
        int temp = arr[maxIndex];
        arr[maxIndex]=arr[last];
        arr[last]=temp;
    }
}
