package geeksforgeeks.practice.easy;

import geeksforgeeks.assertions.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sreehari.pullasetty@gmail.com
 * @since 23/04/2021
 * Problem-Statement: https://practice.geeksforgeeks.org/problems/first-repeating-element4018/1
 */
public class FirstRepeatingElement {
    public static void main(String[] args) {
        int[] input = new int[]{1, 2, 3, 4, 5, 6};
        int expected = -1;
        int actual = getFirstRepeatingElementIndexMethod1(input);
        Assert.assertEquals(expected, actual);

        input = new int[]{1, 2, 3, 4, 5, 6, 1};
        expected = 1;
        actual = getFirstRepeatingElementIndexMethod1(input);
        Assert.assertEquals(expected, actual);

        input = new int[]{1, 2, 3, 4, 5, 6};
        expected = -1;
        actual = getFirstRepeatingElementIndexMethod2(input);
        Assert.assertEquals(expected, actual);

        input = new int[]{1, 2, 3, 4, 5, 6, 1};
        expected = 1;
        actual = getFirstRepeatingElementIndexMethod2(input);
        Assert.assertEquals(expected, actual);

        //Time Complexity Analysis
        input = getArrayWith10LackElements();
        expected = 1;
        long startTime = System.currentTimeMillis();
        actual = getFirstRepeatingElementIndexMethod1(input);
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken Method 1(10Lack): " + (endTime - startTime));
        Assert.assertEquals(expected, actual);

        startTime = System.currentTimeMillis();
        actual = getFirstRepeatingElementIndexMethod2(input);
        endTime = System.currentTimeMillis();
        System.out.println("Time taken Method 2(10Lack): " + (endTime - startTime));
        Assert.assertEquals(expected, actual);

    }

    /**
     * @return an array with 10,00,001 elements with 1 repating element at the last index. Ex: [1,2,3,4,5,6,7,1]
     */
    public static int[] getArrayWith10LackElements() {
        int[] arr = new int[1000001];
        for (int i = 0; i < 1000000; i++) {
            arr[i] = i + 1;
        }
        arr[1000000] = 1;
        return arr;
    }

    /**
     * @param arr array of non-negative elements
     * @return first repeating element index if exists otherwise return -1
     * @apiNote Method 1: Naive approach
     * @implNote Time complexity: O(n^2)
     */
    public static int getFirstRepeatingElementIndexMethod1(int[] arr) {
        int arrLength = arr.length;
        for (int i = 0; i < arrLength; i++) {
            for (int j = i + 1; j < arrLength; j++) {
                if (arr[i] == arr[j]) {
                    return i+1;
                }
            }
        }
        return -1;
    }

    /**
     * @param arr array of non-negative elements
     * @return first repeating element index if exists otherwise return -1
     * @apiNote Method 2: Using Hashing mechanism
     * @implNote Time complexity: O(n)
     */
    public static int getFirstRepeatingElementIndexMethod2(int[] arr) {
        int arrSize = arr.length;
        int max = arr[0];

        // finding max in the given array
        for (int i = 1; i < arrSize; i++) {
            max = Math.max(arr[i], max);
        }

        int[] dummy = new int[max + 1]; // dummy array with above max size

        //storing counts in dummy array
        for (int j : arr) {
            dummy[j]++;
        }

        // finding first repeating element
        for (int i = 0; i < arrSize; i++) {
            if (dummy[arr[i]] > 1) {
                return i+1;
            }
        }
        return -1;
    }
}
    