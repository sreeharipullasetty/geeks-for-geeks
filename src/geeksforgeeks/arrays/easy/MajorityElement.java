package geeksforgeeks.arrays.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sreehari.pullasetty@gmail.com
 * @since 2/04/2021
 * @problem Problem-Statement: https://practice.geeksforgeeks.org/problems/majority-element-1587115620/1
 */
public class MajorityElement {
    public static void main(String[] args) {
        int N = 5;
        int[] A = new int[]{3, 1, 2, 3, 3};
        System.out.println(getMajorityElement(A, N));
    }

    /**
     *
     * @param a array of elements
     * @param size size of the array
     * @return majority element (frequency > size/2) in the array if exists otherwise -1
     */
    public static int getMajorityElement(int[] a, int size) {
        Map<Integer, Integer> elementFrequency = new HashMap<>();

        //Iterate over array and add elements to map with frequency as value
        for (int ele : a) {
            elementFrequency.merge(ele, 1, Integer::sum);
        }

        // finds the element with frequency greater than size/2 and return if exists otherwise return -1
        for (Map.Entry<Integer, Integer> entry : elementFrequency.entrySet()) {
            if (entry.getValue() > size / 2) {
                return entry.getKey();
            }
        }
        return -1;
    }
}
