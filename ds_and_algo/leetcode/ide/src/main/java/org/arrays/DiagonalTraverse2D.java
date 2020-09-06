package org.arrays;

public class DiagonalTraverse2D {
    /**
     * Given a matrix of M x N elements (M rows, N columns),
     * return all elements of the matrix in diagonal order as shown in the below image.
     * @param matrix
     * @return
     */
    public static int[] findDiagonalOrder(int[][] matrix) {

        /**
         * [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
         *     0  1  2
         *  0 [1, 2, 3]
         *  1 [4, 5, 6]
         *  2 [7, 8, 9]
         *
         *
         *
         */
         int N = matrix.length;
         int M = matrix[0].length;

         int row = 0, column = 0;
         int direction = 1;

         int [] result = new int [N * M];
         int elementIndex= 0;

         while (row < N && column < M) {

             // add the first element
             result[elementIndex++] = matrix[row][column];

             // calculate the nxt raw and column
             int new_row = row + (direction == 1 ? -1 : 1);
             int new_column = column + (direction == 1 ? 1 : -1);

             boolean isRowWithinBoundary = new_row < 0 || new_row == N;
             boolean isColumnWithinBoundary = new_column < 0 || new_column == M;

             if (isRowWithinBoundary || isColumnWithinBoundary) {
                 // if we are at boundary then we have to find the next starting point
                 if (direction == 1) {
                     // currently going up, then formula => (row + 1, column)
                     //row = column == M
                 } else {
                     // currently going down, then formula => (row, column + 1)

                 }
             } else {
                 // we are not at at boundary, hence just proceed
                 row = new_row;
                 column = new_column;
             }

         }
         return null;
    }

    public static void main(String[] args) {
        int [][] input = new int [3][3];
        int counter = 0;

        for(int y = 0; y < input.length; y++) {
            for (int x = 0; x < input[y].length; x++) {
                input[y][x] = ++counter;
            }
        }
        findDiagonalOrder(input);
    }
}
