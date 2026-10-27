package eu.happycoders.initialize;

import java.util.Arrays;

/** Filling an array: element by element, with Arrays.fill(), and with Arrays.setAll(). */
public class Ch2Fill {

  static void main() {
    int[] squares = new int[11];
    for (int i = 0; i < squares.length; i++) {
      squares[i] = i * i;
    }
    System.out.println(Arrays.toString(squares));

    int[] intArray = new int[10];
    Arrays.fill(intArray, 99);
    System.out.println(Arrays.toString(intArray));

    int[] twoRanges = new int[10];
    Arrays.fill(twoRanges, 0, 5, 11);
    Arrays.fill(twoRanges, 5, 10, 77);
    System.out.println(Arrays.toString(twoRanges));

    int[] setAll = new int[11];
    Arrays.setAll(setAll, i -> i * i);
    System.out.println(Arrays.toString(setAll));

    int[] parallelSetAll = new int[11];
    Arrays.parallelSetAll(parallelSetAll, i -> i * i);
    System.out.println(Arrays.toString(parallelSetAll));
  }
}
