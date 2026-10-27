package eu.happycoders.twodimensional;

import java.util.Arrays;

/** Copying a 2D array: clone() copies only the outer array; a deep copy clones every row. */
public class Ch10Copy {

  static void main() {
    int[][] original = {{2, 3, 6}, {4, 5, 1}};

    int[][] copy = original.clone();
    copy[0][0] = 99;
    System.out.println("original = " + Arrays.deepToString(original));
    System.out.println("copy     = " + Arrays.deepToString(copy));
    System.out.println("same row: " + (original[0] == copy[0]));

    int[][] deepCopy = new int[original.length][];
    for (int row = 0; row < original.length; row++) {
      deepCopy[row] = original[row].clone();
    }
    deepCopy[0][0] = 42;
    System.out.println("original = " + Arrays.deepToString(original));
    System.out.println("deepCopy = " + Arrays.deepToString(deepCopy));

    int[][] streamCopy = Arrays.stream(original).map(int[]::clone).toArray(int[][]::new);
    streamCopy[1][1] = 42;
    System.out.println("original   = " + Arrays.deepToString(original));
    System.out.println("streamCopy = " + Arrays.deepToString(streamCopy));

    int[][] a = {{1, 2}, {3, 4}};
    int[][] b = {{1, 2}, {3, 4}};
    System.out.println("a.equals(b)           = " + a.equals(b));
    System.out.println("Arrays.equals(a, b)   = " + Arrays.equals(a, b));
    System.out.println("deepEquals(a, b)      = " + Arrays.deepEquals(a, b));
    System.out.println("Arrays.hashCode(a)    = " + Arrays.hashCode(a));
    System.out.println("Arrays.hashCode(b)    = " + Arrays.hashCode(b));
    System.out.println("deepHashCode(a)       = " + Arrays.deepHashCode(a));
    System.out.println("deepHashCode(b)       = " + Arrays.deepHashCode(b));
  }
}
