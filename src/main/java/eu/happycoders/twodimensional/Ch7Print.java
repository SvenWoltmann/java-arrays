package eu.happycoders.twodimensional;

import java.util.Arrays;

/** Printing a 2D array: toString(), deepToString(), one line per row, and aligned columns. */
public class Ch7Print {

  static void main() {
    int[][] intMatrix = {{2, 3, 6}, {4, 5, 1}};

    System.out.println(intMatrix);
    System.out.println(Arrays.toString(intMatrix));
    System.out.println(Arrays.deepToString(intMatrix));

    for (int[] row : intMatrix) {
      System.out.println(Arrays.toString(row));
    }

    int[][] products = new int[4][4];
    for (int i = 0; i < products.length; i++) {
      for (int j = 0; j < products[i].length; j++) {
        products[i][j] = (i + 7) * (j + 7);
      }
    }
    for (int[] row : products) {
      for (int value : row) {
        System.out.printf("%4d", value);
      }
      System.out.println();
    }
  }
}
