package eu.happycoders.initialize;

import java.util.Arrays;

/** Declaring arrays, initializing them with values or with a length, and their default values. */
public class Ch1Declare {

  static void main() {
    withValues();
    separately();
    withLength();
    defaultValues();
  }

  private static void withValues() {
    int[] winningNumbers = new int[] {14, 17, 29, 32, 45, 1, 2};
    String[] fruits = new String[] {"cherry", "papaya", "huckleberry"};
    System.out.println("winningNumbers = " + Arrays.toString(winningNumbers));
    System.out.println("fruits = " + Arrays.toString(fruits));

    var winningNumbersVar = new int[] {14, 17, 29, 32, 45, 1, 2};
    int[] winningNumbersShort = {14, 17, 29, 32, 45, 1, 2};
    int winningNumbersCStyle[] = {14, 17, 29, 32, 45, 1, 2};
    System.out.println(
        "all equal: "
            + (Arrays.equals(winningNumbers, winningNumbersVar)
                && Arrays.equals(winningNumbers, winningNumbersShort)
                && Arrays.equals(winningNumbers, winningNumbersCStyle)));
  }

  private static void separately() {
    int[] winningNumbers;
    // . . .
    winningNumbers = new int[] {14, 17, 29, 32, 45, 1, 2};
    System.out.println("winningNumbers = " + Arrays.toString(winningNumbers));
  }

  private static void withLength() {
    int[] intArray = new int[10];
    System.out.println("new int[10] = " + Arrays.toString(intArray));
  }

  private static void defaultValues() {
    System.out.println("byte:    " + Arrays.toString(new byte[3]));
    System.out.println("short:   " + Arrays.toString(new short[3]));
    System.out.println("int:     " + Arrays.toString(new int[3]));
    System.out.println("long:    " + Arrays.toString(new long[3]));
    System.out.println("float:   " + Arrays.toString(new float[3]));
    System.out.println("double:  " + Arrays.toString(new double[3]));
    char[] chars = new char[3];
    System.out.println("char:    U+%04X".formatted((int) chars[0]));
    System.out.println("boolean: " + Arrays.toString(new boolean[3]));
    System.out.println("String:  " + Arrays.toString(new String[3]));
  }
}
