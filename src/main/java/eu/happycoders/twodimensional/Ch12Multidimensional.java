package eu.happycoders.twodimensional;

import java.lang.reflect.Array;
import java.util.Arrays;

/** 3D arrays, and creating a multidimensional array with its dimensions known only at runtime. */
public class Ch12Multidimensional {

  static void main() {
    int[][][] cube = new int[2][3][4];
    cube[1][2][3] = 42;
    System.out.println("cube = " + Arrays.deepToString(cube));
    System.out.println(
        "cube.length = "
            + cube.length
            + ", cube[0].length = "
            + cube[0].length
            + ", cube[0][0].length = "
            + cube[0][0].length);

    int[][][] literal = {{{1, 2}, {3, 4}}, {{5, 6}, {7, 8}}};
    System.out.println("literal[1][0][1] = " + literal[1][0][1]);

    int[][] viaReflection = (int[][]) Array.newInstance(int.class, 2, 3);
    System.out.println("viaReflection = " + Arrays.deepToString(viaReflection));
  }
}
