package eu.happycoders.twodimensional;

import java.util.Arrays;

/** Iterating over a 2D array: nested for loops, for-each loops, and a stream. */
public class Ch6Iterate {

  static void main() {
    int[][] intMatrix = {{2, 3, 6}, {4, 5, 1}};

    for (int row = 0; row < intMatrix.length; row++) {
      for (int col = 0; col < intMatrix[row].length; col++) {
        System.out.println("intMatrix[" + row + "][" + col + "] = " + intMatrix[row][col]);
      }
    }

    int sum = 0;
    for (int[] row : intMatrix) {
      for (int value : row) {
        sum += value;
      }
    }
    System.out.println("sum = " + sum);

    int streamSum = Arrays.stream(intMatrix).flatMapToInt(Arrays::stream).sum();
    System.out.println("streamSum = " + streamSum);

    int max = Arrays.stream(intMatrix).flatMapToInt(Arrays::stream).max().orElseThrow();
    System.out.println("max = " + max);
  }
}
