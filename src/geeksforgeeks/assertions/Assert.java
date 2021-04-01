package geeksforgeeks.assertions;

import java.util.logging.Logger;

/**
 * @author sreehari.pullasetty@gmail.com
 * @since 15/03/2021
 */
public class Assert {

    static Logger logger = Logger.getGlobal();

    public static void main(String args[]) {
        int arr1[] = new int[]{1, 2, 3};
        int arr2[] = new int[]{2, 3};

        Assert.assertEquals(arr1, arr2);
    }

    /**
     * asserts two given numbers
     *
     * @param expected
     * @param actual
     * @return
     */
    public static boolean assertEquals(int expected, int actual) {
        if (expected != actual) {
            logger.info("Assertion failed. \nExpected: " + expected + " \nActual: " + actual);
            return false;
        } else {
            return true;
        }
    }


    /**
     * asserts two given strings
     *
     * @param expected
     * @param actual
     * @return
     */
    public static boolean assertEquals(String expected, String actual) {
        if (!expected.equals(actual)) {
            logger.info("Assertion failed. \nExpected: " + expected + " \nActual: " + actual);
            return false;
        } else {
            return true;
        }
    }

    /**
     * asserts two given integer arrays
     *
     * @param expected
     * @param actual
     * @return
     */
    public static boolean assertEquals(int[] expected, int[] actual) {
        if (expected.length != actual.length) {
            logger.info("Assertion failed. \nExpected: " + getString(expected) + " \nActual: " + getString(actual));
            return false;
        } else {
            for (int i = 0; i < expected.length; i++) {
                if (expected[i] != actual[i]) {
                    logger.info("Assertion failed. \nExpected: " + getString(expected) + " \nActual: " + getString(actual));
                    return false;
                }
            }
            return true;
        }
    }

    /**
     * returns true if expected and actual are same otherwise false
     *
     * @param expected
     * @param actual
     * @return
     */
    public static boolean assertEquals(boolean expected, boolean actual) {
        if (expected != actual) {
            logger.info("Assertion failed. \nExpected: " + expected + " \nActual: " + actual);
            return false;
        } else {
            return true;
        }
    }


    /**
     * Converts integer array to string
     *
     * @param arr
     * @return
     */
    public static String getString(int[] arr) {
        StringBuilder response = new StringBuilder("{");
        for (int ele : arr) {
            response.append(ele + ", ");
        }
        response = new StringBuilder(response.substring(0, response.length() - 2));
        response.append("}");
        return response.toString();
    }


}
