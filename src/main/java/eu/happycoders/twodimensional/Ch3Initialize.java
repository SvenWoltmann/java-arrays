package eu.happycoders.twodimensional;

import java.util.Arrays;

/** Initializing 2D arrays: with values, with default values, and row by row. */
public class Ch3Initialize {

  static void main() {
    withValues();
    withDefaultValues();
    rowByRow();
  }

  private static void withValues() {
    int[][] intMatrix = {{2, 3, 6}, {4, 5, 1}};
    System.out.println("intMatrix = " + Arrays.deepToString(intMatrix));

    int[][] withNew = new int[][] {{2, 3, 6}, {4, 5, 1}};
    var withVar = new int[][] {{2, 3, 6}, {4, 5, 1}};
    System.out.println("withNew = " + Arrays.deepToString(withNew));
    System.out.println("withVar = " + Arrays.deepToString(withVar));

    int[][] declaredFirst;
    declaredFirst = new int[][] {{2, 3, 6}, {4, 5, 1}};
    System.out.println("declaredFirst = " + Arrays.deepToString(declaredFirst));
  }

  private static void withDefaultValues() {
    int[][] intMatrix = new int[2][3];
    System.out.println("new int[2][3] = " + Arrays.deepToString(intMatrix));

    String[][] stringMatrix = new String[2][3];
    System.out.println("new String[2][3] = " + Arrays.deepToString(stringMatrix));

    intMatrix[0][0] = 2;
    intMatrix[0][1] = 3;
    intMatrix[0][2] = 6;
    intMatrix[1][0] = 4;
    intMatrix[1][1] = 5;
    intMatrix[1][2] = 1;
    System.out.println("filled = " + Arrays.deepToString(intMatrix));
  }

  private static void rowByRow() {
    int[][] intMatrix = new int[2][];
    System.out.println("new int[2][] = " + Arrays.deepToString(intMatrix));

    intMatrix[0] = new int[] {2, 3, 6};
    intMatrix[1] = new int[] {4, 5, 1};
    System.out.println("rows assigned = " + Arrays.deepToString(intMatrix));
  }
}
