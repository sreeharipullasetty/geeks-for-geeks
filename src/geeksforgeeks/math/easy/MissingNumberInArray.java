package geeksforgeeks.math.easy;

import geeksforgeeks.assertions.Assert;

/**
 * @author sreehari.pullasetty@gmail.com
 * @since 01/04/2021
 * Problem-Statement: https://practice.geeksforgeeks.org/problems/missing-number-in-array1416/1
 */
public class MissingNumberInArray {
    public static void main(String[] args) {
        int a[] = new int[]{1, 2, 3, 5};
        int n = 5;
        int expected = 4;
        int actual = MissingNumber(a, n);
        Assert.assertEquals(expected, actual);
    }

    /**
     * @param array
     * @param n
     * @return missing number in the given array
     */
    public static int MissingNumber(int array[], int n) {
        int totalElementsSum = (n * (n + 1)) / 2; // finds the sum of first N numbers from 1 to N. formula: (N * N+1)/2
        int givenElementsSum = 0; //stores sum of all elements in the array
        for (int element : array) {
            givenElementsSum += element;
        }
        return totalElementsSum - givenElementsSum; // returns missing element
    }
}
