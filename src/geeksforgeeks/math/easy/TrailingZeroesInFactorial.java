package geeksforgeeks.math.easy;

import geeksforgeeks.assertions.Assert;

/**
 * @author sreehari.pullasetty@gmail.com
 * @since 01/04/2021
 * Problem-Statement: https://practice.geeksforgeeks.org/problems/trailing-zeroes-in-factorial5134/1
 */
public class TrailingZeroesInFactorial {

    public static void main(String args[]) {
        int N = 5;
        int expected = 1;
        int actual = trailingZeroes(N);
        Assert.assertEquals(expected, actual);

        N = 15;
        expected = 3;
        actual = trailingZeroes(N);
        Assert.assertEquals(expected, actual);

        N = 120;
        expected = 28;
        actual = trailingZeroes(N);
        Assert.assertEquals(expected, actual);

    }

    /**
     * @param N
     * @return number of trailing zeros
     * Logic: divide the number with 5, till the number is zero, and sum all the Quotients
     * Example 1: 15! = 1307674368000, 15/5 = 3, 3/5 = 0. (3+0 = 3)
     * Example 2: 120! = 120/5 = 24, 24/5 = 4, 4/5 = 0, (24+4+0 = 28)
     */
    public static int trailingZeroes(int N) {
        int trailingZeros = 0;
        while (N != 0) {
            N = N / 5;
            trailingZeros += N;
        }
        return trailingZeros;
    }
}
