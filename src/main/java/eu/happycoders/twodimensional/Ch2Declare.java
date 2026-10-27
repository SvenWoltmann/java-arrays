package eu.happycoders.twodimensional;

/** Declaring 2D arrays: the brackets at the type (recommended) or, C-style, at the name. */
public class Ch2Declare {

  static void main() {
    int[][] intMatrix;
    String[][] stringMatrix;

    int cStyleMatrix[][];
    int[] mixedMatrix[];

    intMatrix = new int[2][3];
    stringMatrix = new String[2][3];
    cStyleMatrix = new int[2][3];
    mixedMatrix = new int[2][3];
    System.out.println(
        intMatrix.length + stringMatrix.length + cStyleMatrix.length + mixedMatrix.length);
  }
}
