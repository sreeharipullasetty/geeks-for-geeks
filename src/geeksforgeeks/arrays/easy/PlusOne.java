package geeksforgeeks.arrays.easy;

import java.util.ArrayList;

/**
 * @author sreehari.pullasetty@gmail.com
 * @since 24/04/2021
 * @problem https://practice.geeksforgeeks.org/problems/plus-one/1/
 */
public class PlusOne {
    public static void main(String[] args) {
        ArrayList<Integer> elements = new ArrayList<>();
        elements.add(9);
        elements.add(9);
        elements.add(9);
        System.out.println(increment(elements,3));
    }

    /**
     *
     * @param arr digits
     * @param N size of arr
     * @return array list with incremented digits
     */
    public static ArrayList<Integer> increment(ArrayList<Integer> arr, int N) {
        int carry = 1;
        for (int i = N - 1; i >= 0; i--) {
            int digit = arr.get(i);
            int sum = digit + carry;
            if (sum > 9) {
                arr.set(i, 0);
            } else {
                arr.set(i, sum);
                carry = 0;
            }
        }
        if (carry == 1) {
            arr.add(0, 1);
        }
        return arr;
    }
}
