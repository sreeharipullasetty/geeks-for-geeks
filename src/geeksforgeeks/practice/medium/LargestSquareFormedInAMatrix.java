package geeksforgeeks.practice.medium;

/**
 * @author sreehari.pullasetty@gmail.com
 * @since 24/04/20201
 * Problem-Statement: https://www.geeksforgeeks.org/maximum-size-sub-matrix-with-all-1s-in-a-binary-matrix/
 */
public class LargestSquareFormedInAMatrix {
    public static void main(String[] args) {
        //matrix data the form of array
        int[] data = new int[]{0, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 1, 1, 0, 1, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1};

        int n = 4; //rows
        int m = 19; //columns

        int[][] A = new int[n][m];
        int r = 0, c = 0;

        //input matrix
        for (int datum : data) {
            A[r][c] = datum;
            c++;
            if (c == m) {
                r++;
                c = 0;
            }
        }

        for (int[] matrix : A) {
            for (int ele : matrix) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }

        System.out.println("---------------------------------------");

        int[][] adjacencyMatrix = getAdjacencyMatrix(A);

        for (int[] matrix : adjacencyMatrix) {
            for (int ele : matrix) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }

        System.out.println(getMaximumSquaredMatrixSize(A));
    }

    /**
     * @param A input matrix
     * @return maximum squared matrix size
     */
    public static int getMaximumSquaredMatrixSize(int[][] A) {

        int[][] adjacencyMatrix = getAdjacencyMatrix(A);
        int maxSquare = 0;
        for (int[] row : adjacencyMatrix) {
            for (int ele : row) {
                if (maxSquare < ele) {
                    maxSquare = ele;
                }
            }
        }
        return maxSquare;
    }

    /**
     * @param A input matrix
     * @return adjacency matrix
     */
    public static int[][] getAdjacencyMatrix(int[][] A) {
        int[][] adjacencyMatrix = new int[A.length + 1][A[0].length + 1];
        for (int i = 1; i < adjacencyMatrix.length; i++) {
            for (int j = 1; j < adjacencyMatrix[i].length; j++) {
                if (A[i - 1][j - 1] == 1) {
                    int minimum = getMinimum(adjacencyMatrix[i - 1][j], adjacencyMatrix[i][j - 1], adjacencyMatrix[i - 1][j - 1]);
                    adjacencyMatrix[i][j] = minimum + 1;
                }
            }
        }
        return adjacencyMatrix;
    }

    /**
     * @param top     top element from adjacency matrix
     * @param left    left side element from adjacency matrix
     * @param topLeft top left element from adjacency matrix
     * @return minimum element from the above 3 element
     */
    public static int getMinimum(int top, int left, int topLeft) {
        if (top <= left && top <= topLeft) {
            return top;
        } else if (left <= top && left <= topLeft) {
            return left;
        } else {
            return topLeft;
        }
    }
}
