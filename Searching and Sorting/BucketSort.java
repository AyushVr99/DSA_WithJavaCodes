package com.Data_Structures.Sorting;
//Time Complexity: O(n^2) worst case
//                 O(n+k) best case

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BucketSort {
    public static void main(String[] args) {
        float[] arr = {0.5f, 0.4f, 0.3f, 0.2f, 0.1f};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void sort(float[] arr)
    {
        int n = arr.length;
        ArrayList<Float> buckets[] = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<Float>();
        }

        for (int i = 0; i < n; i++)
        {
            int index = (int)(arr[i]*n);
            buckets[index].add(arr[i]);
        }

        for (ArrayList index : buckets)
        {
            Collections.sort(index);
        }

        int k=0;
        for(int i=0; i<buckets.length; i++)
        {
            for (int j = 0; j < buckets[i].size(); j++)
            {
                arr[k++] = buckets[i].get(j);
            }
        }
    }
}
