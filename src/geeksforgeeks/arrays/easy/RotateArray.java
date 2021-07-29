package geeksforgeeks.arrays.easy;

import java.util.Arrays;

/**
 * @author sreehari.pullasetty@gmail.com
 * @since 24/04/2021
 * @problem Problem-Statement: https://practice.geeksforgeeks.org/problems/rotate-array-by-n-elements-1587115621/1
 */
public class RotateArray {
    public static void main(String[] args) {
        int[] A = new int[]{2, 62, 31, 79, 6, 21, 37, 45, 27, 23, 66};
        new RotateArray().rotateArr(A, 6, 11);
        System.out.println(Arrays.toString(A));
    }

    /**
     *
     * @param arr array elements
     * @param d number of rotations
     * @param n size of array
     */
    public static void rotateArr(int[] arr, int d, int n) {
        int[] response = getRotatedArray(arr, d, n);
        if (n >= 0) {
            System.arraycopy(response, 0, arr, 0, n);
        }
    }

    /**
     *
     * @param arr array elements
     * @param d number of rotations
     * @param n size of array
     * @return rotated array
     */
    public static int[] getRotatedArray(int[] arr, int d, int n) {
        int[] rotatedArray = new int[n];
        for (int i = 0; i < n; i++) {
            rotatedArray[i] = arr[(i + d) % n];
        }
        return rotatedArray;
    }
}
