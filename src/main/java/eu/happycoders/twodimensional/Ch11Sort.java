package eu.happycoders.twodimensional;

import java.util.Arrays;
import java.util.Comparator;

/** Sorting a 2D array: every row for itself, or the rows by one of their columns. */
public class Ch11Sort {

  static void main() {
    int[][] intMatrix = {{2, 3, 6}, {4, 5, 1}};
    for (int[] row : intMatrix) {
      Arrays.sort(row);
    }
    System.out.println("rows sorted: " + Arrays.deepToString(intMatrix));

    int[][] points = {{3, 7}, {1, 9}, {2, 4}};
    Arrays.sort(points, Comparator.comparingInt(point -> point[0]));
    System.out.println("by x: " + Arrays.deepToString(points));

    Arrays.sort(points, Comparator.comparingInt((int[] point) -> point[1]).reversed());
    System.out.println("by y, descending: " + Arrays.deepToString(points));
  }
}
