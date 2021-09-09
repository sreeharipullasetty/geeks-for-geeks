package geeksforgeeks.dp.examples;

public class Fibonacci {
    public static void main(String[] args) {
        //0 1 1 2 3 5 8 13 21 34 55 89 144
        int n = 50;
        long startTime = System.currentTimeMillis();
        long fibonacci = getFibonacciWithoutDP(n);
        System.out.println(fibonacci);
        long endTime = System.currentTimeMillis();
        System.out.println("total time without dp: " + (endTime - startTime)/1000);

        long dpStartTime = System.currentTimeMillis();
        long dpFibonacci = getFibonacciWithDP(n);
        System.out.println(dpFibonacci);
        long dpEndTime = System.currentTimeMillis();
        System.out.println("total time with dp: " + (dpEndTime - dpStartTime)/1000);
    }

    static long getFibonacciWithDP(int n) {
        long[] fibs = new long[n];
        fibs[0] = 0;
        fibs[1] = 1;
        for (int i = 2; i < n; i++) {
            fibs[i] = fibs[i - 1] + fibs[i - 2];
        }
        return fibs[n - 1];
    }

    static long getFibonacciWithoutDP(int n) {
        if (n == 1) {
            return 0;
        }
        if (n == 2 || n == 3) {
            return 1;
        } else {
            return getFibonacciWithoutDP(n - 1) + getFibonacciWithoutDP(n - 2);
        }
    }
}
