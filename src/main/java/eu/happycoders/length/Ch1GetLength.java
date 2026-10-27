package eu.happycoders.length;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.Locale;

/** The length of an array, of an array known only as Object, and of a 2D array. */
public class Ch1GetLength {

  static void main() {
    String[] names = getNames();
    int numberOfNames = names.length;
    System.out.println("numberOfNames = " + numberOfNames);

    Object array = names;
    System.out.println("Array.getLength(array) = " + Array.getLength(array));

    int[][] intMatrix = getMatrix();
    int height = intMatrix.length;
    int width = intMatrix[0].length;
    System.out.println("height = " + height + ", width = " + width);

    int[][] twoDimensionalArray = {{2, 3, 6}, {4, 5, 1, 9, 7}};
    IntSummaryStatistics statistics =
        Arrays.stream(twoDimensionalArray).mapToInt(row -> row.length).summaryStatistics();

    // IntSummaryStatistics.toString() formats the average with the default locale
    Locale.setDefault(Locale.ENGLISH);
    System.out.println(statistics);
    Locale.setDefault(Locale.GERMAN);
    System.out.println(statistics);
  }

  private static String[] getNames() {
    return new String[] {"Anna", "Ben", "Clara", "David"};
  }

  private static int[][] getMatrix() {
    return new int[][] {{2, 3, 6}, {4, 5, 1}};
  }
}
