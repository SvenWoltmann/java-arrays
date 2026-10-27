package eu.happycoders.twodimensional;

import java.util.Arrays;

/** Reading and writing elements, a row as an array, and the index out of bounds. */
public class Ch4Access {

  static void main() {
    int[][] intMatrix = {{2, 3, 6}, {4, 5, 1}};

    int value = intMatrix[1][2];
    System.out.println("intMatrix[1][2] = " + value);

    intMatrix[1][2] = 9;
    System.out.println("intMatrix = " + Arrays.deepToString(intMatrix));

    int[] row1 = intMatrix[1];
    row1[0] = 7;
    System.out.println("intMatrix = " + Arrays.deepToString(intMatrix));

    try {
      System.out.println(intMatrix[0][3]);
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println(e);
    }

    try {
      System.out.println(intMatrix[2][0]);
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println(e);
    }
  }
}
