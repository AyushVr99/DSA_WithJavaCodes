
import java.util.Arrays;

public class CyclicSort {
    public static void main(String[] args) {
        int[] arr1 = {2,1,3,4};
        sort(arr1);
        System.out.println("For not O index based array");
        System.out.println(Arrays.toString(arr1));
        System.out.println();
        int[] arr2 = {1,0,3,2};
        sort2(arr2);
        System.out.println("For O index based array");
        System.out.println(Arrays.toString(arr2));
    }
    static void sort(int[] arr)
    {
        int i=0;
        while(i<arr.length)
        {
            int corrInd = arr[i]-1;
            if (arr[i] != arr[corrInd])
            {
                int temp = arr[i];
                arr[i] = arr[corrInd];
                arr[corrInd] = temp;
            }
            else {
                i++;
            }
        }
    }
    static void sort2(int[] arr)
    {
        int i=0;
        while(i<arr.length)
        {
            int corrInd = arr[i];
            if (arr[i] < arr.length && arr[i] != arr[corrInd])
            {
                int temp = arr[i];
                arr[i] = arr[corrInd];
                arr[corrInd] = temp;
            }
            else {
                i++;
            }
        }
    }
}
