package eu.happycoders.twodimensional;

import java.util.Arrays;

/** Jagged arrays: rows of different lengths, e.g. a triangle. */
public class Ch9Jagged {

  static void main() {
    int[][] twoDimensionalArray = {{2, 3, 6}, {4, 5, 1, 9, 7}};
    for (int[] row : twoDimensionalArray) {
      System.out.println(row.length + " elements: " + Arrays.toString(row));
    }

    int[][] triangle = new int[4][];
    for (int row = 0; row < triangle.length; row++) {
      triangle[row] = new int[row + 1];
      triangle[row][0] = 1;
      triangle[row][row] = 1;
      for (int col = 1; col < row; col++) {
        triangle[row][col] = triangle[row - 1][col - 1] + triangle[row - 1][col];
      }
    }
    System.out.println(Arrays.deepToString(triangle));
  }
}
