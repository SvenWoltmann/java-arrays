package eu.happycoders.twodimensional;

import java.util.Arrays;

/** A 3 x 4 matrix stored in a flat 1D array: element [row][col] is at index row * columns + col. */
public class Ch13Flat {

  static void main() {
    int[][] matrix = {{2, 3, 6, 4}, {5, 1, 9, 7}, {8, 0, 3, 2}};
    int rows = matrix.length;
    int columns = matrix[0].length;

    int[] flat = new int[rows * columns];
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < columns; col++) {
        flat[row * columns + col] = matrix[row][col];
      }
    }
    System.out.println("flat = " + Arrays.toString(flat));

    System.out.println("matrix[1][2] = " + matrix[1][2]);
    System.out.println("flat[1 * 4 + 2] = " + flat[1 * columns + 2]);
  }
}
