package eu.happycoders.twodimensional;

/**
 * The number of rows is the length of the outer array, the number of columns that of a row - which
 * needs a row 0 that is not null.
 */
public class Ch5Length {

  static void main() {
    int[][] intMatrix = {{2, 3, 6}, {4, 5, 1}};
    int rows = intMatrix.length;
    int columns = intMatrix[0].length;
    System.out.println("rows = " + rows + ", columns = " + columns);

    int[][] empty = new int[0][];
    System.out.println("empty.length = " + empty.length);
    try {
      System.out.println(empty[0].length);
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println(e);
    }

    int[][] rowsNotAssigned = new int[2][];
    try {
      System.out.println(rowsNotAssigned[0].length);
    } catch (NullPointerException e) {
      System.out.println(e);
    }
  }
}
