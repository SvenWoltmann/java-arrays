package eu.happycoders.twodimensional;

import java.util.Arrays;

/** Filling a 2D array: setAll() per row, and the pitfall of fill() with one row object. */
public class Ch8Fill {

  static void main() {
    int[][] products = new int[11][11];
    for (int i = 0; i < products.length; i++) {
      int row = i; // the lambda needs an effectively final variable
      Arrays.setAll(products[i], j -> row * j);
    }
    System.out.println("products[7] = " + Arrays.toString(products[7]));

    for (int[] row : products) {
      Arrays.fill(row, -1);
    }
    System.out.println("products[7] = " + Arrays.toString(products[7]));

    int[][] matrix = new int[3][];
    Arrays.fill(matrix, new int[] {1, 2, 3, 4});
    System.out.println("matrix = " + Arrays.deepToString(matrix));

    matrix[1][1] = 99;
    System.out.println("matrix = " + Arrays.deepToString(matrix));

    Arrays.setAll(matrix, ignored -> new int[] {1, 2, 3, 4});
    matrix[1][1] = 99;
    System.out.println("matrix = " + Arrays.deepToString(matrix));
  }
}
