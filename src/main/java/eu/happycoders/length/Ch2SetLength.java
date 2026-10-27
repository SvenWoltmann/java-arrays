package eu.happycoders.length;

import java.util.Arrays;

/** The length of an array is set when it is created - with values or with a size. */
public class Ch2SetLength {

  static void main() {
    String[] fruits = {"jujube", "apple", "boysenberry", "cherry"};
    String[] emptyFruits = new String[4];
    System.out.println(fruits.length + " " + Arrays.toString(fruits));
    System.out.println(emptyFruits.length + " " + Arrays.toString(emptyFruits));

    int[][] twoDimensionalArray = {{2, 3, 6}, {4, 5, 1, 9, 7}};
    int[][] zeroMatrix = new int[2][3];
    System.out.println(Arrays.deepToString(twoDimensionalArray));
    System.out.println(Arrays.deepToString(zeroMatrix));
  }
}
