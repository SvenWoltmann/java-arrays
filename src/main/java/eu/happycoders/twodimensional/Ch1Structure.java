package eu.happycoders.twodimensional;

import java.util.Arrays;

/** A 2D array is an array of arrays: each row is an int array of its own. */
public class Ch1Structure {

  static void main() {
    int[][] intMatrix = {{2, 3, 6}, {4, 5, 1}};

    int[] row0 = intMatrix[0];
    int[] row1 = intMatrix[1];
    System.out.println("row0 = " + Arrays.toString(row0));
    System.out.println("row1 = " + Arrays.toString(row1));

    System.out.println("intMatrix[1][2] = " + intMatrix[1][2]);
  }
}
